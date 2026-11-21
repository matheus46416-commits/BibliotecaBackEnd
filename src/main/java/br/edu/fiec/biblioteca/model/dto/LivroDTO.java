package br.edu.fiec.biblioteca.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {
    Boolean disponivel;
    String titulo,autor,genero,isbn;
}
