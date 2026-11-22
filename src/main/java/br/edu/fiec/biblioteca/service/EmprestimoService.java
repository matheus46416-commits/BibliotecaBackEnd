package br.edu.fiec.biblioteca.service;

import br.edu.fiec.biblioteca.model.dto.EmprestimoDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.EmprestimoEntity;
import br.edu.fiec.biblioteca.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public void criarEmprestimo(EmprestimoDTO emprestimoDTO) {
        emprestimoRepository.save(new EmprestimoEntity(emprestimoDTO));
    }

    public List<EmprestimoEntity> buscarTodos() {
        return emprestimoRepository.findAll();
    }

    public EmprestimoEntity buscarPorId(Integer id) {
        return emprestimoRepository.findById(id).orElse(null);
    }

    public List<EmprestimoEntity> buscarTodosPorCliente(ClienteEntity cliente) {
        return emprestimoRepository.findAllByClienteContains(cliente);
    }

    public void atualizarPorId(Integer id, EmprestimoDTO emprestimoDTO) {
        EmprestimoEntity emprestimoEntity = emprestimoRepository.findById(id).orElse(null);

        if (emprestimoEntity != null) {
            emprestimoEntity.setSituacao(emprestimoDTO.getSituacao());
            emprestimoEntity.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
            emprestimoEntity.setDataDevolucao(emprestimoDTO.getDataDevolucao());
            emprestimoEntity.setCliente(emprestimoDTO.getCliente());
            emprestimoEntity.setLivro(emprestimoDTO.getLivro());
            emprestimoEntity.setFuncionario(emprestimoDTO.getFuncionario());
            emprestimoRepository.save(emprestimoEntity);
        }
    }

    public void deletarPorId(Integer id) {
        emprestimoRepository.deleteById(id);
    }
}
