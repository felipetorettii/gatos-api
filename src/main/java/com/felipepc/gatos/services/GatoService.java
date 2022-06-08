package com.felipepc.gatos.services;

import com.felipepc.gatos.entities.Gato;
import com.felipepc.gatos.enums.BusError;
import com.felipepc.gatos.exceptions.BusErrorException;
import com.felipepc.gatos.repositories.GatoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GatoService {

  private final GatoRepository gatoRepository;

  public List<Gato> findAll() {
    return gatoRepository.findAll();
  }

  public Gato findById(Long id) {
    return gatoRepository.findById(id).orElseThrow(() -> new BusErrorException(BusError.E002));
  }

  public Gato save(Gato raca) {
    return gatoRepository.save(raca);
  }

  public void delete(Long id) {
    gatoRepository.deleteById(id);
  }

  public Gato update(Long id, Gato gato) {
    var gatoExistente = findById(id);
    gato.setId(gatoExistente.getId());
    gatoExistente = gato;
    return gatoRepository.save(gatoExistente);
  }

  public boolean existsByIdRaca(Long id) {
    return gatoRepository.existsGatoByRaca_Id(id);
  }
}
