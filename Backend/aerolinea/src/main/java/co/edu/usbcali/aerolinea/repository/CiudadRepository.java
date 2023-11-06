package co.edu.usbcali.aerolinea.repository;

import co.edu.usbcali.aerolinea.domain.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    List<Ciudad> findCiudadsByPaisId(Integer paisId);

    List<Ciudad> findCiudadsByPaisCodigo(String paisCodigo);
}
