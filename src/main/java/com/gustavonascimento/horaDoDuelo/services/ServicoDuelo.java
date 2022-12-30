package com.gustavonascimento.horaDoDuelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.horaDoDuelo.entities.Duelo;
import com.gustavonascimento.horaDoDuelo.repository.RepositorioDuelo;

@Service
public class ServicoDuelo {
	
	@Autowired
	private RepositorioDuelo repoDuel;
	
	public Duelo insert(Duelo obj)
	{
		return repoDuel.save(obj);
	}
}