package com.mmxin.factory;

import com.mmxin.mapper.MenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.Reader;

/**
 * @author : mmxin
 * @className : DBFactory
 * @date : 2018/9/20 11:30
 */
public class DBFactory {
    public static SqlSessionFactory sessionFactory ;

    static {
        try{
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //创建能执行映射文件中sql 的sqlSession
    @Bean
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}
