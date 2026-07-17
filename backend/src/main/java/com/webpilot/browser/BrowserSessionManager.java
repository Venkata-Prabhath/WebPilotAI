package com.webpilot.browser;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BrowserSessionManager {

    private final Map<String, BrowserSession> sessions = new ConcurrentHashMap<>();

    public void addSession(BrowserSession session) {
        sessions.put(session.getSessionId(), session);
    }

    public BrowserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

}