package com.mmxin.configure;

/**
 * @author : mmxin
 * @className : ReturnCodeEnum
 * @date : 2018/11/9 10:26
 */
public class ReturnCodeEnum {

    //注册成功
    public static String register_success = "SUCCESS";
    //验证码超时
    public static String register_overTime = "OVERTIME";
    //邮箱已被注册
    public static String register_emailInuse = "EMAIL_INUSE";
    //用户名已被注册
    public static String register_userNameInuse = "USERNAME_INUSE";
    //错误的手机号
    public static String register_wrongPhone = "WRONGPHONE";
    //错误的验证码
    public static String register_wrongIdentify = "WRONGIDENTIFY";

    //邮件发送成功
    public static String MailSenderSuccess = "SUCCESS";
    //邮件发送失败
    public static String MailSenderFailed = "FAILED";

}
