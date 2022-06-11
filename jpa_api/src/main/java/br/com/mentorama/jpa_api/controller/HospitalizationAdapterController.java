package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.adapters.HospitalizationAdapter;
import br.com.mentorama.jpa_api.entity.*;
import br.com.mentorama.jpa_api.service.DoctorService;
import br.com.mentorama.jpa_api.service.HospitalizationHistoryService;
import br.com.mentorama.jpa_api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/adapter")

public class HospitalizationAdapterController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalizationHistoryService hospitalizationHistoryService;

    @Autowired
    private HospitalizationAdapter hospitalizationAdapter;

    @GetMapping("by-patients")
    public ResponseEntity<List<HospitalizationByPatient>> hospitalizationByPatient() {
        List<Patient> patients = patientService.findAll();
        List<HospitalizationHistory> hospitalizationHistories = hospitalizationHistoryService.findAll();
        List<HospitalizationByPatient> hospitalizationByPatients =
                hospitalizationAdapter.adaptHospitalizationByPatient(hospitalizationHistories, patients);

        return new ResponseEntity<>(hospitalizationByPatients, HttpStatus.OK);
    }

    @GetMapping("by-doctors")
    public ResponseEntity<List<HospitalizationByDoctor>> hospitalizationByDoctor() {
        List<Doctor> doctors = doctorService.findAll();
        List<HospitalizationHistory> hospitalizationHistories = hospitalizationHistoryService.findAll();
        List<HospitalizationByDoctor> hospitalizationByDoctors =
                hospitalizationAdapter.adapterHospitalizationByDoctor(hospitalizationHistories, doctors );

        return new ResponseEntity<>(hospitalizationByDoctors, HttpStatus.OK);
    }
}
