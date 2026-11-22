package br.edu.fiec.biblioteca.service;

import br.edu.fiec.biblioteca.model.dto.MultaDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.MultaEntity;
import br.edu.fiec.biblioteca.repository.MultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MultaService {
    private final MultaRepository multaRepository;

    public void criarMulta(MultaDTO multaDTO) {
        multaRepository.save(new MultaEntity(multaDTO));
    }

    public List<MultaEntity> buscarTodos() {
        return multaRepository.findAll();
    }

    public MultaEntity buscarPorId(Integer id) {
        return multaRepository.findById(id).orElse(null);
    }

    public List<MultaEntity> buscarTodosPorCliente(ClienteEntity cliente) {
        return multaRepository.findAllByClienteContains(cliente);
    }

    public void atualizarPorId(Integer id, MultaDTO multaDTO) {
        MultaEntity multaEntity = multaRepository.findById(id).orElse(null);
        if (multaEntity != null) {
            multaEntity.setCliente(multaDTO.getCliente());
            multaEntity.setLivro(multaDTO.getLivro());
            multaEntity.setFuncionario(multaDTO.getFuncionario());
            multaEntity.setValor(multaDTO.getValor());
            multaRepository.save(multaEntity);
        }
    }

    public void deletarPorId(Integer id) {
        multaRepository.deleteById(id);
    }
}
