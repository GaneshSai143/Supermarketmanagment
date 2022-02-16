package com.example.demo.security.config.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	


    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/secured/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests().antMatchers("/oauth/token","/customerregister").permitAll()
    	.antMatchers("/users","/outlets/**","/products/**").hasAnyAuthority("ROLE_SUPER_ADMIN")
    	.antMatchers("/shops").hasAnyAuthority("ROLE_OUTLET_ADMIN")
    	.antMatchers("/orders","/customer").hasAnyAuthority("ROLE_CUSTOMER")	
    	.anyRequest()
    	.authenticated()
    	.and().formLogin().disable();
    }


}

