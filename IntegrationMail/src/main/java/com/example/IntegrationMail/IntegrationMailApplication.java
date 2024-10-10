package com.example.IntegrationMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationMailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationMailApplication.class, args);
	}

	@Autowired
	private MailService mailService;

	@Value("${receiverMail}")
	private String receiver;

	@Override
	public void run(String... args){
		mailService.sendEmail(receiver, "Spring Integration Test", "This is a Spring Integration Test Mail.");
	}
}
