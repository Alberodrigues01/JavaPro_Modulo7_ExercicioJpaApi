package br.com.mentorama.jpa_api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profissionais")

public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "profissional")
    private List<InternacaoEntity> internacoes;

    public ProfissionalEntity(){

    }

    public ProfissionalEntity(long matricula, String nome, String cargo, String departamento, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
        this.telefone = telefone;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    }
