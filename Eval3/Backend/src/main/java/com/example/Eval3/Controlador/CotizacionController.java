package com.example.Eval3.Controlador;

import com.example.Eval3.Entidad.Cotizacion;
import com.example.Eval3.Servicio.CotizacionServicio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotizaciones")
@CrossOrigin(origins = "*")
public class CotizacionController {

    @Autowired
    private CotizacionServicio cotizServicio;

    @PostMapping
    public ResponseEntity<Cotizacion> crearCotiz(@RequestBody Cotizacion cotizacion) {
        Cotizacion newCotiz = cotizServicio.crearCotiz(cotizacion);
        return new ResponseEntity<>(newCotiz, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cotizacion> listarCotiz() {
        return cotizServicio.listarCotiz();
    }

    @GetMapping("/{id}")
    public Cotizacion buscarCotizById(@PathVariable Long id) {
        return cotizServicio.buscarCotizById(id);
    }
}