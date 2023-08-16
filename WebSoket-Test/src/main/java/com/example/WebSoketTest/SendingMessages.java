package com.example.WebSoketTest;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SendingMessages {
    private static List<WebSocketSession> sessions = new ArrayList<>();

    public synchronized void addSession(WebSocketSession session){
        sessions.add(session);
        System.out.println("Соединение добавлено в список");
    }
    public synchronized void removeSession(WebSocketSession session){
        sessions.remove(session);
        System.out.println("Соединение удалено из списка");
    }
    public synchronized void sendMessages(String message){
        TextMessage textMessage = new TextMessage(message);
        sessions.forEach(it-> {
            try {
                it.sendMessage(textMessage);
            } catch (IOException e) {
                e.getMessage();
                e.printStackTrace();
            }
        });
    }
}
