package com.Services;


import com.Controllers.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;


    public void registerMail(String mail, String key){

        SimpleMailMessage email=new SimpleMailMessage();
        email.setFrom("onursolmaztest@gmail.com");
        email.setTo(mail);
        email.setSubject("Üyeligini Tamamla!");
        email.setText("Üyeligini tamamlamak için lütfen asagidaki linke tiklayiniz.\n\n"
                + HomeController.url+"/reg/"+key);
        mailSender.send(email);
    }
}
