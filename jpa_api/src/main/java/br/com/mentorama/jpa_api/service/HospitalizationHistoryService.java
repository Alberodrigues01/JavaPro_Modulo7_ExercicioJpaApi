package br.com.mentorama.jpa_api.service;

import br.com.mentorama.jpa_api.entity.Doctor;
import br.com.mentorama.jpa_api.entity.HospitalizationHistory;
import br.com.mentorama.jpa_api.repository.DoctorRepository;
import br.com.mentorama.jpa_api.repository.HospitalizationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationHistoryService {

    @Autowired
    private HospitalizationHistoryRepository hospitalizationHistoryRepository;

    public List<HospitalizationHistory> findAll(){
        return hospitalizationHistoryRepository.findAll();
    }

    public HospitalizationHistory findById(Long id) {
        return hospitalizationHistoryRepository.findById(id).orElseThrow(null);
    }

    public HospitalizationHistory post(HospitalizationHistory hospitalizationHistory){
        return hospitalizationHistoryRepository.save(hospitalizationHistory);
    }

    public HospitalizationHistory update(HospitalizationHistory hospitalizationHistory){
        return hospitalizationHistoryRepository.save(hospitalizationHistory);
    }

    public void delete(Long id){
        hospitalizationHistoryRepository.deleteById(id);
    }

}
