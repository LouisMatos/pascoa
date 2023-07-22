package br.com.pascoa.pascoamicroservice.dto;

import java.math.BigInteger;
import br.com.pascoa.pascoamicroservice.entities.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialDTO {

  private Long id;
  private Integer quantidade;
  private Double peso;
  private BigInteger preco;
  private String descricao;
  private String nome;
  private Long categoriaId;


  public MaterialDTO(Material material) {
    id = material.getId();
    quantidade = material.getQuantidade();
    peso = material.getPeso();
    preco = material.getPreco();
    descricao = material.getDescricao();
    nome = material.getNome();
    categoriaId = material.getCategoria().getId();
  }

}
