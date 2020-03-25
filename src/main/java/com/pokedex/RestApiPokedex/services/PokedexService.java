package com.pokedex.RestApiPokedex.services;
 import com.pokedex.RestApiPokedex.document.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PokedexService {
	
	Flux<Pokedex> findAll();
	Mono<Pokedex> findById(String Id);
	Mono<Pokedex> save(Pokedex pokedex);

}
