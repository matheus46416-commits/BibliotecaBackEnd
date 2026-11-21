package br.edu.fiec.biblioteca.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Integer cpf,telefone;
    private String nome,residencia;
    private String email;
    private String senha;
}
