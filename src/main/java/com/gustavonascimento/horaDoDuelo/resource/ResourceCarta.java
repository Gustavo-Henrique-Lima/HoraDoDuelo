package com.gustavonascimento.horaDoDuelo.resource;

import java.net.URI;
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
import com.gustavonascimento.horaDoDuelo.services.ServicoCarta;

@RestController
@RequestMapping(value="/cartas")
public class ResourceCarta {

	@Autowired
	private ServicoCarta servCarta;
	
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
}