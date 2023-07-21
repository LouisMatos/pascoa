package br.com.pascoa.pascoamicroservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pascoa.pascoamicroservice.dto.CustomHealtChectDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/health")
public class CustomHealthCheck {

  @GetMapping
  public ResponseEntity<CustomHealtChectDTO> health() {
    CustomHealtChectDTO dto = new CustomHealtChectDTO();
    dto.setStatus("UP");
    log.info("Health Check: OK");
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

}
