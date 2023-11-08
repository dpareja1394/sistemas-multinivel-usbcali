package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.AsientoDTO;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mapper.AsientoMapper;
import co.edu.usbcali.aerolinea.mapper.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AsientoRepository;
import co.edu.usbcali.aerolinea.service.AsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/asiento")
public class AsientoController {

    private final AsientoService asientoService;
    private final AsientoRepository asientoRepository;

    public AsientoController(AsientoService asientoService, AsientoRepository asientoRepository) {
        this.asientoService = asientoService;
        this.asientoRepository = asientoRepository;
    }


    @GetMapping(value = "/validarController")
    public String validarController() {
        return "Controlador funcionando correctamente";
    }

    @GetMapping("/obtenerAsientos")
    public List<AsientoDTO> obtenerAsientos() {
        return AsientoMapper.domainToDtoList(asientoRepository.findAll());
    }

    @GetMapping("/obtenerAsientosXAvion/{idAvion}")
    public List<AsientoDTO> obtenerAsientosXAvion(@PathVariable Integer idAvion) {
        try {
            return asientoService.buscarAsientosDeAvion(idAvion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
