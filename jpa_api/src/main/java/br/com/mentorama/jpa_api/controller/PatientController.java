package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.Patient;
import br.com.mentorama.jpa_api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity <List<Patient>> findAll(){
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(patientService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> post(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.post(patient), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.update(patient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id){
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
