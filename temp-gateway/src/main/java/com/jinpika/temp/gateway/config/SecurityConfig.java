package com.jinpika.temp.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // 公共路径允许所有人访问
                .anyRequest().authenticated() // 其他请求需要认证
                .and()
                .oauth2Login() // 配置 OAuth2 登录
                .and()
                .oauth2ResourceServer()
                .jwt(); // 配置 JWT 资源服务器
    }
}

