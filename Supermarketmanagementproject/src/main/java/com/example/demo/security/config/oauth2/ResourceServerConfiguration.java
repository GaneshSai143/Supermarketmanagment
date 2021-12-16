package com.example.demo.security.config.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

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
    	http.csrf().disable().authorizeRequests().antMatchers("/api/get").permitAll()
    	.antMatchers("/customerregister","user/**").permitAll()
    	/*.antMatchers("/user").hasAnyAuthority("ROLE_SUPER_ADMIN")
    	.anyRequest()
    	.authenticated()*/.and().formLogin().disable();
                
    }
    }

