package com.example.tarea2.Ingenieria.Presentacion.DTOs;

import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaDTOMapper {

    public static Persona convertirPersonaRegistroDTOAPersona(PersonaRegistroDTO personaRegistroDTO){
        return new Persona(personaRegistroDTO);
    }

    public static Persona convertirPersonaActualizacionDTOAPersona
            (PersonaActualizacionDTO personaActualizacionDTO){
     return new Persona(personaActualizacionDTO);
    }

    public static PersonaLecturaDTO convertirPersonaAPersonaLecturaDTO(Persona persona){
        return new PersonaLecturaDTO(persona);
    }

    public static List<PersonaLecturaDTO> convertirPersonasAPersonasLecturaDTO(List<Persona> personas){
        return personas.stream()
                .map(PersonaLecturaDTO::new)
                .collect(Collectors.toList());
    }

}
