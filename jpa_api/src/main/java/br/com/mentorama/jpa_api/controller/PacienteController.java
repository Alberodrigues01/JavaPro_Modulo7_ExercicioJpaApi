package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.PacienteEntity;
import br.com.mentorama.jpa_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {


    PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<PacienteEntity> findAll(){
        return this.pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public PacienteEntity findById(@PathVariable ("id") final Long id){
        return this.pacienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void createNew(@RequestBody final PacienteEntity paciente){
        this.pacienteRepository.save(paciente);
    }

    @PutMapping
    public void update(@RequestBody final PacienteEntity paciente){
        this.pacienteRepository.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") PacienteEntity paciente){
        this.pacienteRepository.delete(paciente);
    }
}
