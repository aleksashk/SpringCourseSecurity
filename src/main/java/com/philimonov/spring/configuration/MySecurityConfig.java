package com.philimonov.spring.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("aleksandr").password("aleksandr").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("elena").password("elena").roles("HR"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("zaur").password("zaur").roles("MANAGER", "HR"));
    }
}
