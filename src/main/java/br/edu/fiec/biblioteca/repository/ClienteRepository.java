package br.edu.fiec.biblioteca.repository;

import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {
    List<ClienteEntity> findAllByNomeContains(String nome);
}
