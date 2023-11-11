package co.edu.usbcali.aerolinea.service;

import co.edu.usbcali.aerolinea.domain.Pais;
import co.edu.usbcali.aerolinea.dto.PaisDTO;
import co.edu.usbcali.aerolinea.mapper.PaisMapper;
import co.edu.usbcali.aerolinea.repository.PaisRepository;
import co.edu.usbcali.aerolinea.service.implementation.PaisServiceImpl;
import co.edu.usbcali.aerolinea.utility.PaisMockTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class PaisServiceImplTest {

    @InjectMocks
    private PaisServiceImpl paisService;

    @Mock
    private PaisRepository paisRepository;

    @Test
    void probarTest() {
        assertEquals(1, 1);
    }

    @Test
    void buscarPorId_OK() throws Exception {
        //Lógica correcta al buscar por id en repository
        given(paisRepository.findById(PaisMockTest.ID_UNO))
                .willReturn(Optional.of(PaisMockTest.PAIS_UNO));

        Pais paisConsultado =
                paisService.buscarPaisPorId(1);

        assertEquals(PaisMockTest.NOMBRE_UNO, paisConsultado.getNombre());
    }

    @Test
    void buscarPorId_Exception_No_Encontrado() {
        Exception exception = assertThrows(Exception.class, () ->
                paisService.buscarPaisPorId(1));

        assertEquals("No se ha encontrado el país con id 1", exception.getMessage());
    }

    @Test
    void buscarPorId_Exception_No_SePuedeConsultar(){
        Exception exception = assertThrows(Exception.class, () -> paisService.buscarPaisPorId(0));

        assertEquals("No se puede consultar el id", exception.getMessage());
    }

    @Test
    void buscarPorId_Exception_No_SePuedeConsultar_Null(){
        Exception exception = assertThrows(Exception.class,
                () -> paisService.buscarPaisPorId(null));

        assertEquals("No se puede consultar el id", exception.getMessage());
    }

    @Test
    void crearNuevoPais_OK() throws Exception {
        //Lógica correcta al buscar por id en repository
        given(paisRepository.save(any()))
                .willReturn(PaisMockTest.PAIS_DOS);

        PaisDTO paisACrear = PaisMapper.domainToDto(PaisMockTest.PAIS_DOS);

        PaisDTO paisCreado =
                paisService.crearNuevoPais(paisACrear);

        assertEquals(paisACrear.getCodigo(), paisCreado.getCodigo());
    }
}
