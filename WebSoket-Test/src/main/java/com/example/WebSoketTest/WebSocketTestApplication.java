package com.example.WebSoketTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WebSocketTestApplication implements CommandLineRunner {
	@Autowired
	private SendingMessages sendingMessages;

	public static void main(String[] args) {
		SpringApplication.run(WebSocketTestApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0;true; i++) {
			try {
				sendingMessages.sendMessages("Сообщение номер: "+ i);
				TimeUnit.SECONDS.sleep(1);
			}catch (Exception ignore){}
		}
	}
}
