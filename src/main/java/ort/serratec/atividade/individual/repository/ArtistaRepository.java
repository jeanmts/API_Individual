package ort.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ort.serratec.atividade.individual.domain.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
