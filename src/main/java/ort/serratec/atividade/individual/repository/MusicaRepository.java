package ort.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ort.serratec.atividade.individual.domain.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
