package com.santosbrasil.controle_de_lacres.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import com.santosbrasil.controle_de_lacres.entities.User;
import com.santosbrasil.controle_de_lacres.entities.enums.CargoEnum;

public class UserDTO {

	private Long id;
	private String nome;
	private String registro;
	private String password;
	private CargoEnum cargoEnum;

	private List<String> roles = new ArrayList<>();

	public UserDTO(User entity) {
		nome = entity.getNome();
		registro = entity.getRegistro();
		cargoEnum = entity.getCargoEnum();
		for (GrantedAuthority obj : entity.getRoles()) {
			roles.add(obj.getAuthority());
		}
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegistro() {
		return registro;
	}

	public String getPassword() {
		return password;
	}

	public CargoEnum getCargoEnum() {
		return cargoEnum;
	}

	public List<String> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, password, registro, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(registro, other.registro)
				&& Objects.equals(roles, other.roles);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nome=" + nome + ", registro=" + registro + ", password=" + password + ", roles="
				+ roles + "]";
	}

}
