package com.felipepc.gatos.repositories;

import com.felipepc.gatos.entities.Raca;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacaRepository extends JpaRepository<Raca, Long> {

  Raca findRacaByNome(String nome);

}
