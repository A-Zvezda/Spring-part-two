package com.geekbrains.geekmarketwinter.utils;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class HttpSessionUtils {
    private static final Map<String, HttpSession> sessions = new HashMap<>();

    public void put (String sessionId, HttpSession httpSession) {
        sessions.put(sessionId, httpSession);
    }

    public void remove (String sessionId) {
        sessions.remove(sessionId);
    }

    public HttpSession findSession (String sessionId) {
        return sessions.get(sessionId);
    }

    public static Map<String, HttpSession> getSessions() {
        return sessions;
    }
}
