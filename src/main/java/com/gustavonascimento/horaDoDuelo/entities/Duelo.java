package com.gustavonascimento.horaDoDuelo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="duelos")
public class Duelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private Long vencedor;
	private Long perdedor;
	@OneToOne(cascade=CascadeType.ALL)
	private Atributos detalhes;
	
	public Duelo() 
	{
	}

	public Duelo(Long id, Long vencedor, Long perdedor, Atributos detalhes) 
	{
		super();
		this.id = id;
		this.vencedor = vencedor;
		this.perdedor = perdedor;
		this.detalhes = detalhes;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getIdVencedor() 
	{
		return vencedor;
	}

	public void setIdVencedor(Long vencedor) 
	{
		this.vencedor = vencedor;
	}

	public Long getIdPerdedor() 
	{
		return perdedor;
	}

	public void setIdPerdedor(Long perdedor) 
	{
		this.perdedor = perdedor;
	}

	public Atributos getDetalhes() 
	{
		return detalhes;
	}

	public void setDetalhes(Atributos detalhes) 
	{
		this.detalhes = detalhes;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Duelo other = (Duelo) obj;
		return Objects.equals(id, other.id);
	}
}