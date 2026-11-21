package br.edu.fiec.biblioteca.service;

import br.edu.fiec.biblioteca.model.dto.FuncionarioDTO;
import br.edu.fiec.biblioteca.model.entity.FuncionarioEntity;
import br.edu.fiec.biblioteca.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public void criarFuncionario(FuncionarioDTO funcionarioDTO) {
        funcionarioRepository.save(new FuncionarioEntity(funcionarioDTO));
    }

    public List<FuncionarioEntity> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioEntity buscarPorId(Integer id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<FuncionarioEntity> buscarTodosPorNome(String nome) {
        return funcionarioRepository.findAllByNomeContains(nome);
    }

    public void atualizarPorId(Integer id, FuncionarioDTO funcionarioDTO) {
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(id).orElse(null);

        if (funcionarioEntity != null) {
            funcionarioEntity.setNome(funcionarioDTO.getNome());
            funcionarioEntity.setEmail(funcionarioDTO.getEmail());
            funcionarioEntity.setTelefone(funcionarioDTO.getTelefone());
            funcionarioEntity.setResidencia(funcionarioDTO.getResidencia());
            funcionarioRepository.save(funcionarioEntity);
        }
    }

    public void deletarPorId(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
