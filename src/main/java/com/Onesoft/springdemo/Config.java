package com.Onesoft.springdemo;
import org.springframework.context.annotation.Bean;
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

public class Config {
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails userDetails = User.withUsername("ashok").password(passwordEncoder().encode("user")).roles("user")
				.build();
		UserDetails adminDetails = User.withUsername("selvan").password(passwordEncoder().encode("admin")).roles("admin")
				.build();

		return new InMemoryUserDetailsManager(userDetails, adminDetails);
	}

	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity httpsecurity) throws Exception {
		httpsecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/user")
		.hasRole("user")
		.requestMatchers("/api/admin")
		.hasRole("admin")
		.requestMatchers("/api/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpsecurity.build();
	}

}
