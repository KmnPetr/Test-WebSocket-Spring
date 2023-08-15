package com.example.WebSoketTest;

import org.springframework.web.socket.*;

import java.io.IOException;

public class MyHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket соединение установлено: " + session.getId());
        try {
            session.sendMessage(new TextMessage("Привет, клиент!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
            System.out.println("Получено сообщение от клиента: " + message.getPayload());
            try {
                session.sendMessage(new TextMessage("Спасибо за ваше сообщение: " + message.getPayload()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("WebSocket соединение закрыто: " + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
