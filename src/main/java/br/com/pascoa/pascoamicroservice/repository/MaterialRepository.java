package br.com.pascoa.pascoamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.pascoa.pascoamicroservice.entities.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

}
