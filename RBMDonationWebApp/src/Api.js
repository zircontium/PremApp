import axios from "axios";
export const baseUrl = "http://localhost:8080";

export const AddUserApi = async () => {
    const { data } = await axios.put(`${baseUrl}/AddUser`);
    return data;
  };
  

export const openPort = async (id, params) => {
  const { data } = await axios.post(`${baseUrl}/openTCP?id=${id}&ip=${params.ip}&port=${params.port}`);
  return data;
};

export const closePort = async (id, params) => {
  const { data } = await axios.post(`${baseUrl}/closeTCP?id=${id}`);
  return data;
};

export const startTCP = async (id, params) => {
  const { data } = await axios.post(`${baseUrl}/startTCP?id=${id}`);
  return data;
};

export const stopTCP = async (id, params) => {
  const { data } = await axios.post(`${baseUrl}/stopTCP?id=${id}`);
  return data;
};
