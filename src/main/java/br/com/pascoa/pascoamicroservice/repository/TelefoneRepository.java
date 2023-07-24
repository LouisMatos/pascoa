package br.com.pascoa.pascoamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pascoa.pascoamicroservice.entities.cliente.Endereco;

public interface TelefoneRepository extends JpaRepository<Endereco, Long> {

}
