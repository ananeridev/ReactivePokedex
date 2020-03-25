package com.pokedex.RestApiPokedex;

import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import com.pokedex.RestApiPokedex.document.Pokedex;
import com.pokedex.RestApiPokedex.repository.PokedexRepository;


@Component
public class DummyData implements CommandLineRunner{
	
	
	private final PokedexRepository pokedexRepository;

	DummyData(PokedexRepository pokedexRepository) {

		this.pokedexRepository = pokedexRepository;
	}

	@Override
	public void run(String...args) throws Exception {

	pokedexRepository.deleteAll()
				.thenMany(
					Flux.just("Bulbasaur", "Venusaur", "Charmander" , "Charmeleon" , "Charizard" , "Squirtle", "Wartortle", "Blastoise", "Metapod")
					.map (nome -> new Pokedex (UUID.randomUUID().toString(), nome))
					.flatMap(pokedexRepository::save))
				
			.subscribe(System.out::println);
	}

	}

