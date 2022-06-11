package br.com.mentorama.jpa_api.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitalization")
public class HospitalizationHistory {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToMany
    @JoinColumn(name = "doctor_resp")
    private List<Doctor> doctor_resp = new ArrayList<>();

    private String dateEntry;
    private String dateExit;
    private String description;

    public HospitalizationHistory(){

    }

    public HospitalizationHistory(Long id, Patient patient, List<Doctor> doctor_resp, String dateEntry, String dateExit, String description) {
        this.id = id;
        this.patient = patient;
        this.doctor_resp = doctor_resp;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Doctor> getDoctor_resp() {
        return doctor_resp;
    }

    public void setDoctor_resp(List<Doctor> doctor_resp) {
        this.doctor_resp = doctor_resp;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateExit() {
        return dateExit;
    }

    public void setDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
