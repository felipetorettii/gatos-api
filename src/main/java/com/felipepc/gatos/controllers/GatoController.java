package com.felipepc.gatos.controllers;

import com.felipepc.gatos.entities.Gato;
import com.felipepc.gatos.entities.Raca;
import com.felipepc.gatos.services.GatoService;
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
@RequestMapping(value = "/gatos")
public class GatoController {

  private final GatoService service;

  @GetMapping
  public List<Gato> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Gato findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping
  public Gato save(@RequestBody Gato gato) {
    return service.save(gato);
  }

  @PutMapping("/{id}")
  public Gato findById(@PathVariable("id") Long id, @RequestBody Gato gato) {
    return service.update(id, gato);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }
}
