package com.vidapet.backend.vidapet.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 3355619410522781147L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logradouro;

    @OneToOne
    @JoinColumn(name = "estado_id")
    private EstadoModel estadoModel;

    @OneToOne(mappedBy = "endereco")
    private PessoaModel pessoa;

    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }
    
    public EnderecoModel() {
    }

    public EnderecoModel(Long id, String logradouro, EstadoModel estadoModel) {
        this.id = id;
        this.logradouro = logradouro;
        this.estadoModel = estadoModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoModel that = (EnderecoModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
