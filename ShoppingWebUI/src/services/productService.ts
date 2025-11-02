import api from "../utils/api";

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  category: string;
  imageUrl?: string;
}

export interface CreateProductRequest {
  name: string;
  description: string;
  price: number;
  category: string;
  imageUrl?: string;
}

export interface UpdateProductRequest extends Partial<CreateProductRequest> {
  id: number;
}

export const productService = {
  async getAllProducts(): Promise<Product[]> {
    const response = await api.get<Product[]>("/products");
    return response.data;
  },

  async getProductById(id: number): Promise<Product> {
    const response = await api.get<Product>(`/products/${id}`);
    return response.data;
  },

  async createProduct(product: CreateProductRequest): Promise<Product> {
    const response = await api.post<Product>("/products", product);
    return response.data;
  },

  async updateProduct(product: UpdateProductRequest): Promise<Product> {
    const response = await api.put<Product>(`/products/${product.id}`, product);
    return response.data;
  },

  async deleteProduct(id: number): Promise<void> {
    await api.delete(`/products/${id}`);
  },

  async getProductsByCategory(category: string): Promise<Product[]> {
    const response = await api.get<Product[]>(`/products/category/${category}`);
    return response.data;
  },
};
