package br.com.pascoa.pascoamicroservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pascoa.pascoamicroservice.dto.cliente.ClienteDTO;
import br.com.pascoa.pascoamicroservice.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
  
  @Autowired
  private ClienteService clienteService;
  
  
  @GetMapping
  public ResponseEntity<List<ClienteDTO>> findAll(){
    return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
  }
  

}
