package br.com.pascoa.pascoamicroservice.repository.cliente;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pascoa.pascoamicroservice.entities.cliente.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

  List<Endereco> findByClienteId(Long id);

}
