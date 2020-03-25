package com.pokedex.RestApiPokedex.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pokedex.RestApiPokedex.document.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.RestApiPokedex.services.PokedexService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PokedexController {

	@Autowired
	PokedexService service;
	
	
	@GetMapping(value="/pokedex")
	public Flux<Pokedex> getPokedex() {
		return service.findAll();
	}
	
	@GetMapping(value="/pokedex/{Id}")
	public Mono<Pokedex> getPokedexId(@PathVariable String Id) 
	{
		return service.findById(Id);
	}
	
	@PostMapping(value="/pokedex")
	public Mono<Pokedex> save (@RequestBody Pokedex pokedex) {
		return service.save(pokedex);
	}
	

	@GetMapping(value="/pokedex/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public  Flux<Tuple2<Long, Pokedex>> getPokedexByEvents() {
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		Flux<Pokedex> events = service.findAll();
		System.out.println("OLHA O EVENTS PASSANDO AQUIIIIIII");
		return Flux.zip(interval, events);
	}

	
	
}
