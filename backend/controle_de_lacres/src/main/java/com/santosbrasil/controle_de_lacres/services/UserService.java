package com.santosbrasil.controle_de_lacres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santosbrasil.controle_de_lacres.dto.UserDTO;
import com.santosbrasil.controle_de_lacres.entities.Role;
import com.santosbrasil.controle_de_lacres.entities.User;
import com.santosbrasil.controle_de_lacres.projections.UserDetailsProjection;
import com.santosbrasil.controle_de_lacres.repositories.UserRepository;

@Service
public class UserService  implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailsProjection> result = repository.searchUserAndRolesByRegistro(username);
		if (result.size() == 0) {
			throw new UsernameNotFoundException("Email not found");
		}

		User user = new User();
		user.setRegistro(result.get(0).getUsername());
		user.setPassword(result.get(0).getPassword());
		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}

		return user;
	}

	public User findUserAuthenticated() {
		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaimAsString("username");

			return repository.findByRegistro(username).get();

		} catch (Exception e) {
			throw new UsernameNotFoundException("Email not found");
		}
	}
	
	@Transactional(readOnly = true)
	public UserDTO getMe() {
		User user  = findUserAuthenticated();
		return new UserDTO(user);
	}

}
