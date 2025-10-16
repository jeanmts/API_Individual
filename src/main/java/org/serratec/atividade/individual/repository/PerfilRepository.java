package org.serratec.atividade.individual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.serratec.atividade.individual.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
