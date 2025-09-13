package com.bastien.PortfolioBastien;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String fromName, String fromEmail, String messageContent) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("sanchez.bastien34@gmail.com"); // expéditeur validé sur Brevo
        message.setTo("sanchez.bastien34@gmail.com");   // destinataire

        message.setSubject("Nouveau message du portfolio - " + fromName);
        message.setText("Nom : " + fromName + "\nEmail : " + fromEmail + "\n\nMessage :\n" + messageContent);

        System.out.println(">>> Tentative d'envoi du mail via Brevo...");

        mailSender.send(message);

        System.out.println(">>> Mail envoyé avec succès !");
    }
}
