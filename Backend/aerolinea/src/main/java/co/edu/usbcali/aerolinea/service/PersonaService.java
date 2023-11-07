package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.dto.PersonaDTO;

public interface PersonaService {

    PersonaDTO guardarNuevaPersona(PersonaDTO personaDTO) throws Exception;

    PersonaDTO editarPersona(PersonaDTO personaDTO) throws Exception;

}
