package com.mmxin.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author : mmxin
 * @className : HttpSessionRedisConfig
 * @date : 2018/10/11 17:34
 * todo: HttpSessionStrategy 类找不到，回去查找原因
 */
public class HttpSessionRedisConfig {

    @Bean
    public HttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy cookieStrategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("NAME");
        cookieSerializer.setCookieMaxAge(1800);
        cookieStrategy.setCookieSerializer(cookieSerializer);
        return cookieStrategy;
    }
}
