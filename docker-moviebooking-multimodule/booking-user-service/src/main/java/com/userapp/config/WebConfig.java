package com.userapp.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
@Configuration
public class WebConfig {
	
	private final JwtRequestFilter jwtRequestFilter;
	
	private final JwtAuthenticationEntryPoint authenticationEntryPoint;
	
public WebConfig(JwtRequestFilter jwtRequestFilter, JwtAuthenticationEntryPoint authenticationEntryPoint) {
		
		this.jwtRequestFilter = jwtRequestFilter;
		this.authenticationEntryPoint = authenticationEntryPoint;
	}
//	// authentication bean
//	@Bean
//	UserDetailsService userDetailsService() {
//		return new  JwtUserServiceImpl();
//	}
	
	// password encoder
	 @Bean
	 PasswordEncoder encoder(){
		 return new BCryptPasswordEncoder();
	 }
	// authentication manager bean
	 @Bean
		AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
			return config.getAuthenticationManager();
		}
	 
	//authorization bean
	 @Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			 .csrf(csrf->csrf.disable())
		 	 .authorizeHttpRequests(httpRequest-> httpRequest
		 		.requestMatchers("/users-service/v1/register","/users-service/v1/login").permitAll()
		 		// authorize users with role as admin and user
		 		.requestMatchers("/movies-service/v1/movies/**","/shows-service/v1/shows/**","/theatres-service/v1/theatres/**","/bookings-service/v1/bookings/**","/users-service/v1/users/**").hasAnyAuthority("ADMIN","USER")
		 		// authorize users with role as admin 
		 		.requestMatchers("/movies-service/v1/admin/**","/shows-service/v1/admin","/theatres-service/v1/admin","/bookings-service/v1/admin").hasAuthority("ADMIN")
		 		.anyRequest().authenticated())
		 	   // use Jwtauthenticationentry point to send errors
				 .exceptionHandling(configurer->configurer.authenticationEntryPoint(authenticationEntryPoint))
					
				 // session is stateless here - do not handle session- here each request is new 
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				// move to the filter in the flow
				// the requestfilter will be called before usernamepasswordfilter
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		 	 
		 	 
		 	 
		 	 
		 
	
	 }
	 
	 
}
