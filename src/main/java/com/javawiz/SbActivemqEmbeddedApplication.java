package com.javawiz;

import com.javawiz.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class SbActivemqEmbeddedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbActivemqEmbeddedApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(OrderPublisher orderPublisher) throws Exception {
		return args -> {
			log.info("Spring Boot Embedded ActiveMQ Configuration Example");

			for (int i = 0; i < 5; i++) {
				Order myMessage = Order.builder()
						.content(i + " - Sending JMS Message using Embedded activeMQ")
						.timestamp(LocalDate.now()).build();
				orderPublisher.send(myMessage);
			}

			log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
			TimeUnit.SECONDS.sleep(3);
		};
	}

}
