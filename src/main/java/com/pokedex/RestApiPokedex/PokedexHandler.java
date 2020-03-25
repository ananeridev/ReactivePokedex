package com.pokedex.RestApiPokedex;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;



import com.pokedex.RestApiPokedex.document.Pokedex;
import com.pokedex.RestApiPokedex.services.PokedexService;

import reactor.core.publisher.Mono;

//@Component
public class PokedexHandler {
	
	@Autowired
	PokedexService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Pokedex.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String Id = request.pathVariable("Id");
		return ok()
				
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(Id), Pokedex.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Pokedex> pokedex = request.bodyToMono(Pokedex.class);
		return ok()
				
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(pokedex.flatMap(service::save), Pokedex.class));
	}

}
