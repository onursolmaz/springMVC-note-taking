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
        email.setFrom("onursolmaz79@gmail.com");
        email.setTo(mail);
        email.setSubject("Üyeliğini tamamla");
        email.setText("Üyeliği tamamlamak için lütfen aşağıdaki linke tıklayınız.\n\n"
                + HomeController.url+"/reg/"+key);
        mailSender.send(email);

    }
}
