package com.gustavonascimento.horaDoDuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.horaDoDuelo.entities.Carta;

public interface RepositorioCarta extends JpaRepository<Carta, Long>{

}