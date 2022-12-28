package com.gustavonascimento.horaDoDuelo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gustavonascimento.horaDoDuelo.entities.Atributos;
import com.gustavonascimento.horaDoDuelo.entities.Carta;
import com.gustavonascimento.horaDoDuelo.repository.RepositorioCarta;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private RepositorioCarta repoCarta;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Carta c1=new Carta(null, "Bulbasaur",new Atributos(null,45, 49, 49, 45,65, 65));
		repoCarta.save(c1);
		Carta c2=new Carta(null, "Charmander",new Atributos(null,39, 52, 43, 65,60, 50));
		repoCarta.save(c2);
	}
}