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
        http.authorizeHttpRequests((authz) -> authz.requestMatchers("/css/**", "/js/**")
                        .permitAll()
                        .requestMatchers("/applications")
                        .authenticated()
                        .requestMatchers("/logiciels")
                .hasAuthority ("ADMIN")
                        .requestMatchers("/insertlogicielform/")
                        .hasRole("ADMIN")
                        .requestMatchers("/insertlogiciel/")
                        .hasRole("ADMIN")
                        .requestMatchers("/logiciel/getall/")
                        .authenticated()
                        .anyRequest()
                        .authenticated()
                ).formLogin();
       //http.exceptionHandling().accessDeniedPage("/login");

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
        /*UserDetails user1 =User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("123"))
                .roles("USER")
                .build();

        UserDetails user2 =
                User.withUsername("admin")
                        .password(bCryptPasswordEncoder.encode("123"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));*/

    }

}

@Configuration
class BCryptEncoder {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
