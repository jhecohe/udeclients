package com.jhecohe.backend.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhecohe.backend.app.models.entity.Client;

@Repository
public interface IClienteDao extends CrudRepository<Client, Long>{

}
