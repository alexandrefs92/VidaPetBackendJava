package com.vidapet.backend.vidapet.backend.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class RacaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 6463718357252183746L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public RacaModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public RacaModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacaModel racaModel = (RacaModel) o;
        return id.equals(racaModel.id) && Objects.equals(nome, racaModel.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
