package br.com.mentorama.jpa_api.repository;

import br.com.mentorama.jpa_api.entity.InternacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternacaoRepository extends JpaRepository<InternacaoEntity, Long> {

   @Query(value = "SELECT i.id_paciente AS paciente, p.nome"+
           "COUNT(p.nome) AS qtd_internacoes"+
           "FROM internacoes i"+
           "INNER JOIN pacientes p"+
           "ON i.id_paciente = p.id"+
           "GROUP BY id_paciente, p.nome"+
           "ORDER BY qtd_internacoes desc", nativeQuery = true)

            List<InternacaoEntity>findByQuantidadeInternacoes();

}
