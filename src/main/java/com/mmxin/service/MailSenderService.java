package com.mmxin.service;

/**
 * @author : mmxin
 * @className : MailSenderService
 * @date : 2018/11/3 10:10
 */
public interface MailSenderService {

    public static final String  SUCCESS = "01";

    public static final String FILED = "02";

    public String send(String mail,String[] copyTo);

}
