package co.edu.usbcali.aerolinea.service.implementation;

import co.edu.usbcali.aerolinea.domain.Persona;
import co.edu.usbcali.aerolinea.dto.PersonaDTO;
import co.edu.usbcali.aerolinea.mapper.PersonaMapper;
import co.edu.usbcali.aerolinea.repository.PersonaRepository;
import co.edu.usbcali.aerolinea.service.PersonaService;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaDTO guardarNuevaPersona(PersonaDTO personaDTO) throws Exception {
        // Validar atributos persona
        if(personaDTO == null) {
            throw new Exception("Debe ingresar los datos de la persona");
        }

        if(personaDTO.getTipodocumento() == null || personaDTO.getTipodocumento().isBlank()) {
            throw new Exception("Debe ingresar un tipo de documento");
        }

        if(personaDTO.getNumerodocumento() == null || personaDTO.getNumerodocumento().isBlank()) {
            throw new Exception("Debe ingresar el número de documento");
        }

        if(personaDTO.getNombre() == null || personaDTO.getNombre().isBlank()) {
            throw new Exception("Debe ingresar el nombre");
        }

        if(personaDTO.getApellido() == null || personaDTO.getApellido().isBlank()) {
            throw new Exception("Debe ingresar el apellido");
        }

        if(personaDTO.getTelefono() == null || personaDTO.getTelefono().isBlank()) {
            throw new Exception("Debe ingresar el telefono");
        }

        if(personaDTO.getCorreo() == null || personaDTO.getCorreo().isBlank()) {
            throw new Exception("Debe ingresar el correo");
        }

        Persona persona = PersonaMapper.dtoToDomain(personaDTO);

        return PersonaMapper.domainToDto(personaRepository.save(persona));
    }

    @Override
    public PersonaDTO editarPersona(PersonaDTO personaDTO) throws Exception {
        return null;
    }
}
