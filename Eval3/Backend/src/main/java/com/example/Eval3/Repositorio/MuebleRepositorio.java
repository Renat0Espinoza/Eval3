package com.example.Eval3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eval3.Entidad.Mueble;

@Repository
public interface MuebleRepositorio extends JpaRepository<Mueble, Long> {
}