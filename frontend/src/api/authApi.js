import apiClient from "./apiClient";

export const login = async (credentials) => {
  const response = await apiClient.post("/auth/login", credentials);
  return response.data;
};

export const register = async (userData) => {
  const response = await apiClient.post("/auth/register", userData);
  return response.data;
};

// Add this function:
export const verifyCode = async (verificationData) => {
  const response = await apiClient.post("/auth/verify", verificationData);
  return response.data;
};