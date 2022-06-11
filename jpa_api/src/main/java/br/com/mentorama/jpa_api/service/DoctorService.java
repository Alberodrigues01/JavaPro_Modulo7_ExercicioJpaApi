package br.com.mentorama.jpa_api.service;

import br.com.mentorama.jpa_api.entity.Doctor;
import br.com.mentorama.jpa_api.entity.Patient;
import br.com.mentorama.jpa_api.repository.DoctorRepository;
import br.com.mentorama.jpa_api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(null);
    }

    public Doctor post(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor update(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void delete(Long id){
        doctorRepository.deleteById(id);
    }

}
