package br.com.pascoa.pascoamicroservice.service.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pascoa.pascoamicroservice.dto.cliente.TelefoneDTO;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.repository.cliente.TelefoneRepository;


@Service
public class TelefoneService {

  @Autowired
  private TelefoneRepository telefoneRepository;

  public List<TelefoneDTO> buscarTelefoneClientID(Long id) {

    List<TelefoneDTO> telefones = telefoneRepository.findByClienteId(id).stream()
        .map(TelefoneDTO::new).parallel().toList();

    if (telefones.isEmpty()) {
      throw new NotFoundException("Nenhum Telefone cadastrado!");
    }
    return telefones;
  }
}
