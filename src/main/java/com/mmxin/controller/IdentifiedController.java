package com.mmxin.controller;

import com.mmxin.tools.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/identified")
public class IdentifiedController {

    @GetMapping("/{mail}")
    public @ResponseBody String send(@PathVariable("mail") String mail){
        MailSender.getInstance().send(mail);
        return "1";
    }

}
