package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.CiudadDTO;
import co.edu.usbcali.aerolinea.dto.PersonaDTO;
import co.edu.usbcali.aerolinea.mapper.CiudadMapper;
import co.edu.usbcali.aerolinea.mapper.PersonaMapper;
import co.edu.usbcali.aerolinea.repository.PersonaRepository;
import co.edu.usbcali.aerolinea.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;
    private final PersonaRepository personaRepository;

    public PersonaController(PersonaService personaService, PersonaRepository personaRepository) {
        this.personaService = personaService;
        this.personaRepository = personaRepository;
    }


    @GetMapping(value = "/validarController")
    public String validarController() {
        return "Controlador funcionando correctamente";
    }

    @GetMapping("/obtenerPersonas")
    public List<PersonaDTO> obtenerPersonas() {
        return PersonaMapper.domainToDtoList(personaRepository.findAll());
    }

    @PostMapping("/guardarNuevaPersona")
    public ResponseEntity<PersonaDTO> guardarNuevaPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            return new ResponseEntity<>(personaService.guardarNuevaPersona(personaDTO), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/editarPersona")
    public ResponseEntity<PersonaDTO> editarPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            return new ResponseEntity<>(personaService.editarPersona(personaDTO), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
