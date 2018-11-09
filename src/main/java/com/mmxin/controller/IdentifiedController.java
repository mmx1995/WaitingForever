package com.mmxin.controller;

import com.mmxin.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/identify")
public class IdentifiedController {

    @Autowired
    MailSenderService mailSenderService;

    @GetMapping("/{mail}")
    public @ResponseBody String send(@PathVariable("mail") String mail){
        mailSenderService.send(mail,null);
        return "1";
    }

}
