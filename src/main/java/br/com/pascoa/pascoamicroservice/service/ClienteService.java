package br.com.pascoa.pascoamicroservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.pascoa.pascoamicroservice.dto.cliente.ClienteDTO;
import br.com.pascoa.pascoamicroservice.repository.ClienteRepository;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional(readOnly = true)
  public List<ClienteDTO> findAll() {
    return clienteRepository.findAll().stream().map(ClienteDTO::new).parallel().toList();
  }

}
