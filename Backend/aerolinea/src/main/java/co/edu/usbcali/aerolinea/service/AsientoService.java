package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.dto.AsientoDTO;

import java.util.List;

public interface AsientoService {

    AsientoDTO guardarNuevoAsiento(AsientoDTO asientoDTO) throws Exception;

    AsientoDTO modificarAsiento(AsientoDTO asientoDTO) throws Exception;

    List<AsientoDTO> buscarAsientosDeAvion(Integer avionId) throws Exception;
}
