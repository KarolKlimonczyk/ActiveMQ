package com.jvmfy.activemq.producer;

import com.jvmfy.activemq.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Slf4j
@Component
public class Producer implements CommandLineRunner {

    private final JmsMessagingTemplate jmsMessagingTemplate;
    private final Queue queue;

    public Producer(JmsMessagingTemplate jmsMessagingTemplate, Queue queue) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.queue = queue;
    }

    @Override
    public void run(String... args) throws Exception {
        this.send(new Message("title", "activemq"));
        log.info("Message sent.");
    }

    private void send(Message msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }
}
