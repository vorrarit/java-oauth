package com.example.javaoauthserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class CustomAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("client")
				.authorizedGrantTypes("password", "client_credentials", "authorization_code", "refresh_token")
				.secret("{noop}secret")
				.scopes("all");
	}
}