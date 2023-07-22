package br.com.pascoa.pascoamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pascoa.pascoamicroservice.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
