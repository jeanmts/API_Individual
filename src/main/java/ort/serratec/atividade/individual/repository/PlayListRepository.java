package ort.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ort.serratec.atividade.individual.domain.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
}
