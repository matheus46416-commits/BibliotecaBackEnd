package br.edu.fiec.biblioteca.repository;

import br.edu.fiec.biblioteca.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity,Integer> {
    List <LivroEntity> findAllByTituloContains(String titulo);
}
