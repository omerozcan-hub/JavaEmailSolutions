package com.example.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JavaMailSenderApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("$receiverMail")
	private String recevier;

	public static void main(String[] args) {
		SpringApplication.run(JavaMailSenderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		sendEmail();
	}

	public void sendEmail(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recevier);
		message.setSubject("java mail sender try2");
		message.setText("This is try mail body from java mail sender.2");

		javaMailSender.send(message);
	}
}
