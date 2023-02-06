package br.com.wm.wmgestorapi.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wm.wmgestorapi.entities.Users;
import br.com.wm.wmgestorapi.repositories.UsersRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    
	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users usuario = repository.findByUsername(username);
				
		if(usuario != null) {
			String usernameBD = usuario.getUsername();
			String passwordBD = usuario.getPassword();
			return new User(usernameBD, passwordBD, new ArrayList<>());
		}
		
		throw new UsernameNotFoundException("Usuário inválido!");
	}

}
