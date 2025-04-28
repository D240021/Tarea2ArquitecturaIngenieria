package com.example.tarea2.Ingenieria.Dominio.Modelos;

import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaActualizacionDTO;
import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaRegistroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellidos;

    private String identificacion;

    private int edad;


    public Persona(PersonaRegistroDTO personaRegistroDTO) {
        this.nombre = personaRegistroDTO.nombre();
        this.apellidos = personaRegistroDTO.apellidos();
        this.identificacion = personaRegistroDTO.identificacion();
        this.edad = personaRegistroDTO.edad();
    }

    public Persona(PersonaActualizacionDTO personaActualizacionDTO) {
        this.nombre = personaActualizacionDTO.nombre();
        this.apellidos = personaActualizacionDTO.apellidos();
        this.identificacion = personaActualizacionDTO.identificacion();
        this.edad = personaActualizacionDTO.edad();
    }
}
