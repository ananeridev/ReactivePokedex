package com.pokedex.RestApiPokedex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivePokedexApplication {

	public static void main (String[] args) {
		SpringApplication.run(ReactivePokedexApplication.class, args);
		System.out.print("hello reactive webflux");
		}

}
