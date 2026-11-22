package br.edu.fiec.biblioteca.repository;

import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity,Integer> {
    List<EmprestimoEntity> findAllByClienteContains(ClienteEntity cliente);




}
