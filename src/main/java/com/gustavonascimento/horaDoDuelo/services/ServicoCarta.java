package com.gustavonascimento.horaDoDuelo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.horaDoDuelo.entities.Atributos;
import com.gustavonascimento.horaDoDuelo.entities.Carta;
import com.gustavonascimento.horaDoDuelo.entities.Duelo;
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
	
	public Duelo duel(Carta obj1,Carta obj2)
	{
		long hp=(obj1.getAtributes().getHp()>obj2.getAtributes().getHp()?obj1.getId():obj2.getId());
		long attack=(obj1.getAtributes().getAttack()>obj2.getAtributes().getAttack()?obj1.getId():obj2.getId());
		long defense=(obj1.getAtributes().getDefense()>obj2.getAtributes().getDefense()?obj1.getId():obj2.getId());
		long speed=(obj1.getAtributes().getSpeed()>obj2.getAtributes().getSpeed()?obj1.getId():obj2.getId());
		long specialAttack=(obj1.getAtributes().getSpecial_attack()>obj2.getAtributes().getSpecial_attack()?obj1.getId():obj2.getId());
		long specialDefense=(obj1.getAtributes().getSpecial_defense()>obj2.getAtributes().getSpecial_defense()?obj1.getId():obj2.getId());
		Long vencedor=verificarVencedor(obj1,hp, attack, defense, speed, specialAttack, specialDefense);
		Long perdedor=0l;
		if(vencedor==1)
		{
			perdedor=2L;
		}
		else
		{
			perdedor=1L;
		}
		Duelo obj3=new Duelo(null,vencedor,perdedor,new Atributos(null,(int)hp,(int)attack,(int)defense,(int)speed,(int)specialAttack,(int)specialDefense));
		return obj3;
	}
	
	private Long verificarVencedor(Carta obj1,long hp,long attack,long defense,long speed,long specialAttack, long specialDefense)
	{
		int wins1=0;
		int wins2=0;
		long id=obj1.getId();
		if(hp==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(attack==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(defense==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(speed==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(specialAttack==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(specialDefense==id)
		{
			wins1++;
		}
		else
		{
			wins2++;
		}
		if(wins1>wins2)
		{
			return 1L;
		}
		else
		{
			return 2L;
		}
	}
}