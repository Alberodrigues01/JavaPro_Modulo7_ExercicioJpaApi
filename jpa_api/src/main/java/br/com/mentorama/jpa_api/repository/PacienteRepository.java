package br.com.mentorama.jpa_api.repository;

import br.com.mentorama.jpa_api.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    @Override
    List<PacienteEntity> findAll();


}
