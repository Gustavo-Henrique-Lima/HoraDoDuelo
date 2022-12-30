package com.gustavonascimento.horaDoDuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavonascimento.horaDoDuelo.entities.Duelo;

public interface RepositorioDuelo extends JpaRepository<Duelo, Long>{
	@Query(value="SELECT COUNT(*) FROM Duelo WHERE vencedor=?1")
	long vitoriasAcumuladas(long id);
}