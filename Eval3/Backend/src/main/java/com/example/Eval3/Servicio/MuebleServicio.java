package com.example.Eval3.Servicio;

import com.example.Eval3.Entidad.EstadoMueble;
import com.example.Eval3.Entidad.Mueble;
import com.example.Eval3.Exception.ResourceNotFoundException;
import com.example.Eval3.Repositorio.MuebleRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuebleServicio {

    @Autowired
    private MuebleRepositorio muebleRepositorio;

    public Mueble crearMueble(Mueble mueble) {
        mueble.setEstado(EstadoMueble.Activo);
        return muebleRepositorio.save(mueble);
    }

    public List<Mueble> listarMuebles() {
        return muebleRepositorio.findAll();
    }
    
    public Mueble buscarMuebleById(Long id) {
        return muebleRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mueble con ID: " + id + " no encontrado"));
    }

    public Mueble actualizarMueble(Long id, Mueble muebleActualizado) {
        Mueble muebleExistente = buscarMuebleById(id);
        muebleExistente.setNombre_mueble(muebleActualizado.getNombre_mueble());
        muebleExistente.setTipo(muebleActualizado.getTipo());
        muebleExistente.setPrecio_base(muebleActualizado.getPrecio_base());
        muebleExistente.setStock(muebleActualizado.getStock());
        muebleExistente.setMaterial(muebleActualizado.getMaterial());
        muebleExistente.setTamaño(muebleActualizado.getTamaño());
        muebleExistente.setEstado(muebleActualizado.getEstado());
        return muebleRepositorio.save(muebleExistente);
    }

    public Mueble desactivarMueble(Long id) {
        Mueble muebleExistente = buscarMuebleById(id);
        muebleExistente.setEstado(EstadoMueble.Inactivo);
        return muebleRepositorio.save(muebleExistente);
    }

    public Mueble activarMueble(Long id) {
        Mueble muebleExistente = buscarMuebleById(id);
        muebleExistente.setEstado(EstadoMueble.Activo);
        return muebleRepositorio.save(muebleExistente);
    }

    public Mueble agregarStock(Long id, int cantidad) {
        Mueble mueble = buscarMuebleById(id);
        mueble.setStock(mueble.getStock() + cantidad);
        return muebleRepositorio.save(mueble);
    }

    public void eliminarMueble(Long id) {
        if (!muebleRepositorio.existsById(id)) {
            throw new ResourceNotFoundException("Mueble no encontrado");
        }
        muebleRepositorio.deleteById(id);
    }
}