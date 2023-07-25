package br.com.pascoa.pascoamicroservice.dto.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.entities.cliente.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TelefoneDTO {

  private Long id;
  
  @JsonIgnore
  private Cliente cliente;

  private Integer ddd;

  private String numero;
  private boolean whatsapp;
  private String observacao;

  public TelefoneDTO(Telefone telefone) {
    this.cliente = telefone.getCliente();
    this.id = telefone.getId();
    this.ddd = telefone.getDdd();
    this.numero = telefone.getNumero();
    this.whatsapp = telefone.isWhatsapp();
    this.observacao = telefone.getObservacao();
  }



}
