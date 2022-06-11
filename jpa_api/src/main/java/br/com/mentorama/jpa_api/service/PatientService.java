package br.com.mentorama.jpa_api.service;

import br.com.mentorama.jpa_api.entity.Patient;
import br.com.mentorama.jpa_api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patientRepository.findById(id).orElse(null);
        }
        return null;
    }

    public Patient post(Patient patient){

        return patientRepository.save(patient);
    }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(Long id){
        patientRepository.deleteById(id);

    }

}
