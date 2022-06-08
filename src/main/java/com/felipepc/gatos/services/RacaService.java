package com.felipepc.gatos.services;

import com.felipepc.gatos.entities.Raca;
import com.felipepc.gatos.enums.BusError;
import com.felipepc.gatos.exceptions.BusErrorException;
import com.felipepc.gatos.repositories.RacaRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RacaService {

  private final RacaRepository racaRepository;
  private final GatoService gatoService;

  public List<Raca> findAll() {
    return racaRepository.findAll();
  }

  public Raca findById(Long id) {
    return racaRepository.findById(id).orElseThrow(() -> new BusErrorException(BusError.E001));
  }

  public Raca save(Raca raca) {
    throwIfExistsByNome(raca);
    return racaRepository.save(raca);
  }

  public void delete(Long id) {
    if (beingUsed(id)) {
      throw new BusErrorException(BusError.E003);
    }
    racaRepository.deleteById(id);
  }

  public Raca update(Long id, Raca raca) {
    var racaExistente = findById(id);
    raca.setId(racaExistente.getId());
    throwIfExistsByNome(raca);
    racaExistente = raca;
    return racaRepository.save(racaExistente);
  }

  private boolean beingUsed(Long id) {
    return gatoService.existsByIdRaca(id);
  }

  private Raca getRacaByNome(Raca raca) {
    return racaRepository.findRacaByNome(raca.getNome());
  }

  private void throwIfExistsByNome(Raca raca) {
    var racaInDatabase = getRacaByNome(raca);
    if (Objects.nonNull(racaInDatabase) && (!racaInDatabase.getId().equals(raca.getId()))) {
      throw new BusErrorException(BusError.E004.getCodigo(),
          BusError.E004.formatarMensagem(racaInDatabase.getNome(), racaInDatabase.getId()));
    }
  }
}
