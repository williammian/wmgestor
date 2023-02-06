package br.com.wm.wmgestorapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.wm.wmgestorapi.entities.Users;
import br.com.wm.wmgestorapi.repositories.UsersRepository;

@Service
public class UsersServices {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Users> findAll() {
		return repository.findAll();
	}
				
	public Users findById(Long id) {
		Optional<Users> obj = repository.findById(id);
		return obj.get();
	}
	
	public Users create(Users user) {
		String senhaComHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(senhaComHash);
	    return repository.save(user);
	}
	
	public Users update(Users user, Long id) {
		user.setId(id);
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
