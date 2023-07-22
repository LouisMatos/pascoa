package br.com.pascoa.pascoamicroservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.pascoa.pascoamicroservice.dto.MaterialDTO;
import br.com.pascoa.pascoamicroservice.entities.Categoria;
import br.com.pascoa.pascoamicroservice.entities.Material;
import br.com.pascoa.pascoamicroservice.exception.NotFoundException;
import br.com.pascoa.pascoamicroservice.repository.MaterialRepository;

@Service
public class MaterialService {

  @Autowired
  private MaterialRepository materialRepository;

  @Transactional(readOnly = true)
  public List<MaterialDTO> findAll() {
    return materialRepository.findAll().stream().map(MaterialDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public MaterialDTO findById(Long id) {
    return new MaterialDTO(materialRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Material não encontrado!")));
  }

  public MaterialDTO newMaterial(MaterialDTO dto) {

    Material material = convertDTOtoentity(dto);



    return new MaterialDTO(materialRepository.save(material));
  }

  private Material convertDTOtoentity(MaterialDTO dto) {
    return Material.builder() //
        .categoria(new Categoria(dto.getCategoriaId(), null))//
        .quantidade(dto.getQuantidade())//
        .peso(dto.getPeso())//
        .preco(dto.getPreco())//
        .descricao(dto.getDescricao())//
        .nome(dto.getNome())//
        .build();
    //
    // material.getCategoria().setId(dto.getCategoriaId());
    // material.setQuantidade(dto.getQuantidade());
    // material.setPeso(dto.getPeso());
    // material.setPreco(dto.getPreco());
    // material.setDescricao(dto.getDescricao());
    // material.setNome(dto.getNome());

  }

}
