import apiClient from "./apiClient";

export const executeBrowserCommand = async (command) => {
  const response = await apiClient.post("/browser/execute", { command });
  return response.data;
};