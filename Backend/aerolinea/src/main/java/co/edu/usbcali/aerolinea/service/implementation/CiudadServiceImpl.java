package co.edu.usbcali.aerolinea.service.implementation;

import co.edu.usbcali.aerolinea.domain.Ciudad;
import co.edu.usbcali.aerolinea.domain.Pais;
import co.edu.usbcali.aerolinea.dto.CiudadDTO;
import co.edu.usbcali.aerolinea.mapper.CiudadMapper;
import co.edu.usbcali.aerolinea.repository.CiudadRepository;
import co.edu.usbcali.aerolinea.service.CiudadService;
import co.edu.usbcali.aerolinea.service.PaisService;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;
    private final PaisService paisService;

    public CiudadServiceImpl(CiudadRepository ciudadRepository, PaisService paisService) {
        this.ciudadRepository = ciudadRepository;
        this.paisService = paisService;
    }

    @Override
    public CiudadDTO guardarNuevaCiudad(CiudadDTO ciudadDTO) throws Exception {
        if( ciudadDTO == null) {
            throw new Exception("La ciudad es nula");
        }

        if (ciudadDTO.getNombre() == null || ciudadDTO.getNombre().isBlank()) {
            throw new Exception("La ciudad debe tener un nombre");
        }

        if (ciudadDTO.getIdPais() == null || ciudadDTO.getIdPais().equals(0)) {
            throw new Exception("La ciudad debe pertenecer a un país válido");
        }

        Pais pais = paisService.buscarPaisPorId(ciudadDTO.getIdPais());
        /*if(pais == null) {
            throw new Exception("No se ha encontrado el país con id "+ciudadDTO.getIdPais());
        }*/

        Ciudad ciudad = CiudadMapper.dtoToDomain(ciudadDTO);
        ciudad.setPais(pais);

        ciudad = ciudadRepository.save(ciudad);
        ciudadDTO = CiudadMapper.domainToDto(ciudad);
        return ciudadDTO;
    }

    @Override
    public CiudadDTO modificarCiudad(CiudadDTO ciudadDTO) throws Exception {
        if( ciudadDTO == null) {
            throw new Exception("La ciudad es nula");
        }

        Ciudad ciudad = buscarCiudadPorId(ciudadDTO.getId());

        if (ciudadDTO.getNombre() == null || ciudadDTO.getNombre().isBlank()) {
            throw new Exception("La ciudad debe tener un nombre");
        }

        Pais pais = paisService.buscarPaisPorId(ciudadDTO.getIdPais());

        ciudad.setPais(pais);
        ciudad.setNombre(ciudadDTO.getNombre());
        ciudad.setLatitud(ciudadDTO.getLatitud());
        ciudad.setLongitud(ciudadDTO.getLongitud());
        ciudad.setDescripcion(ciudadDTO.getDescripcion());

        ciudad = ciudadRepository.save(ciudad);

        return CiudadMapper.domainToDto(ciudad);
    }

    @Override
    public Ciudad buscarCiudadPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("No se puede consultar el id ");
        }
        return ciudadRepository.findById(id).orElseThrow(
                () -> new Exception("No se ha encontrado la ciudad con id "+id));
    }
}
