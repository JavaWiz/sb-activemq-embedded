package com.javawiz;

import com.javawiz.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.javawiz.config.ActiveMQConfigurer.ORDER_QUEUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderPublisher {

    private final JmsTemplate jmsTemplate;

    public void send(Order myMessage) {
        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
        jmsTemplate.convertAndSend(ORDER_QUEUE, myMessage);
    }
}