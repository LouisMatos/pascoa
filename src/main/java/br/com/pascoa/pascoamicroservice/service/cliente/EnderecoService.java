package br.com.pascoa.pascoamicroservice.service.cliente;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.pascoa.pascoamicroservice.dto.cliente.EnderecoDTO;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.entities.cliente.Endereco;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.exception.UnprocessableEntity;
import br.com.pascoa.pascoamicroservice.repository.cliente.ClienteRepository;
import br.com.pascoa.pascoamicroservice.repository.cliente.EnderecoRepository;
import br.com.pascoa.pascoamicroservice.repository.cliente.TelefoneRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional(readOnly = true)
  public List<EnderecoDTO> buscarEnderecoClientID(Long id) {
    List<EnderecoDTO> enderecos =
        enderecoRepository.findByClienteId(id).stream().map(EnderecoDTO::new).parallel().toList();

    if (enderecos.isEmpty()) {
      throw new NotFoundException("Nenhum Endereço cadastrado!");
    }
    return enderecos;
  }

  @Transactional
  public EnderecoDTO cadastrarEnderecoCliente(Long id, EnderecoDTO dto) {

    Cliente cliente = clienteRepository.findById(id).orElseThrow(
        () -> new NotFoundException("Cliente não encontrado para o cadastro de endereço!"));

    dto.setCliente(cliente);

    return new EnderecoDTO(enderecoRepository.save(new Endereco(dto)));
  }


  @Transactional
  public void deletarEnderecoCliente(Long idCliente, Long idEndereco) {

    boolean del = false;

    Cliente cliente =
        clienteRepository.findById(idCliente).orElseThrow(() -> new UnprocessableEntity(
            "Não é possivel excluir o endereço! Cliente não encontrado!"));


    List<Endereco> enderecos = enderecoRepository.findByClienteId(cliente.getId());


    if (enderecos.isEmpty()) {
      throw new NotFoundException("Cliente não possiu endereços cadastrados!");
    } else {

      for (int i = 0; i < enderecos.size(); i++) {

        if (Objects.equals(enderecos.get(i).getId(), idEndereco)) {

          enderecoRepository.delete(enderecos.get(i));

          del = true;

        }

      }

    }

    if (!del) {

      throw new NotFoundException("Endereço não encontrado para o cliente informado!");

    }

  }

  
}


