package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.CiudadDTO;
import co.edu.usbcali.aerolinea.mapper.CiudadMapper;
import co.edu.usbcali.aerolinea.repository.CiudadRepository;
import co.edu.usbcali.aerolinea.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadService ciudadService;
    private final CiudadRepository ciudadRepository;


    public CiudadController(CiudadService ciudadService, CiudadRepository ciudadRepository) {
        this.ciudadService = ciudadService;
        this.ciudadRepository = ciudadRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController() {
        return "Controlador funcionando correctamente";
    }

    @GetMapping("/obtenerCiudades")
    public List<CiudadDTO> obtenerCiudades() {
        return CiudadMapper.domainToDtoList(ciudadRepository.findAll());
    }

    @PostMapping("/guardarNuevaCiudad")
    public ResponseEntity<CiudadDTO> guardarNuevaCiudad(@RequestBody CiudadDTO ciudadDTO) {
        try {
            ciudadDTO = ciudadService.guardarNuevaCiudad(ciudadDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(ciudadDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorPaisId/{idPais}")
    public List<CiudadDTO> buscarPorPaisId(@PathVariable Integer idPais) {
        return CiudadMapper.domainToDtoList(ciudadRepository.findCiudadsByPaisId(idPais));
    }

    @GetMapping(value = "/buscarPorPaisCodigo/{codigoPais}")
    public List<CiudadDTO> buscarPorPaisCodigo(@PathVariable String codigoPais) {
        return CiudadMapper.domainToDtoList(ciudadRepository.findCiudadsByPaisCodigo(codigoPais));
    }

    @PutMapping("/modificarCiudad")
    public ResponseEntity<CiudadDTO> modificarCiudad(@RequestBody CiudadDTO ciudadDTO) {
        try {
            ciudadDTO = ciudadService.modificarCiudad(ciudadDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(ciudadDTO, HttpStatus.OK);
    }
}
