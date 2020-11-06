package com.narval.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private SuccesHandler authSuccesHandler;

	@Autowired
    public void webSecurityConfig(SuccesHandler myAuthSuccesHandler) {
        this.authSuccesHandler = myAuthSuccesHandler;
    }
    
	
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers("/css/*").permitAll()
        .antMatchers(HttpMethod.POST, "/SignUp").permitAll()
    	.antMatchers("/SignUp").permitAll()
        .antMatchers("/img/*").permitAll()
        .antMatchers("/js/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        	.loginPage("/login").permitAll()
            .successHandler(authSuccesHandler)
        .and();
       
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}