package br.com.cs.learning.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomSecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthProvider customAuthenticationProvider;

	// DEFINES THE AUTH METHODS THAT IS GOING TO BE USED
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// HTTP BASIC METHOD
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}

	// DEFINES THE USER DETAILS MANAGER
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
//		UserDetails userDetails = User.withUsername("admin").password(encoder.encode("123")).authorities("read")
//				.build();
//		userDetailService.createUser(userDetails);
//
//		auth.userDetailsService(userDetailService).passwordEncoder(encoder);
//
//	}

	// USES A CUSTOM AUTH PROVIDER
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(customAuthenticationProvider);
	}

}
