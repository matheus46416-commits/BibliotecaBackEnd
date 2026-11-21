package br.edu.fiec.biblioteca.model.entity;

import br.edu.fiec.biblioteca.model.dto.FuncionarioDTO;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Data
@Entity
@NoArgsConstructor
public class FuncionarioEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String nome,residencia;
    @Column (unique = true,nullable = false)
    private Integer cpf,telefone;
    @Column (unique = true, nullable = false)
    private String email;
    @Column (nullable = false, length = 60)
    private String senha;

    public FuncionarioEntity(FuncionarioDTO funcionarioDTO){
        setCpf(funcionarioDTO.getCpf());
        setNome(funcionarioDTO.getNome());
        setEmail(funcionarioDTO.getEmail());
        setSenha(funcionarioDTO.getSenha());
        setTelefone(funcionarioDTO.getTelefone());
        setResidencia(funcionarioDTO.getResidencia());
    }

}