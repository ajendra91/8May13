package com.example.Actualtor;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//ShutdownEndpoint
		http.authorizeRequests().requestMatchers(EndpointRequest.to(HealthEndpoint.class))
		.permitAll()
		.requestMatchers(EndpointRequest.toAnyEndpoint())
		.authenticated().and().httpBasic();
	}


	//http://localhost:9091/man/actuator/
	//username=>aa and password=pa

	
	
	
	
}
