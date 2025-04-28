package com.example.tarea2.Ingenieria.Dominio.Interfaces;

import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;

import java.util.List;

public interface IPersona {

    public boolean registrarPersona(Persona persona);

    public boolean actualizarPersona(Persona persona);

    public boolean eliminarPersona(int idPersona);

    public List<Persona> obtenerPersonas();

    public Persona obtenerPersonaPorIdentificacion(String identificacion);
}
