package org.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.atividade.individual.domain.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
