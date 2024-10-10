package com.example.ThymeleafMail;

import jakarta.mail.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootApplication
public class ThymeleafMailApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Value("${receiverMail}")
	private String receiver;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafMailApplication.class, args);
	}

	@Override
	public void run(String... args){
		sendEmail(receiver,"Template engine - Thymeleaf",
				" This mail is created with template engine thymeleaf and java mail sender!!!");
	}

	public void sendEmail(String to, String subject, String body){
		Context context = new Context();
		context.setVariable("name","name");

		String htmlContent = templateEngine.process("emailTemplate", context);

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);
	}

}
