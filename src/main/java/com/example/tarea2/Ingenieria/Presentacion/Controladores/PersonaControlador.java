package com.example.tarea2.Ingenieria.Presentacion.Controladores;

import com.example.tarea2.Ingenieria.Dominio.Interfaces.IPersona;
import com.example.tarea2.Ingenieria.Dominio.Modelos.Persona;
import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaActualizacionDTO;
import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaDTOMapper;
import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaLecturaDTO;
import com.example.tarea2.Ingenieria.Presentacion.DTOs.PersonaRegistroDTO;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {

    @Autowired
    private final IPersona iPersona;

    public PersonaControlador(IPersona iPersona) {
        this.iPersona = iPersona;
    }

    @PostMapping
    public ResponseEntity<Boolean> registrarPersona(@RequestBody PersonaRegistroDTO personaRegistroDTO){

        Persona persona = PersonaDTOMapper.convertirPersonaRegistroDTOAPersona(personaRegistroDTO);

        return ResponseEntity.created(null).body(this.iPersona.registrarPersona(persona));

    }

    @PutMapping
    public ResponseEntity<Boolean> actualizarPersona(@RequestBody PersonaActualizacionDTO personaActualizacionDTO){

        Persona persona = PersonaDTOMapper.convertirPersonaActualizacionDTOAPersona(personaActualizacionDTO);

        return ResponseEntity.ok(this.iPersona.actualizarPersona(persona));

    }

    @DeleteMapping("/{idPersona}")
    public ResponseEntity<Boolean> eliminarPersona(@Min(value = 1) @PathVariable  int idPersona ){
        return ResponseEntity.ok(this.iPersona.eliminarPersona(idPersona));
    }

    @GetMapping
    public ResponseEntity<List<PersonaLecturaDTO>> obtenerPersonas(){
        return ResponseEntity.ok(PersonaDTOMapper.convertirPersonasAPersonasLecturaDTO(this.iPersona.obtenerPersonas()));
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity obtenerPersonaPorIdentificacion( @PathVariable String identificacion){
        return ResponseEntity.ok(PersonaDTOMapper.convertirPersonaAPersonaLecturaDTO(this.iPersona.obtenerPersonaPorIdentificacion(identificacion)));
    }

}
