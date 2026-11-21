package br.edu.fiec.biblioteca.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private String nome,reputacao,residencia;
    private Integer telefone;
    private String email;
}
