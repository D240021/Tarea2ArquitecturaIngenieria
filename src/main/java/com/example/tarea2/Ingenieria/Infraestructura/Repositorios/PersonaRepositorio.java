package com.example.tarea2.Ingenieria.Infraestructura.Repositorios;

import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    public Persona getByIdentificacion(String identificacion);

}
