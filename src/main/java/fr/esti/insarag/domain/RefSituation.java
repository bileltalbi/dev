package fr.esti.insarag.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ref_situation")
@Data

public class RefSituation implements Serializable {

    private static final long serialVersionUID = -8826339839036876782L;

    @NotNull
    @Size(max = 10)
    @Id
    @Column(name = "code_situation", length = 10)
    private String code;

    @Size(max = 50)
    @Column(name = "label", length = 50)
    private String label;
}
