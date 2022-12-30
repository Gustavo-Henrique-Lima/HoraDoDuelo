package com.gustavonascimento.horaDoDuelo.services.exceptions;

public class ResourceNotAccepted extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotAccepted(Object id)
	{
		super("Não é possível criar um duelo usando a mesma carta");
	}
}
