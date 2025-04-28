package com.example.tarea2.Ingenieria.Aplicacion.Servicios;

import com.example.tarea2.Ingenieria.Dominio.Interfaces.IPersona;
import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;
import com.example.tarea2.Ingenieria.Infraestructura.Repositorios.PersonaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio implements IPersona {

    @Autowired
    private final PersonaRepositorio personaRepositorio;

    public PersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }


    @Override
    public boolean registrarPersona(Persona persona) {

        try {
            this.personaRepositorio.save(persona);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Modifying
    @Transactional
    @Override
    public boolean actualizarPersona(Persona persona) {

        try {

            Persona personaEncontrada = this.personaRepositorio.findById(persona.getId())
                    .orElseThrow( () -> new Exception("Persona no encontrada"));

            personaEncontrada = persona;

            this.personaRepositorio.save(personaEncontrada);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean eliminarPersona(int idPersona) {
        try {

            Persona personaEncontrada = this.personaRepositorio.findById(idPersona)
                    .orElseThrow( () -> new Exception("Persona no encontrada"));

            this.personaRepositorio.deleteById(idPersona);

            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return this.personaRepositorio.findAll();
    }

    @Override
    public Persona obtenerPersonaPorIdentificacion(String identificacion) {
        return this.personaRepositorio.getByIdentificacion(identificacion);
    }
}
