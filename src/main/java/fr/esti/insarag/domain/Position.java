package fr.esti.insarag.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "position")
@Data

@NoArgsConstructor
public class Position implements Serializable {

    private static final long serialVersionUID = 7423804761945200280L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_position")
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 20)
    @Column(name = "amount")
    private Long amount;

}
