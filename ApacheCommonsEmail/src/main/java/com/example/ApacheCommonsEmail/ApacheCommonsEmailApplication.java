package com.example.ApacheCommonsEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheCommonsEmailApplication implements CommandLineRunner {

	//smtp config infos
	@Value("${receiverMail}")
	private String receiver;
	@Value("${smtp_host}")
	private String smtp_host;
	@Value("${smtp_port}")
	private int smtp_port;
	@Value("${smtp_username}")
	private String smtp_username;
	@Value("${smtp_password}")
	private String smtp_password;


	public static void main(String[] args) {
		SpringApplication.run(ApacheCommonsEmailApplication.class, args);
	}

	@Override
	public void run(String... args) throws EmailException {
		sendMail(receiver, "third party usage", "this email is coming with third party library![apache commons email]");
	}

	public void sendMail(String to, String subject, String body) throws EmailException {
		HtmlEmail email = new HtmlEmail();

		email.setHostName(smtp_host);
		email.setSmtpPort(smtp_port);
		email.setAuthentication(smtp_username,smtp_password);
		email.setSSLOnConnect(true);

		email.setFrom(smtp_username);
		email.addTo(to);
		email.setSubject(subject);
		email.setHtmlMsg(body);

		email.send();
	}

}
