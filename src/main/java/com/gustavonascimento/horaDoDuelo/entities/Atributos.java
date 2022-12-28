package com.gustavonascimento.horaDoDuelo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="atributos")
public class Atributos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private Integer hp;
	private Integer attack;
	private Integer defense;
	private Integer speed;
	private Integer special_attack;
	private Integer special_defense;
	
	public Atributos() 
	{
	}

	public Atributos(Long id,Integer hp, Integer attack, Integer defense, Integer speed, Integer special_attack,
			Integer special_defense) 
	{
		this.id=id;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.special_attack = special_attack;
		this.special_defense = special_defense;
	}
	
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Integer getHp() 
	{
		return hp;
	}

	public void setHp(Integer hp) 
	{
		this.hp = hp;
	}

	public Integer getAttack() 
	{
		return attack;
	}

	public void setAttack(Integer attack) 
	{
		this.attack = attack;
	}

	public Integer getDefense() 
	{
		return defense;
	}

	public void setDefense(Integer defense) 
	{
		this.defense = defense;
	}

	public Integer getSpeed() 
	{
		return speed;
	}

	public void setSpeed(Integer speed) 
	{
		this.speed = speed;
	}

	public Integer getSpecial_attack() 
	{
		return special_attack;
	}

	public void setSpecial_attack(Integer special_attack) 
	{
		this.special_attack = special_attack;
	}

	public Integer getSpecial_defense() 
	{
		return special_defense;
	}

	public void setSpecial_defense(Integer special_defense) 
	{
		this.special_defense = special_defense;
	}
	@Override
	public int hashCode() {
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
		Atributos other = (Atributos) obj;
		return Objects.equals(id, other.id);
	}
}