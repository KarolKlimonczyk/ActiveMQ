package com.jvmfy.activemq.receiver;

import com.jvmfy.activemq.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @JmsListener(destination = "message.queue", containerFactory = "jmsListenerContainerFactory")
    public void receive(Message message) {
        log.info("Message received. {}", message);
    }
}
