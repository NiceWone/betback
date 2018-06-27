package ru.local.betback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;

    private final TokenAuthFilter tokenAuthFilter;

    @Autowired
    public WebSecurityConfig(AuthenticationProvider authenticationProvider, TokenAuthFilter tokenAuthFilter) {
        this.authenticationProvider = authenticationProvider;
        this.tokenAuthFilter = tokenAuthFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/api/login", "/api/signUp").permitAll()
                .antMatchers("/api/**").hasAuthority("USER")
                .and()
                .cors()
                .and()
                .csrf().disable();// TODO: 23/06/2018 WATDAFUCK?
    }
}