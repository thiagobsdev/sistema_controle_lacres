package com.santosbrasil.controle_de_lacres.projections;

public interface UserDetailsProjection {
	
	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();

}
