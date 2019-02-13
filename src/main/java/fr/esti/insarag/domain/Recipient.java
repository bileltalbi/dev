package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipient")
@Data

public class Recipient implements Serializable {

    private static final long serialVersionUID = 1746840282138170033L;

    @EmbeddedId
    DestineaId pk;

    public Destinea() {
        pk = new DestineaId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class DestineaId implements Serializable {

        private static final long serialVersionUID = 7690536255479562878L;

        @ManyToOne
        @JoinColumn(name = "id_message")
        Message message;

        @ManyToOne
        @JoinColumn(name = "id_salon")
        Salon salon;
    }
}
