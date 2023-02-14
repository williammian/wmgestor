package br.com.wm.wmgestorapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wm.wmgestorapi.dtos.EmailDto;
import br.com.wm.wmgestorapi.services.EmailService;

@RestController
@RequestMapping({"/email"})
public class EmailControllers {
	
	@Autowired
	private EmailService emailService;
	
	@CrossOrigin
	@PostMapping
	public String sendMail(@RequestBody EmailDto emailDto) {		
		emailService.send(emailDto.getEmailTo(), emailDto.getSubject(), emailDto.getText());		
		return "Mensagem Enviada com Sucesso";	
	}

}

