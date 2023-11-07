package co.edu.usbcali.aerolinea.repository;

import co.edu.usbcali.aerolinea.domain.AsientoXAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoXAvionRepository extends JpaRepository<AsientoXAvion, Integer> {
    
}
