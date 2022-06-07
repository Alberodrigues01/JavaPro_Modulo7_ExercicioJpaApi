package br.com.mentorama.jpa_api.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "pacientes")

public class PacienteEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private String data_nascimento;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "paciente")
    public List<InternacaoEntity> internacoes;

    public PacienteEntity(){

    }

    public PacienteEntity(long id, String nome, String data_nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
