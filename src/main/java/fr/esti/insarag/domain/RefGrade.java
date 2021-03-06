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
@Table(name = "ref_grade")
@Data
public class RefGrade implements Serializable {

    private static final long serialVersionUID = -7675750207636668028L;

    @NotNull
    @Size(max = 10)
    @Id
    @Column(name = "code_grade", length = 10)
    private String code;

    @Size(max = 50)
    @Column(name = "label", length = 50)
    private String label;
}
