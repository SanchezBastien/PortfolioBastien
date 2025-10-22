package com.bastien.PortfolioBastien;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    @Autowired private JavaMailSender mailSender;


    public void sendContactEmail(String fromName, String fromEmail, String messageContent) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mime = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mime, "UTF-8");
        helper.setFrom("sanchez.bastien34@gmail.com");
        helper.setTo("sanchez.bastien34@gmail.com");
        helper.setReplyTo(fromEmail, fromName);
        helper.setSubject("Nouveau message du portfolio - " + fromName);
        helper.setText(
                "Nom : " + fromName + "\nEmail : " + fromEmail + "\n\nMessage :\n" + messageContent,
                false
        );
        mailSender.send(mime);
    }
}
