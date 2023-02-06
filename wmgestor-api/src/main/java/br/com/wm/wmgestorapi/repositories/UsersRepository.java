package br.com.wm.wmgestorapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wm.wmgestorapi.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findByUsername(String username);

}
