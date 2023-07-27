package br.com.pascoa.pascoamicroservice.service.cliente;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.pascoa.pascoamicroservice.dto.cliente.TelefoneDTO;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.entities.cliente.Telefone;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.exception.UnprocessableEntity;
import br.com.pascoa.pascoamicroservice.repository.cliente.ClienteRepository;
import br.com.pascoa.pascoamicroservice.repository.cliente.TelefoneRepository;


@Service
public class TelefoneService {

  @Autowired
  private TelefoneRepository telefoneRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional(readOnly = true)
  public List<TelefoneDTO> buscarTelefoneClientID(Long id) {

    List<TelefoneDTO> telefones =
        telefoneRepository.findByClienteId(id).stream().map(TelefoneDTO::new).parallel().toList();

    if (telefones.isEmpty()) {
      throw new NotFoundException("Nenhum Telefone cadastrado!");
    }
    return telefones;
  }


  public TelefoneDTO cadastrarTelefoneCliente(Long id, TelefoneDTO dto) {

    Cliente cliente = clienteRepository.findById(id).orElseThrow(
        () -> new NotFoundException("Cliente não encontrado para o cadastro de telefone!"));

    dto.setCliente(cliente);

    return new TelefoneDTO(telefoneRepository.save(new Telefone(dto)));
  }


  @Transactional
  public void deletarTelefoneCliente(Long idCliente, Long idTelefone) {


    boolean del = false;

    Cliente cliente =
        clienteRepository.findById(idCliente).orElseThrow(() -> new UnprocessableEntity(
            "Não é possivel excluir o telefone! Cliente não encontrado!"));


    List<Telefone> telefones = telefoneRepository.findByClienteId(cliente.getId());


    if (telefones.isEmpty()) {
      throw new NotFoundException("Cliente não possiu telefones cadastrados!");
    } else {

      for (int i = 0; i < telefones.size(); i++) {

        if (Objects.equals(telefones.get(i).getId(), idTelefone)) {

          telefoneRepository.delete(telefones.get(i));

          del = true;

        }

      }

    }

    if (!del) {

      throw new NotFoundException("Telefone não encontrado para o cliente informado!");

    }

  }
}
