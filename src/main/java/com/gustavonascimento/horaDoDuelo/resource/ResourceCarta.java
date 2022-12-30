package com.gustavonascimento.horaDoDuelo.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavonascimento.horaDoDuelo.entities.Carta;
import com.gustavonascimento.horaDoDuelo.entities.Duelo;
import com.gustavonascimento.horaDoDuelo.services.ServicoCarta;
import com.gustavonascimento.horaDoDuelo.services.ServicoDuelo;

@RestController
@RequestMapping(value="/cartas")
public class ResourceCarta {

	@Autowired
	private ServicoCarta servCarta;
	
	@Autowired
	private ServicoDuelo servDuel;
	
	@GetMapping
	public ResponseEntity<List<Carta>> findAll()
	{
		List<Carta> cartas=servCarta.findAll();
		return ResponseEntity.ok(cartas);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Carta> findById(@PathVariable Long id)
	{
		Carta obj=servCarta.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Carta> inserir(@Valid @RequestBody Carta obj)
	{
		obj=servCarta.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping(value="/duelo/player1={id}/player2={id2}")
	public ResponseEntity<Duelo> duelo(@PathVariable Long id,@PathVariable Long id2)
	{
		Carta c1=servCarta.findById(id);
		Carta c2=servCarta.findById(id2);
		List<Carta> cartas=new ArrayList<>();
		cartas.add(c1);
		cartas.add(c2);
		if(c1.equals(c2))
		{
			return ResponseEntity.status(406).body(null);
		}
		else
		{
			Duelo d1=servCarta.duel(c1,c2);
			if(d1.equals(null))
			{
				return ResponseEntity.status(406).body(null);
			}
			else
			{
				servDuel.insert(d1);
				URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(d1.getId()).toUri();
				return ResponseEntity.created(uri).body(d1);
			}
		}
	}
}