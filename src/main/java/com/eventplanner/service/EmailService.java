package com.eventplanner.service;

import com.eventplanner.domain.EventUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by DanielB on 2/21/2017.
 */
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public boolean sendVerificationEmail(String email) {
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(email);
            helper.setReplyTo("SimplePlannerEmail@gmail.com");
            helper.setFrom("SimplePlannerEmail@gmail.com");
            helper.setSubject("SimplePlanner User Verification");
            helper.setText("This works!");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        mailSender.send(mail);
        return true;
    }

}
