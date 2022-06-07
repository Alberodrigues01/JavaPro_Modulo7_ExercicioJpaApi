package br.com.mentorama.jpa_api.controller;

import br.com.mentorama.jpa_api.entity.InternacaoEntity;
import br.com.mentorama.jpa_api.entity.ProfissionalEntity;
import br.com.mentorama.jpa_api.repository.InternacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/internacao")
public class InternacaoController {

    InternacaoRepository internacaoRepository;

    public InternacaoController(InternacaoRepository internacaoRepository) {
        this.internacaoRepository = internacaoRepository;
    }

    @GetMapping
    public List<InternacaoEntity> findAll(){
        return this.internacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public InternacaoEntity findById(@PathVariable("id") final Long id){
        return this.internacaoRepository.findById(id).orElse(null);
    }
    @GetMapping("/qtd_internacao/")
    public List<InternacaoEntity> findByQuantidadeInternacoes(){
        return this.internacaoRepository.findByQuantidadeInternacoes();
    }

    @PostMapping
    public void createNew(@RequestBody final InternacaoEntity internacao){
        this.internacaoRepository.save(internacao);
    }

    @PutMapping
    public void update(@RequestBody final InternacaoEntity internacao){
        this.internacaoRepository.save(internacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") InternacaoEntity internacao){
        this.internacaoRepository.delete(internacao);
    }
}
