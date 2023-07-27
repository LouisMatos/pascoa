package br.com.pascoa.pascoamicroservice.entities.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.pascoa.pascoamicroservice.dto.cliente.TelefoneDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_telefone")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cliente"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"cliente"})
@Getter
@Setter
public class Telefone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_telefone")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_cliente_fk")
  @NotNull
  private Cliente cliente;

  private Integer ddd;

  @NotNull
  private String numero;
  private boolean whatsapp;
  private String observacao;



  public Telefone(TelefoneDTO dto) {
    this.cliente = dto.getCliente();
    this.ddd = dto.getDdd();
    this.numero = dto.getNumero();
    this.whatsapp = dto.isWhatsapp();
    this.observacao = dto.getObservacao();
  }



}
