package com.shoppingtest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingtest.entity.Producto;

@Repository("productoRepositorio")
public interface ProductoRepository extends JpaRepository<Producto,Serializable>{


}
