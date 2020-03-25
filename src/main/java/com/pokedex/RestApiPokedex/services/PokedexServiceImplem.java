package com.pokedex.RestApiPokedex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.RestApiPokedex.document.Pokedex;
import com.pokedex.RestApiPokedex.repository.PokedexRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokedexServiceImplem implements PokedexService{

	@Autowired
	PokedexRepository pr;
	
	@Override
	public Flux<Pokedex> findAll() {
		return pr.findAll();
	}
	
	@Override
	public Mono<Pokedex> findById(String Id) {
		return pr.findById(Id);
	}
	
	@Override
	public Mono<Pokedex> save(Pokedex pokedex) {
		return pr.save(pokedex);
	}
}
