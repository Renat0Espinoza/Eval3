package com.example.Eval3.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eval3.Entidad.Cotizacion;

@Repository
public interface CotizacionRepositorio extends JpaRepository<Cotizacion, Long> {
}