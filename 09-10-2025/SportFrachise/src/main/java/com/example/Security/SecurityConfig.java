package com.example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Service.CricketService;
import com.example.filter.AuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	AuthFilter jwtauthfilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity hs) throws Exception
    {
  	hs.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth->auth.requestMatchers("/authenticate").permitAll().anyRequest().authenticated());
    	hs.addFilterBefore(jwtauthfilter, UsernamePasswordAuthenticationFilter.class);
    	return hs.build();
    }
    @Bean
    public UserDetailsService userDetailservice()
    {
    	return new CricketService();
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService uds,PasswordEncoder pe)
    {
    	DaoAuthenticationProvider dap =new DaoAuthenticationProvider();
    	dap.setUserDetailsService(uds);
    	dap.setPasswordEncoder(pe);
    	return new ProviderManager(dap);
    	}
}
