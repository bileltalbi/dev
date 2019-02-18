package fr.esti.insarag.domain;

import fr.esti.insarag.domain.converter.LocalDateTimeToSQLTimestampConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Data

@NoArgsConstructor
public class Alert implements Serializable {

    private static final long serialVersionUID = 8389000437253874113L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_alert")
    private Long id;

    @Size(max = 50)
    @Column(name = "code", length = 50)
    private String codeAlert;

    @NotNull
    @Column(name = "alert_date", nullable = false)
    @Convert(converter = LocalDateTimeToSQLTimestampConverter.class)
    private LocalDateTime alertDate;

    @Column(name = "nb_ok")
    private Long nbOKAlert;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    Mission mission;

}
