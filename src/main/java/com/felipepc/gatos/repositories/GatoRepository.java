package com.felipepc.gatos.repositories;

import com.felipepc.gatos.entities.Gato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatoRepository extends JpaRepository<Gato, Long> {

  boolean existsGatoByRaca_Id(Long id);
}
