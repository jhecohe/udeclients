package com.jhecohe.backend.app.service;

import java.util.List;

import com.jhecohe.backend.app.models.entity.Client;

public interface IClientService {

	public List<Client> findAll();
	
	public Client findById(Long id);
	
	public Client save(Client client);
	
	public void delete(Long id);
}
