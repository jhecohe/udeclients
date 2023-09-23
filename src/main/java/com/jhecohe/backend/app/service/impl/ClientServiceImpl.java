package com.jhecohe.backend.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhecohe.backend.app.models.dao.IClienteDao;
import com.jhecohe.backend.app.models.entity.Client;
import com.jhecohe.backend.app.service.IClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService{

	IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		return clienteDao.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
