package com.example.AsyncMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class AsyncMailApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender	javaMailSender;

	@Value("${receiverMail}")
	private String receiver;

    public static void main(String[] args) {
		SpringApplication.run(AsyncMailApplication.class, args);
	}


	@Override
	public void run(String... args){
		sendAsyncMail(receiver,"async mail", "this is async mail body content.");
	}

	@Async
	public void sendAsyncMail(String to, String subject, String text){
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		javaMailSender.send(message);
	}

}
