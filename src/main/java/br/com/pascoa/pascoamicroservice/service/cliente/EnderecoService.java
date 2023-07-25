package br.com.pascoa.pascoamicroservice.service.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pascoa.pascoamicroservice.dto.cliente.EnderecoDTO;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.repository.cliente.EnderecoRepository;


@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepository;

  public List<EnderecoDTO> buscarEnderecoClientID(Long id) {
    List<EnderecoDTO> enderecos =
        enderecoRepository.findByClienteId(id).stream().map(EnderecoDTO::new).parallel().toList();

    if (enderecos.isEmpty()) {
      throw new NotFoundException("Nenhum Endereço cadastrado!");
    }
    return enderecos;
  }
}
