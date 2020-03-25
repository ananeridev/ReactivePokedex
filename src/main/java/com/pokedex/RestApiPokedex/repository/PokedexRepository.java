package com.pokedex.RestApiPokedex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.pokedex.RestApiPokedex.document.Pokedex;

public interface PokedexRepository extends ReactiveMongoRepository <Pokedex, String>{

	
}
