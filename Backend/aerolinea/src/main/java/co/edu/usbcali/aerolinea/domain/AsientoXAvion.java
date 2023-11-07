package co.edu.usbcali.aerolinea.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asientosxavion")
public class AsientoXAvion {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idaviones", referencedColumnName = "id", nullable = false)
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "idasientos", referencedColumnName = "id", nullable = false)
    private Asiento asiento;

    @Column(length = 1)
    private String estado;


}
