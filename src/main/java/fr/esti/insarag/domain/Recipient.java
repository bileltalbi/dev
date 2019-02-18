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
    RecipientId pk;

    public Recipient() {
        pk = new RecipientId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class RecipientId implements Serializable {

        private static final long serialVersionUID = 7690536255479562878L;

        @ManyToOne
        @JoinColumn(name = "id_message")
        Message message;

        @ManyToOne
        @JoinColumn(name = "id_salon")
        Salon salon;
    }
}
