package com.ecosistema.gateway.security;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

	private final WebClient.Builder webClientBuilder;	
	
	public AuthFilter(WebClient.Builder webClientBuilder) {
		super(Config.class);
		this.webClientBuilder = webClientBuilder;
	}
	
	@Override
	public GatewayFilter apply(Config config) {		
		return (exchange, chain) -> {
			
			if(!exchange.getRequest().getHeaders().containsKey("Authorization")) {
				throw new RuntimeException("Seguridad incompleta");
			}
			String token = exchange.getRequest().getHeaders().get("Authorization").get(0);
			
			if(!token.contains("Bearer ")) {
				throw new RuntimeException("Seguridad incompleta");
			}
			
			token = token.replace("Bearer ", "");
			
			return webClientBuilder.build()
					.post()
					.uri("http://login-service/login/validateToken?token="+token)
					.retrieve().bodyToMono(CredencialesDto.class)
					.map(user -> {
						exchange.getRequest()
							.mutate()
							.header("elUsuario", user.getUser());
						return exchange;
					}).flatMap(chain::filter);
		};
	}
	
	public static class Config{}

}
