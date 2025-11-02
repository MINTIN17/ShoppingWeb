import axios from "axios";

// Create axios instance with base configuration
const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  timeout: 10000,
  headers: {
    "Content-Type": "application/json",
  },
});

// Request interceptor for adding auth token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor for handling common errors and unwrapping standardized responses
api.interceptors.response.use(
  (response) => {
    // Unwrap standardized API response format
    if (
      response.data &&
      typeof response.data === "object" &&
      "success" in response.data
    ) {
      const { success, code, message, data, timestamp } = response.data;

      if (!success) {
        // Handle API-level errors
        const error = new Error(message || "API request failed");
        (error as any).response = { status: 400, data: { code, message } };
        return Promise.reject(error);
      }

      // Return unwrapped data
      return { ...response, data };
    }

    return response;
  },
  (error) => {
    if (error.response?.status === 401) {
      // Only redirect if user was already authenticated (token exists)
      // Don't redirect for login failures
      const token = localStorage.getItem("token");
      if (token) {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        window.location.href = "/";
      }
    }
    return Promise.reject(error);
  }
);

export default api;
