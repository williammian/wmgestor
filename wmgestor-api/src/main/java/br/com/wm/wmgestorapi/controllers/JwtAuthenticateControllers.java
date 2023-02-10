package br.com.wm.wmgestorapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wm.wmgestorapi.entities.Users;
import br.com.wm.wmgestorapi.repositories.UsersRepository;
import br.com.wm.wmgestorapi.security.JwtTokenUtil;
import br.com.wm.wmgestorapi.security.JwtUserDetailsService;
import br.com.wm.wmgestorapi.security.requests.JwtRequest;

@CrossOrigin
@RestController
public class JwtAuthenticateControllers {
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
			
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Optional<Users> createAuthenticeToken(@RequestBody JwtRequest authenticateRequest) throws Exception {
		Users usuario = repository.findByUsername(authenticateRequest.getUsername());
		
		if(usuario != null) {
			authenticate(authenticateRequest.getUsername(), authenticateRequest.getPassword());
			
			final UserDetails userDetails = jwtUserDetailService
					.loadUserByUsername(authenticateRequest.getUsername());
			
			String token = jwtTokenUtil.generateToken(userDetails);
			
			Long id = usuario.getId();
			Optional<Users> obj = null;
			obj = repository.findById(id);
			obj.orElseThrow().setToken(token);
			obj.orElseThrow().setPassword("");
			return obj;
		}
			
		return retornarUsuarioErroLogin();
	}
	
	private Optional<Users> retornarUsuarioErroLogin() {
		Users usuario = new Users();
		usuario.setEmail("Erro ao tentar logar!");
		usuario.setPassword("");
		usuario.setUsername("username ou password não conferem!!");
		
		return Optional.of(usuario);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}

