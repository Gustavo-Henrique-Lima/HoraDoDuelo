package com.gustavonascimento.horaDoDuelo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.horaDoDuelo.entities.Carta;
import com.gustavonascimento.horaDoDuelo.repository.RepositorioCarta;

import com.gustavonascimento.horaDoDuelo.services.exceptions.ResourceNotFoundException;

@Service
public class ServicoCarta {
	
	@Autowired
	private RepositorioCarta repoCarta;
	
	public List<Carta> findAll()
	{
		return repoCarta.findAll();
	}
	
	public Carta findById(Long id)
	{
		Optional<Carta> obj=repoCarta.findById(id);
		return obj.orElseThrow(()->new ResourceNotFoundException(id));
	}
	
	public Carta insert(Carta obj)
	{
		return repoCarta.save(obj);
	}
}