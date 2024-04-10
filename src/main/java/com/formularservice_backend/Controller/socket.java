package com.formularservice_backend.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class socket {

    private static final Logger logger = LoggerFactory.getLogger(socket.class);

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        try {
            // Hier kannst du die empfangene Nachricht verarbeiten
            return "Message received: " + message;
        } catch (Exception e) {
            logger.error("Error processing message: {}", e.getMessage(), e);
            return "Error processing message";
        }
    }
}
