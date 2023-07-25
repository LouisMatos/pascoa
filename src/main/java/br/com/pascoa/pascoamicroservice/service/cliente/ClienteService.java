package br.com.pascoa.pascoamicroservice.service.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.pascoa.pascoamicroservice.dto.cliente.ClienteDTO;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.repository.cliente.ClienteRepository;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional(readOnly = true)
  public List<ClienteDTO> findAll() {
    return clienteRepository.findAll().stream().map(ClienteDTO::new).parallel().toList();
  }

  public ClienteDTO findById(Long id) {
    return new ClienteDTO(clienteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado!")));
  }

  public ClienteDTO cadastrarCliente(ClienteDTO dto) {
    return new ClienteDTO(clienteRepository.saveAndFlush(new Cliente(dto)));
  }

}
