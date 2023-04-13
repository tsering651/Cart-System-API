package com.example.CartSystem.config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SecurityConfig {
	
	@Bean
	public UserDetailsService userdetailService() {
		UserDetails normalUser=User
				.withUsername("John")
				.password(passwordEncoder().encode("123456"))
				.roles("NORMAL")
				.build();
				
		UserDetails adminUser=User
				.withUsername("Henry")
				.password(passwordEncoder().encode("admin@123"))
				.roles("ADMIN")
				.build();
		
		InMemoryUserDetailsManager inmemoryuser=new InMemoryUserDetailsManager(normalUser,adminUser);
		
		  return inmemoryuser;
		
				
	}

 @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
	 httpsecurity.csrf().disable()
	 .authorizeHttpRequests()
	 .antMatchers("/api/v1/getAllItems")
	 .hasRole("NORMAL")
	 .antMatchers("/api/v1/getAllItems")
	 .hasRole("ADMIN")
	 .antMatchers("/api/v1/update")
	 .hasRole("ADMIN")
	 .antMatchers("/api/v1/delete")
	 .hasRole("ADMIN")
	 .anyRequest()
	 .authenticated()
	 .and()
	 .formLogin();
	  return httpsecurity.build();
  }
 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
	
    
}
