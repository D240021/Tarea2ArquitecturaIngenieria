package com.example.tarea2.Ingenieria.Presentacion.DTOs;

import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;

public record PersonaLecturaDTO(

         int id,

         String nombre,

         String apellidos,

         String identificacion,

         int edad

) {
    public PersonaLecturaDTO(Persona persona) {
        this(persona.getId(), persona.getNombre(),
                persona.getApellidos(), persona.getIdentificacion(), persona.getEdad());
    }
}
