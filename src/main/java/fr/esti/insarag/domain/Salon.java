package fr.esti.insarag.domain;

import fr.esti.insarag.domain.converter.LocalDateTimeToSQLTimestampConverter;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "message")
@Data
@Builder
@NoArgsConstructor
public class Message extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 3722437663716189319L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_message")
    private Long id;

    @NotNull
    @Column(name = "date_message", nullable = false)
    @Convert(converter = LocalDateTimeToSQLTimestampConverter.class)
    private LocalDateTime dateMessage;

    @Size(max = 50)
    @Column(name = "contenu", length = 500)
    private String contenu;

}
