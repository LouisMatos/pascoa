package br.com.pascoa.pascoamicroservice.repository.cliente;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pascoa.pascoamicroservice.entities.cliente.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

  List<Telefone> findByClienteId(Long id);

}
