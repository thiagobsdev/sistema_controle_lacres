package com.santosbrasil.controle_de_lacres.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santosbrasil.controle_de_lacres.entities.User;
import com.santosbrasil.controle_de_lacres.projections.UserDetailsProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = """
				SELECT tb_user.registro AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority
				FROM tb_user
				INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
				INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id
				WHERE tb_user.registro = :registro
			""")
	List<UserDetailsProjection> searchUserAndRolesByRegistro(String registro);
	
	Optional<User> findByRegistro(String registro);

}
