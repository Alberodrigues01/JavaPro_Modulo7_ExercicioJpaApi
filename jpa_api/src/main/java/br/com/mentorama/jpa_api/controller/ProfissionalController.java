package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.PacienteEntity;
import br.com.mentorama.jpa_api.entity.ProfissionalEntity;
import br.com.mentorama.jpa_api.repository.PacienteRepository;
import br.com.mentorama.jpa_api.repository.ProfissionalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {


        ProfissionalRepository profissionalRepository;

        public ProfissionalController(ProfissionalRepository profissionalRepository) {
            this.profissionalRepository = profissionalRepository;
        }

        @GetMapping
        public List<ProfissionalEntity> findAll(){
            return this.profissionalRepository.findAll();
        }

        @GetMapping("/{id}")
        public ProfissionalEntity findById(@PathVariable("id") final Long id){
            return this.profissionalRepository.findById(id).orElse(null);
        }

        @PostMapping
        public void createNew(@RequestBody final ProfissionalEntity profissional){
            this.profissionalRepository.save(profissional);
        }

        @PutMapping
        public void update(@RequestBody final ProfissionalEntity profissional){
            this.profissionalRepository.save(profissional);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable("id") ProfissionalEntity profissional){
            this.profissionalRepository.delete(profissional);
        }
}
