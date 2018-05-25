package com.example.javaoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class JavaOauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaOauthServerApplication.class, args);
	}
}
