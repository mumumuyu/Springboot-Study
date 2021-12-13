package com.lgd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootAsyncApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("你好JavaMailSender");
        mailMessage.setText("hello world!!!");

        mailMessage.setTo("1017276522@qq.com");
        mailMessage.setFrom("1017276522@qq.com");
//        for (int i = 0; i < 2; i++) {
            javaMailSender.send(mailMessage);
//        }
    }

    @Test
    public void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-明天上午上课");
        helper.setText("<b style='color:red'>明天 8:00上课</b>",true);

        //发送附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Asus\\Pictures\\Saved Pictures\\Ren.jpg"));

        helper.setTo("1017276522@qq.com");
        helper.setFrom("1017276522@qq.com");

        javaMailSender.send(mimeMessage);
    }

}
