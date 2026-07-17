import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

let stompClient = null;

export const connectWebSocket = () => {
  const socket = new SockJS('http://localhost:8084/ws-browser');
  stompClient = new Client({
    webSocketFactory: () => socket,
    debug: (str) => console.log(str),
  });

  stompClient.activate();
  return stompClient;
};

export const disconnectWebSocket = () => {
  if (stompClient) {
    stompClient.deactivate();
  }
};