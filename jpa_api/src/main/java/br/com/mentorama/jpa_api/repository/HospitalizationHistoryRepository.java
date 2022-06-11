package br.com.mentorama.jpa_api.repository;

import br.com.mentorama.jpa_api.entity.HospitalizationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationHistoryRepository extends JpaRepository<HospitalizationHistory, Long> {


}
