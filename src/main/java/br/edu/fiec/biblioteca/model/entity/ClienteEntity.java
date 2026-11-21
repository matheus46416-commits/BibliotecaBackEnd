package br.edu.fiec.biblioteca.model.entity;

import br.edu.fiec.biblioteca.model.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue
    private long id;
    @Basic
    private String nome,reputacao,residencia;
    private Integer telefone;
    @Column (unique = true, nullable = false)
    private String email;

    public ClienteEntity(ClienteDTO clienteDTO){
        setNome(clienteDTO.getNome());
        setReputacao(clienteDTO.getReputacao());
        setResidencia(clienteDTO.getResidencia());
        setTelefone(clienteDTO.getTelefone());
        setEmail(clienteDTO.getEmail());
    }

}