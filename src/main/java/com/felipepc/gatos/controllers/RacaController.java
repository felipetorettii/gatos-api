package com.felipepc.gatos.controllers;

import com.felipepc.gatos.entities.Gato;
import com.felipepc.gatos.entities.Raca;
import com.felipepc.gatos.services.RacaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/racas")
public class RacaController {

  private final RacaService service;

  @GetMapping
  public List<Raca> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Raca findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping
  public Raca save(@RequestBody Raca raca) {
    return service.save(raca);
  }

  @PutMapping("/{id}")
  public Raca findById(@PathVariable("id") Long id, @RequestBody Raca raca) {
    return service.update(id, raca);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }
}
