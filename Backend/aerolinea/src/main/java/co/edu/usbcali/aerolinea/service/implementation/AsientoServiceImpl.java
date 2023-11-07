package co.edu.usbcali.aerolinea.service.implementation;

import co.edu.usbcali.aerolinea.domain.Asiento;
import co.edu.usbcali.aerolinea.domain.AsientoXAvion;
import co.edu.usbcali.aerolinea.dto.AsientoDTO;
import co.edu.usbcali.aerolinea.mapper.AsientoMapper;
import co.edu.usbcali.aerolinea.repository.AsientoXAvionRepository;
import co.edu.usbcali.aerolinea.service.AsientoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl implements AsientoService {

    private final AsientoXAvionRepository asientoXAvionRepository;

    public AsientoServiceImpl(AsientoXAvionRepository asientoXAvionRepository) {
        this.asientoXAvionRepository = asientoXAvionRepository;
    }

    @Override
    public AsientoDTO guardarNuevoAsiento(AsientoDTO asientoDTO) throws Exception {
        return null;
    }

    @Override
    public AsientoDTO modificarAsiento(AsientoDTO asientoDTO) throws Exception {
        return null;
    }

    @Override
    public List<AsientoDTO> buscarAsientosDeAvion(Integer avionId) throws Exception {
        return AsientoMapper.domainToDtoList(asientoXAvionRepository.findAsientoXAvionByAvionId(avionId)
                .stream().map(AsientoXAvion::getAsiento).toList());
    }
}
