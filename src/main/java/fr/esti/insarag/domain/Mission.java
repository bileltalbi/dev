package fr.esti.insarag.domain;

import fr.esti.insarag.domain.converter.LocalDateTimeToSQLTimestampConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "mission")
@Data

@NoArgsConstructor
public class Mission implements Serializable {

    private static final long serialVersionUID = 7423804761945200280L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mission")
    private Long id;

    @Size(max = 50)
    @Column(name = "place", length = 50)
    private String place;

    @Column(name = "starting_date")
    @Convert(converter = LocalDateTimeToSQLTimestampConverter.class)
    private Date startingDate;

    @Column(name = "on_going")
    private Boolean onGoing;

    @Size(max = 20)
    @Column(name = "nb_contributor", length = 20)
    private Long nbContributor;

}
