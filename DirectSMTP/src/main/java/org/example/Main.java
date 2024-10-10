package org.example;

public class Main {
    public static void main(String[] args) {
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;
        String username = "sendermailadress@gmail.com"; // Gmail adresinizi buraya girin
        String password = "password"; // Gmail şifrenizi buraya girin


        EmailSender emailSender = new EmailSender(smtpHost, smtpPort, username, password);

        String to = "receiver@gmail.com"; // Alıcı e-posta adresi
        String subject = "Test Email - direct smtp"; // E-posta konusu
        String body = "<h1>Hello!</h1><p>This is a test email sent via JavaMail API.</p>"; // HTML içeriği

        emailSender.sendEmail(to, subject, body);
    }
}