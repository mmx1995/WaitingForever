package com.mmxin.tools;

/*
*https://blog.csdn.net/xubin1623875795/article/details/78967141
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class MailSender {

    private JavaMailSender jms = new JavaMailSenderImpl();

    public String send(String toMail){
        //建立邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom("mmxin1234@sina.com");
        //接收者
        message.setTo(toMail);
        //发送的标题
        message.setSubject("欢迎注册异地恋主题论坛");
        //发送的内容
        message.setText("Hello World");
        //发送邮件
        jms.send(message);
        return "ok";
    }

    public static MailSender getInstance(){
        return new MailSender();
    }
}
