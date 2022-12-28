package com.gustavonascimento.horaDoDuelo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id)
	{
		super("O id "+id+" não pertence a nenhuma carta cadastrada");
	}
}