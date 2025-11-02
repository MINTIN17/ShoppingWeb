import { useState, useCallback } from "react";

interface ApiState<T> {
  data: T | null;
  loading: boolean;
  error: string | null;
}

export function useApi<T>() {
  const [state, setState] = useState<ApiState<T>>({
    data: null,
    loading: false,
    error: null,
  });

  const execute = useCallback(
    async <P extends any[]>(
      apiCall: (...args: P) => Promise<T>,
      ...args: P
    ): Promise<T | null> => {
      setState({ data: null, loading: true, error: null });

      try {
        const result = await apiCall(...args);
        setState({ data: result, loading: false, error: null });
        return result;
      } catch (error: any) {
        const errorMessage =
          error.response?.data?.message || error.message || "An error occurred";
        setState({ data: null, loading: false, error: errorMessage });
        return null;
      }
    },
    []
  );

  const reset = useCallback(() => {
    setState({ data: null, loading: false, error: null });
  }, []);

  return {
    ...state,
    execute,
    reset,
  };
}
