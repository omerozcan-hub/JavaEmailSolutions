package com.example.IntegrationMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.MailSendingMessageHandler;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationEmailConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;
    @Value("${receiverMail}")
    private String receiverMail;

    @Bean
    public MessageChannel mailChannel(){
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mailChannel")
    public MessageHandler mailHandler(){
        return new MailSendingMessageHandler(javaMailSender);
    }
}
