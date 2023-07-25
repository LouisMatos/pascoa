package br.com.pascoa.pascoamicroservice.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
