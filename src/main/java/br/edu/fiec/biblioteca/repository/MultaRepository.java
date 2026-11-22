package br.edu.fiec.biblioteca.repository;

import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.MultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<MultaEntity,Integer> {
    List<MultaEntity> findAllByClienteContains(ClienteEntity cliente);
}
