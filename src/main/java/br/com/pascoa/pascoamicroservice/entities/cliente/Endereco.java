package br.com.pascoa.pascoamicroservice.entities.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "tb_endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cliente"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(exclude = {"cliente"})
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_endereco")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_cliente_fk")
  @NotNull
  @JsonIgnore
  private Cliente cliente;

  @NotNull(message = "Rua deve ser preenchida")
  private String rua;

  @NotNull(message = "Bairro deve ser preenchido")
  private String bairro;

  private String complemento;

  @NotNull(message = "Número deve ser preenchido")
  private String numero;

  @JsonIgnore
  private String cep;

}
