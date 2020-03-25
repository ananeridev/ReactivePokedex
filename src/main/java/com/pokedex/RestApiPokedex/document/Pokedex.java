package com.pokedex.RestApiPokedex.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pokedex {
	
	@Id
	private String Id;
	private String nome;
	
	public Pokedex(String Id, String nome) {
		super();
		this.Id = Id;
		this.nome = nome;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
