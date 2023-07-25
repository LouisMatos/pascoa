package br.com.pascoa.pascoamicroservice.dto.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.entities.cliente.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoDTO {

  private Long id;

  @JsonIgnore
  private Cliente cliente;

  private String rua;

  private String bairro;

  private String complemento;

  private String numero;

  @JsonIgnore
  private String cep;

  public EnderecoDTO(Endereco endereco) {
    this.id = endereco.getId();
    this.cliente = endereco.getCliente();
    this.rua = endereco.getRua();
    this.bairro = endereco.getBairro();
    this.complemento = endereco.getComplemento();
    this.numero = endereco.getNumero();
    this.cep = endereco.getCep();
  }
}
