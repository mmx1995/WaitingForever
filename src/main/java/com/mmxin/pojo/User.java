package com.mmxin.pojo;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : mmxin
 * @className : User
 * @date : 2018/9/5 15:49
 */
@Entity // 实体
public class User implements Serializable,UserDetails {

    private static final long serialVersionUID = 4393626410876291381L;
    /**
     * 用户实体类唯一标识
     * 数据库自增
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    /**
     * 手机号
     * */
    @org.hibernate.validator.constraints.NotEmpty(message = "手机号不能为空")
    @Size(max = 13,min = 11)
    private String phoneNum ;

    /**
     * 用户姓名
     * */
    @org.hibernate.validator.constraints.NotEmpty(message = "姓名不能为空")
    @Size(max = 20, min = 2)
    @Column(nullable = false,length = 20)  //映射为字段，值不能为空
    private String userName;

    /**
     * 用户邮箱
     * 最大长度不超过50
     * */
    @org.hibernate.validator.constraints.NotEmpty(message = "邮箱不能为空")
    @Size(max=50)
    @Email(message= "邮箱格式不对" )
    @Column(nullable = false, length = 50, unique = true)
    private String email ;

    /*
     * 用户头像信息
     * 记录头像链接
     * */
    @Column(length = 200)
    private String avatar;

    /*
     * 密码
     * 最大长度100
     * */
    @org.hibernate.validator.constraints.NotEmpty(message = "密码不能为空")
    @Size(max=100)
    @Column(length = 100)
    private String password ;

    /**
     * 性别
     * */
    @org.hibernate.validator.constraints.NotEmpty(message = "密码不能为空")
    @Column(length = 4)
    private String sex ;


    /**
     * 权限管理列表
     * 多对多
     * */
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
    /**
     * 空构造函数
     * */
    public User() {
    }

    public User(@org.hibernate.validator.constraints.NotEmpty(message = "手机号不能为空") @Size(max = 13, min = 11) String phoneNum, @org.hibernate.validator.constraints.NotEmpty(message = "姓名不能为空") @Size(max = 20, min = 2) String userName, @org.hibernate.validator.constraints.NotEmpty(message = "邮箱不能为空") @Size(max = 50) @Email(message = "邮箱格式不对") String email, String avatar, @org.hibernate.validator.constraints.NotEmpty(message = "密码不能为空") @Size(max = 100) String password, @org.hibernate.validator.constraints.NotEmpty(message = "密码不能为空") String sex, List<Authority> authorities) {
        this.phoneNum = phoneNum;
        this.userName = userName;
        this.email = email;
        this.avatar = avatar;
        this.password = password;
        this.sex = sex;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    /*****************************************************************************************************************/
    /**
     * 一下部分为权限管理模块引入的方法
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        for(GrantedAuthority authority : this.authorities){
            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
