package com.shoppingtest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingtest.entity.Venta;

@Repository("ventaRepositorio")
public interface VentaRepository extends JpaRepository<Venta,Serializable>{
	
	

}
