package com.webpilot.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProgressWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public ProgressWebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendProgress(String taskId, String message) {
        messagingTemplate.convertAndSend(
                "/topic/progress/" + taskId,
                message
        );
    }

}