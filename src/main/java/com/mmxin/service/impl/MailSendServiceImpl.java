package com.mmxin.service.impl;

import com.mmxin.service.MailSenderService;
import com.mmxin.service.RandomNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.util.Date;

/**
 * @author : mmxin
 * @className : MailSendServiceImpl
 * @date : 2018/11/3 10:11
 */
@Service
public class MailSendServiceImpl implements MailSenderService {

    Logger log = LoggerFactory.getLogger(MailSendServiceImpl.class);

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    RandomNumberService randomNumberService ;

    @Value("${spring.mail.username}")
    String fromMail;

    @Override
    public String send(String mail,String[] copyTo) {
        this.log.info("start to send mail to " + mail);
        Date startTime = new Date();
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            //发给谁
            message.setTo(mail);
            //抄送给谁
            message.setCc(copyTo);
            //主题
            message.setSubject("welcome to Always close to you");
            //内容
            message.setText("        您的验证码是： "+randomNumberService.redomNumber() +"  。 当前验证码5分钟内有效。 ");
            //发送邮件
            javaMailSender.send(message);

            log.info("Send Mail success , cost {} million seconds",new Date().getTime() - startTime.getTime());
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            log.error(e.getMessage());
            log.info("Send Mail failed , cost {} million seconds",new Date().getTime() - startTime.getTime());

        }
        return null;
    }
}
