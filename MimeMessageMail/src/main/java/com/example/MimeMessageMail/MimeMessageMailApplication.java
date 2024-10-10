package com.example.MimeMessageMail;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@SpringBootApplication
public class MimeMessageMailApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${receiverMail}")
	private String receiver;

	@Value("${spring.mail.username}")
	private String sender;

	public static void main(String[] args) {
		SpringApplication.run(MimeMessageMailApplication.class, args);
	}

	@Override
	public void run(String... args){
		sendHtmlEmail();
	}

	public String sendEmailWithAttachment() {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(sender);
			helper.setTo(receiver);
			helper.setSubject("Java email with attachment");
			helper.setText("Please find the attached documents below");

			helper.addAttachment("a.jpg", new ClassPathResource("assets/a.jpg"));
			helper.addAttachment("a.mp4", new ClassPathResource("assets/a.mp4"));

			javaMailSender.send(message);
			return "success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String sendHtmlEmail() {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(sender);
			helper.setTo(receiver);
			helper.setSubject("Java email with html");

			try (var inputStream = new ClassPathResource("assets/email.html").getInputStream()) {
				helper.setText(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8), true);
			}

			helper.addInline("a.jpg", new ClassPathResource("assets/a.jpg"));
			javaMailSender.send(message);

			return "success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
