package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_send_message")
@Data

public class PersonSendMessage implements Serializable {

    private static final long serialVersionUID = 8189431637778204308L;

    @EmbeddedId
    SenderId pk;

    public PersonSendMessage() {
        pk = new SenderId();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    class SenderId implements Serializable {

        private static final long serialVersionUID = 132493646945216062L;

        @ManyToOne
        @JoinColumn(name = "id_person")
        Person person;

        @ManyToOne
        @JoinColumn(name = "id_message")
        Message message;
    }
}
