package com.santosbrasil.controle_de_lacres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosbrasil.controle_de_lacres.entities.User;
import com.santosbrasil.controle_de_lacres.services.exceptions.ForbiddenException;

@Service
public class AuthService {

	@Autowired
	UserService userService;

	public void verififyRoleAndClient(Long id) {

		User user = userService.findUserAuthenticated();

		if (!user.getId().equals(id) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Acesso negado!");

		}

	}

}
