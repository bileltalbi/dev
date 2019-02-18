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
@Table(name = "ref_department")
@Data

public class RefDepartment implements Serializable {

    private static final long serialVersionUID = -8988645549219541471L;

    @NotNull
    @Size(max = 10)
    @Id
    @Column(name = "code_department", length = 10)
    private String code;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 50)
    @Column(name = "dependence", length = 50)
    private String dependence;
}
