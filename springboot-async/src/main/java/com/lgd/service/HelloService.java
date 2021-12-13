package com.lgd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HelloService {

    @Autowired
    JavaMailSender javaMailSender;

    @Scheduled(cron = "40 34 16 * * ?")
    public void Hellos(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("执行成功，现在是" +df.format(new Date()));
    }
    @Async
    public void Hello(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("消息正在发送.....");
    }


    public void contextLoads2(boolean html,String subject,String text) throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);

        helper.setSubject(subject);
        helper.setText(text,html);

        //发送附件
//        helper.addAttachment("1.jpg",new File("C:\\Users\\Asus\\Pictures\\Saved Pictures\\Ren.jpg"));

        helper.setTo("1017276522@qq.com");
        helper.setFrom("1017276522@qq.com");

        javaMailSender.send(mimeMessage);
    }
}