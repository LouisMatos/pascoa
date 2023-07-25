package br.com.pascoa.pascoamicroservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pascoa.pascoamicroservice.dto.cliente.ClienteDTO;
import br.com.pascoa.pascoamicroservice.dto.cliente.EnderecoDTO;
import br.com.pascoa.pascoamicroservice.dto.cliente.TelefoneDTO;
import br.com.pascoa.pascoamicroservice.service.cliente.ClienteService;
import br.com.pascoa.pascoamicroservice.service.cliente.EnderecoService;
import br.com.pascoa.pascoamicroservice.service.cliente.TelefoneService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private TelefoneService telefoneService;
  
  @Autowired
  private EnderecoService enderecoService;

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> findAll() {
    return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}/telefones")
  public ResponseEntity<List<TelefoneDTO>> buscarTelefoneClientID(@PathVariable("id") Long id) {
    return new ResponseEntity<>(telefoneService.buscarTelefoneClientID(id), HttpStatus.OK);
  }
  
  @GetMapping(value = "/{id}/enderecos")
  public ResponseEntity<List<EnderecoDTO>> buscarEnderecoClientID(@PathVariable("id") Long id) {
    return new ResponseEntity<>(enderecoService.buscarEnderecoClientID(id), HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity cadastrarCliente(@RequestBody ClienteDTO dto){
    return new ResponseEntity<>(clienteService.cadastrarCliente(dto), HttpStatus.CREATED);
  }

}
