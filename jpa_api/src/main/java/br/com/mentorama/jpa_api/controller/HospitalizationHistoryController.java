package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.adapters.HospitalizationAdapter;
import br.com.mentorama.jpa_api.entity.*;
import br.com.mentorama.jpa_api.service.DoctorService;
import br.com.mentorama.jpa_api.service.HospitalizationHistoryService;
import br.com.mentorama.jpa_api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/hospitalizationhistory")

public class HospitalizationHistoryController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalizationHistoryService hospitalizationHistoryService;

    @Autowired
    private HospitalizationAdapter hospitalizationAdapter;

    @GetMapping
    public ResponseEntity<List<HospitalizationHistory>> findAll(){
        return new ResponseEntity<>(hospitalizationHistoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalizationHistory> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(hospitalizationHistoryService.findById(id),HttpStatus.OK);
    }

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

    @PostMapping
    public ResponseEntity<HospitalizationHistory>
                             post(@RequestBody HospitalizationHistory hospitalizationHistory){
        return new ResponseEntity<>(hospitalizationHistoryService.post(hospitalizationHistory),
                                    HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HospitalizationHistory>
                             update(@RequestBody HospitalizationHistory hospitalizationHistory){
        return new ResponseEntity<>(hospitalizationHistoryService.update(hospitalizationHistory),
                                    HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id){
        hospitalizationHistoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
