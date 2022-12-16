package com.example.policymanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Date;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String id, Date startDate) {
        MimeMessage message = javaMailSender.createMimeMessage();


        String toaddress="policymanagement9090@gmail.com";
        try {
            MimeMessageHelper messageHelper=new MimeMessageHelper(message, true);
            messageHelper.setTo(toaddress);
            messageHelper.setSubject("Policy Created");
            messageHelper.setText(" Dear Admin, \n" +
                    " The policy is successfully registered \n" +
                    " The policy "+id+" is available to the users from "+startDate+".  \n" +
                    "To add more Click the add policy button. \n");
            javaMailSender.send(message);
        }catch(MessagingException e){
            e.printStackTrace();
        }


    }
}
