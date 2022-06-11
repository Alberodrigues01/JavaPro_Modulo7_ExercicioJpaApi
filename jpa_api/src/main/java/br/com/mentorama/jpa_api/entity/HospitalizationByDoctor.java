package br.com.mentorama.jpa_api.entity;

import java.util.List;

public class HospitalizationByDoctor {
    private Doctor doctor;
    private List<HospitalizationHistory> hospitalizationHistories;

    public HospitalizationByDoctor(Doctor doctor, List<HospitalizationHistory> hospitalizationHistories) {
        this.doctor = doctor;
        this.hospitalizationHistories = hospitalizationHistories;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<HospitalizationHistory> getHospitalizations() {
        return hospitalizationHistories;
    }

    public void setHospitalizations(List<HospitalizationHistory> hospitalizationHistories) {
        this.hospitalizationHistories = hospitalizationHistories;
    }
}

