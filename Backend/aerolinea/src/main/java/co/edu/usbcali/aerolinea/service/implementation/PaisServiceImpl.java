package co.edu.usbcali.aerolinea.service.implementation;

import co.edu.usbcali.aerolinea.domain.Pais;
import co.edu.usbcali.aerolinea.dto.PaisDTO;
import co.edu.usbcali.aerolinea.mapper.PaisMapper;
import co.edu.usbcali.aerolinea.repository.PaisRepository;
import co.edu.usbcali.aerolinea.service.PaisService;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public PaisDTO crearNuevoPais(PaisDTO paisDTO) throws Exception {

        // Validaciones de atributos

        // Validar que paisDTO no sea nulo
        if (paisDTO == null ) {
            throw new Exception("Pais es nulo");
        }

        // Validar el código del país a crear
        if (paisDTO.getCodigo() == null || paisDTO.getCodigo().isBlank()) {
            throw new Exception("Debe ingresar un valor para el código");
        }

        // Validar el nombre del país a crear
        if (paisDTO.getNombre() == null || paisDTO.getNombre().isBlank()) {
            throw new Exception("Debe ingresar un valor para el nombre");
        }

        // Convertir a Entidad
        Pais pais = PaisMapper.dtoToDomain(paisDTO);

        // Guardar entidad
        pais = paisRepository.save(pais);

        // Convertirmos a DTO
        paisDTO = PaisMapper.domainToDto(pais);

        // Retornamos el PaisDTO
        return paisDTO;
    }

    @Override
    public PaisDTO modificarPaisExistente(PaisDTO paisDTO) throws Exception {
        return null;
    }

    @Override
    public Pais buscarPaisPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("No se puede consultar el id ");
        }
        return paisRepository.findById(id).orElseThrow(
                () -> new Exception("No se ha encontrado el país con id "+id));
    }
}
