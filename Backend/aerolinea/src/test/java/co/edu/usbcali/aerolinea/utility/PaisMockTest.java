package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Pais;
import co.edu.usbcali.aerolinea.dto.PaisDTO;
import co.edu.usbcali.aerolinea.mapper.PaisMapper;

import java.util.Arrays;
import java.util.List;

public class PaisMockTest {

    public static Integer ID_UNO = 1;
    public static String CODIGO_UNO = "COL";
    public static String NOMBRE_UNO = "Colombia";
    public static String DESCRIPCION_UNO = "República de Colombia";

    public static Integer ID_DOS = 2;
    public static String CODIGO_DOS = "BRA";
    public static String NOMBRE_DOS = "Brasil";
    public static String DESCRIPCION_DOS = "Brasil";

    public static Integer ID_TRES = 3;
    public static String CODIGO_TRES = "ARG";
    public static String NOMBRE_TRES = "Argentina";
    public static String DESCRIPCION_TRES = "Argentina";

    public static Pais PAIS_UNO =
            Pais.builder()
                    .id(ID_UNO)
                    .codigo(CODIGO_UNO)
                    .nombre(NOMBRE_UNO)
                    .descripcion(DESCRIPCION_UNO)
                    .build();

    public static Pais PAIS_DOS =
            Pais.builder()
                    .id(ID_DOS)
                    .codigo(CODIGO_DOS)
                    .nombre(NOMBRE_DOS)
                    .descripcion(DESCRIPCION_DOS)
                    .build();

    public static Pais PAIS_TRES =
            Pais.builder()
                    .id(ID_TRES)
                    .codigo(CODIGO_TRES)
                    .nombre(NOMBRE_TRES)
                    .descripcion(DESCRIPCION_TRES)
                    .build();

    public static List<Pais> PAISES =
            Arrays.asList(PAIS_UNO, PAIS_DOS, PAIS_TRES);

    public static List<PaisDTO> PAISES_DTO = PaisMapper.domainToDtoList(PAISES);

}
