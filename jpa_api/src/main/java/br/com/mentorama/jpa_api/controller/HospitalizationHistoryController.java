package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.Doctor;
import br.com.mentorama.jpa_api.entity.HospitalizationHistory;
import br.com.mentorama.jpa_api.service.DoctorService;
import br.com.mentorama.jpa_api.service.HospitalizationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/hospitalization")

public class HospitalizationHistoryController {

    @Autowired
    private HospitalizationHistoryService hospitalizationHistoryService;

    @GetMapping
    public ResponseEntity<List<HospitalizationHistory>> findAll(){
        return new ResponseEntity<>(hospitalizationHistoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalizationHistory> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(hospitalizationHistoryService.findById(id),HttpStatus.OK);
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
