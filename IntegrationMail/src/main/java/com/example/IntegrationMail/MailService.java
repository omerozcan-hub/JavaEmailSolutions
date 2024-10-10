package com.example.IntegrationMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.mail.MailHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MessageChannel mailChannel;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendEmail(String to, String subject, String body) {
        mailChannel.send(MessageBuilder
                .withPayload(body)
                .setHeader(MailHeaders.TO, to)
                .setHeader(MailHeaders.FROM, senderEmail)
                .setHeader(MailHeaders.SUBJECT, subject)
                .build());
    }
}
