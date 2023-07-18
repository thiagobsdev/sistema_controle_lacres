package com.santosbrasil.controle_de_lacres.services.exceptions;

public class ForbiddenException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ForbiddenException(String msg) {
		super(msg);
	}

}
