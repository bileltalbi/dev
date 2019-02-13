package fr.esti.insarag.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "REF_GRADE")
@Data
@Builder
public class RefGrade extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = -7675750207636668028L;

    @NotNull
    @Size(max = 10)
    @Id
    @Column(name = "code_grade", length = 10)
    private String code;

    @Size(max = 50)
    @Column(name = "libelle", length = 50)
    private String libelle;
}
