package com.mmxin.controller;

import com.mmxin.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/identify")
public class IdentifiedController {

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping()
    public @ResponseBody String send(@RequestParam("email") String email){
        return mailSenderService.send(email,null);
    }

}
