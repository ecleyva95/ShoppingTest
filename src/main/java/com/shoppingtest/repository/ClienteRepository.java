package com.shoppingtest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingtest.entity.Cliente;

@Repository("clienteRepositorio")
public interface ClienteRepository extends JpaRepository<Cliente,Serializable>{

}
