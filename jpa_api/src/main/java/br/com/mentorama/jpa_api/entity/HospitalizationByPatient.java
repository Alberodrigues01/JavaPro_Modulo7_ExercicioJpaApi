package br.com.mentorama.jpa_api.entity;


import java.util.List;

public class HospitalizationByPatient {
    private Patient patient;
    private List<HospitalizationHistory> hospitalizationHistories;

    public HospitalizationByPatient(Patient patient, List<HospitalizationHistory> hospitalizationHistories) {
        this.patient = patient;
        this.hospitalizationHistories = hospitalizationHistories;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<HospitalizationHistory> getHospitalizations() {
        return hospitalizationHistories;
    }

    public void setHospitalizations(List<HospitalizationHistory> hospitalizationHistories) {
        this.hospitalizationHistories = hospitalizationHistories;
    }
}
