package br.com.mentorama.jpa_api.entity;


import javax.persistence.*;


@Entity
@Table(name = "internacoes")

public class InternacaoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id_internacao;

    @Column (name = "id_paciente", nullable = false)
    private long id_paciente;

    @Column(name = "entrada_data_hora", nullable = false)
    private String entrada_data_hora;

    @Column(name = "saida_data_hora", nullable = false)
    private String saida_data_hora;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "matricula_profissional", nullable = false)
    private int matricula_profissional;

    @ManyToOne
    @JoinColumn (name = "id")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn (name = "matricula")
    private ProfissionalEntity profissional;

    public InternacaoEntity() {

    }

    public InternacaoEntity(long id_internacao, long id_paciente,
                            String entrada_data_hora, String saida_data_hora,
                            String diagnostico, int matricula_profissional) {

                            this.id_internacao = id_internacao;
                            this.id_paciente = id_paciente;
                            this.entrada_data_hora = entrada_data_hora;
                            this.saida_data_hora = saida_data_hora;
                            this.diagnostico = diagnostico;
                            this.matricula_profissional = matricula_profissional;
    }

    public long getId_internacao() {
        return id_internacao;
    }

    public void setId_internacao(long id_internacao) {
        this.id_internacao = id_internacao;
    }

    public long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getEntrada_data_hora() {
        return entrada_data_hora;
    }

    public void setEntrada_data_hora(String entrada_data_hora) {
        this.entrada_data_hora = entrada_data_hora;
    }

    public String getSaida_data_hora() {
        return saida_data_hora;
    }

    public void setSaida_data_hora(String saida_data_hora) {
        this.saida_data_hora = saida_data_hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getMatricula_profissional() {
        return matricula_profissional;
    }

    public void setMatricula_profissional(int matricula_profissional) {
        this.matricula_profissional = matricula_profissional;
    }

}
