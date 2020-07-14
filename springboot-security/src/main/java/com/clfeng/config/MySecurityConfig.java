package com.clfeng.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author qian
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/level1/**")
                .hasRole("vip1")
                .antMatchers("/level2/**")
                .hasRole("vip2")
                .antMatchers("/level3/**")
                .hasRole("vip3");

        //没有权限，默认去登录页，需要开启登录的页面
        http.formLogin();
    }

    /**
     * 认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("clfeng")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip2", "vip3")
                .and()
                .withUser("root")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip1", "vip3")
                .and()
                .withUser("guest")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("vip1", "vip2");
    }
}
