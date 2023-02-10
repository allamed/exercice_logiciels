package com.example.exer.security;

import com.example.exer.services.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public final BCryptPasswordEncoder bCryptPasswordEncoder;

    public final UserService userService;

    public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        super();
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin();
        /*http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**", "/", "/url1/")
                        .permitAll()
                        .requestMatchers("/url2/")
                        .authenticated()
                        .requestMatchers("/url3/")
                        .hasAuthority("ADMIN")
                        .requestMatchers("/insertlogicielform/")
                        .hasAuthority("ADMIN")
                        .requestMatchers("/insertlogiciel/")
                        .hasAuthority("ADMIN")
                        .requestMatchers("/logiciel/getall/")
                        .authenticated()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin();
*/
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

}

@Configuration
class BCryptEncoder {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
