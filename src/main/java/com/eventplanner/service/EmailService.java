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
    private JavaMailSender javaMailSender;

    public boolean sendVerificationEmail(EventUser user) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(user.getEmail());
            helper.setReplyTo("SimplePlannerEmail@gmail.com");
            helper.setFrom("SimplePlannerEmail@gmail.com");
            helper.setSubject("SimplePlanner User Verification");
            helper.setText("Visit this link to activate your account: http://localhost:8080/register/" + user.getId());
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        javaMailSender.send(mail);
        return true;
    }

}
