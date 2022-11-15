package com.vidapet.backend.vidapet.backend.models;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class EstadoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 3385921947056369566L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sigla;

    @OneToOne(mappedBy = "estadoModel")
    private EnderecoModel endereco;

    public EstadoModel(Long ig, String sigla) {
        this.id = ig;
        this.sigla = sigla;
    }

    public EstadoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoModel that = (EstadoModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

