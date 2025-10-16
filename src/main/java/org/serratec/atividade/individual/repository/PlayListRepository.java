package org.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade.individual.domain.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
}
