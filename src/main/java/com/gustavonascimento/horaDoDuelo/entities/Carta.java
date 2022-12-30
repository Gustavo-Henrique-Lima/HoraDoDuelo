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

@Entity
@Table(name="cartas")
public class Carta implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Atributos atributes;
	
	public Carta() 
	{
	}

	public Carta(Long id,String name, Atributos atributes) 
	{
		this.id=id;
		this.name = name;
		this.atributes = atributes;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Atributos getAtributes() 
	{
		return atributes;
	}

	public void setAtributes(Atributos atributes) 
	{
		this.atributes = atributes;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(atributes);
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
		Carta other = (Carta) obj;
		return Objects.equals(atributes, other.atributes);
	}
}