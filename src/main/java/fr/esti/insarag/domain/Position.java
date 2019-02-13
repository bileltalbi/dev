package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "poste")
@Data

@NoArgsConstructor
public class Poste implements Serializable {

    private static final long serialVersionUID = 7423804761945200280L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_poste")
    private Long id;

    @Size(max = 50)
    @Column(name = "nom", length = 50)
    private String nomPoste;

    @Size(max = 20)
    @Column(name = "quantite")
    private Long quantite;

}
