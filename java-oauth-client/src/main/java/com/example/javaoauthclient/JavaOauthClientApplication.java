package com.example.javaoauthclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Sso
public class JavaOauthClientApplication {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	public static void main(String[] args) {
		SpringApplication.run(JavaOauthClientApplication.class, args);
	}
}
