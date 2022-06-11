package br.com.mentorama.jpa_api.adapters;

import br.com.mentorama.jpa_api.entity.*;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HospitalizationAdapter {
    public List<HospitalizationByPatient> adaptHospitalizationByPatient(
                     List<HospitalizationHistory> hospitalizationHistories,
                     List<Patient> patients){
        List<HospitalizationByPatient> hospitalizationByPatients = patients.stream()
                     .map(patient -> {
            List<HospitalizationHistory> hospitalizationsByPatient = hospitalizationHistories.stream()
                    .filter(history->history.getPatient().getId()
                    .equals (patient.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByPatient(patient,hospitalizationsByPatient);
        }).collect(Collectors.toList());
        return hospitalizationByPatients;
    }

    public List<HospitalizationByDoctor> adapterHospitalizationByDoctor(
                   List<HospitalizationHistory> hospitalizationHistories,
                   List<Doctor> doctors){
        List<HospitalizationByDoctor> hospitalizationByDoctors = doctors.stream()
                     .map(doctor ->{
            List<HospitalizationHistory> hospitalizationHistoryList = hospitalizationHistories.stream()
                    .filter(history->history.getPatient().getId()
                    .equals(doctor.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByDoctor(doctor, hospitalizationHistoryList);
        }).collect(Collectors.toList());
        return hospitalizationByDoctors;
    }

    /*public List <Doctor> doctors = new ArrayList<>() {

        Map<String, Long> quantityOfDoctorByDepartment = doctors.stream()
                .collect(Collectors.groupingBy(Doctor::getDepartment,
                        Collectors.counting()));
      }*/

}

