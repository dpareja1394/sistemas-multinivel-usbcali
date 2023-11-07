package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.domain.Pais;
import co.edu.usbcali.aerolinea.dto.PaisDTO;

public interface PaisService {
    PaisDTO crearNuevoPais(PaisDTO paisDTO) throws Exception;

    PaisDTO modificarPaisExistente(PaisDTO paisDTO) throws Exception;

    Pais buscarPaisPorId(Integer id) throws Exception;

}
