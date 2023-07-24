package br.com.pascoa.pascoamicroservice.entities.cliente;

import static jakarta.persistence.CascadeType.ALL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "tb_cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(exclude = {"telefone", "endereco"})
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente", updatable = false)
  private Long id;

  @OneToMany(fetch = FetchType.EAGER, targetEntity = Telefone.class, mappedBy = "cliente",
      orphanRemoval = true, cascade = {ALL})
  @Builder.Default
  private Set<Telefone> telefone = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER, targetEntity = Endereco.class, mappedBy = "cliente",
      orphanRemoval = true, cascade = {ALL})
  @Builder.Default
  private Set<Endereco> endereco = new HashSet<>();

  @NotNull
  private String nome;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date dataNascimento;

  private String cpf;

  private String instagram;

  private String facebook;

  @Email
  private String email;

  @Column(insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCadastro;

}
