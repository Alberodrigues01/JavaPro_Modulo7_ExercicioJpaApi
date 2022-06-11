package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.Doctor;
import br.com.mentorama.jpa_api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> findAll(){
        return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(doctorService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> post(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.post(doctor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.update(doctor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id){
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
