package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "salon")
@Data

@NoArgsConstructor
public class Salon implements Serializable {

    private static final long serialVersionUID = 1173087962118474579L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_salon")
    private Long id;

    @Size(max = 50)
    @Column(name = "description", length = 500)
    private String description;

}
