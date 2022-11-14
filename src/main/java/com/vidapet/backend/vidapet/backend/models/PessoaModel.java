package com.vidapet.backend.vidapet.backend.models;

import com.vidapet.backend.vidapet.backend.enums.TipoPessoa;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "pessoa")
public class PessoaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -826667456310779593L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private Instant dataNascimento;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoModel endereco;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UserModel user;


    public PessoaModel(Long id, String nome, String email, Instant dataNascimento, TipoPessoa tipoPessoa, EnderecoModel endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
        this.endereco = endereco;
    }

    public PessoaModel() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }


}
