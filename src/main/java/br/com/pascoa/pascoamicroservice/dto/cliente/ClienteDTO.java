package br.com.pascoa.pascoamicroservice.dto.cliente;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.pascoa.pascoamicroservice.entities.cliente.Cliente;
import br.com.pascoa.pascoamicroservice.entities.cliente.Endereco;
import br.com.pascoa.pascoamicroservice.entities.cliente.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {

  private Long id;

  @JsonIgnore
  private Set<Telefone> telefone = new HashSet<>();

  @JsonIgnore
  private Set<Endereco> endereco = new HashSet<>();

  private String nome;

  private Date dataNascimento;

  private String cpf;

  private String instagram;

  private String facebook;

  private String email;

  private LocalDateTime dataCadastro;

  public ClienteDTO(Cliente cliente) {
    this.id = cliente.getId();
    this.telefone = cliente.getTelefone();
    this.endereco = cliente.getEndereco();
    this.nome = cliente.getNome();
    this.dataNascimento = cliente.getDataNascimento();
    this.cpf = cliente.getCpf();
    this.instagram = cliente.getInstagram();
    this.facebook = cliente.getFacebook();
    this.email = cliente.getEmail();
    this.dataCadastro = cliente.getDataCadastro();
  }

}
