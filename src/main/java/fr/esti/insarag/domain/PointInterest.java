package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "point_interest")
@Data
@NoArgsConstructor
public class PointInterest implements Serializable {

    private static final long serialVersionUID = 612369803250126880L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_point_interet")
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    Mission mission;

}
