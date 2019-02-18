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
@Table(name = "message")
@Data

@NoArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 3722437663716189319L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_message")
    private Long id;

    @NotNull
    @Column(name = "message_date", nullable = false)
    @Convert(converter = LocalDateTimeToSQLTimestampConverter.class)
    private LocalDateTime dateMessage;

    @Size(max = 50)
    @Column(name = "content", length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_sender")
    Person sender;

}
