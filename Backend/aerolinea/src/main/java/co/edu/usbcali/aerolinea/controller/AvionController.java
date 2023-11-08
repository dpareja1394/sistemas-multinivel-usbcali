package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mapper.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.service.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/avion")
public class AvionController {

    private final AvionService avionService;
    private final AvionRepository avionRepository;

    public AvionController(AvionService avionService, AvionRepository avionRepository) {
        this.avionService = avionService;
        this.avionRepository = avionRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController() {
        return "Controlador funcionando correctamente";
    }

    @GetMapping("/obtenerAviones")
    public List<AvionDTO> obtenerAviones() {
        return AvionMapper.domainToDtoList(avionRepository.findAll());
    }

    @PostMapping("/guardarNuevoAvion")
    public ResponseEntity<AvionDTO> guardarNuevoAvion(@RequestBody AvionDTO avionDTO) {
        try {
            avionDTO = avionService.guardarNuevoAvion(avionDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(avionDTO, HttpStatus.OK);
    }
}
