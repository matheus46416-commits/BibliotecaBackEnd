package br.edu.fiec.biblioteca.repository;

import br.edu.fiec.biblioteca.model.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {


    List<FuncionarioEntity> findAllByNomeContains(String nome);
}
