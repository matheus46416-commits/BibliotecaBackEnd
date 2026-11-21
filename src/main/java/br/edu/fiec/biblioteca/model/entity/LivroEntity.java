package br.edu.fiec.biblioteca.model.entity;

import br.edu.fiec.biblioteca.model.dto.LivroDTO;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import jakarta.persistence.Basic;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Basic
    Boolean disponivel = true;
    String titulo,autor,genero,isbn;

    public LivroEntity(LivroDTO livroDTO){
        setTitulo(livroDTO.getTitulo());
        setAutor(livroDTO.getAutor());
        setGenero(livroDTO.getGenero());
        setDisponivel(livroDTO.getDisponivel());
    }


}