package de.smava.recrt.rest.config;

import de.smava.recrt.rest.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Alternative authentication with header authorization token
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/rest/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(authenticationProvider())
                .exceptionHandling()
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/rest/login", "DELETE"))
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .sessionManagement()
                .maximumSessions(1);

        http.getConfigurer(ExceptionHandlingConfigurer.class)
                .accessDeniedHandler(accessDeniedHandler);
    }
}