package com.jhecohe.backend.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.backend.app.models.entity.Client;
import com.jhecohe.backend.app.service.IClientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientController {

	IClientService clientService;
	
	@GetMapping("client")
	public ResponseEntity<List<Client>> getClients(){
		return new ResponseEntity<List<Client>>(clientService.findAll(), HttpStatus.OK	);
	}
	
	@PostMapping("client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id){
		return new ResponseEntity<Client>(clientService.findById(id), HttpStatus.FOUND );
	}
	
	@PostMapping("client")
	public ResponseEntity<Client> saveClient(@RequestBody Client client){
		return new ResponseEntity<Client>(clientService.save(client), HttpStatus.CREATED );
	}
	
	@PutMapping("client/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id){
		Client c = clientService.findById(id);
		c.setEmail(client.getEmail());
		c.setName(client.getName());
		c.setLastname(client.getLastname());
		return new ResponseEntity<Client>(clientService.save(c), HttpStatus.CREATED );
	}
	
	@DeleteMapping("client/{id}")
	public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id){
		return new ResponseEntity<HttpStatus>( HttpStatus.NO_CONTENT );
	}
}
