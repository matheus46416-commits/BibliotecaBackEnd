package br.edu.fiec.biblioteca.service;

import br.edu.fiec.biblioteca.model.dto.LivroDTO;
import br.edu.fiec.biblioteca.model.entity.LivroEntity;
import br.edu.fiec.biblioteca.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public void criarLivro(LivroDTO livroDTO) {
        livroRepository.save(new LivroEntity(livroDTO));
    }

    public List<LivroEntity> buscarTodos() {
        return livroRepository.findAll();
    }

    public LivroEntity buscarPorId(Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<LivroEntity> buscarTodosPorTitulo(String titulo) {
        return livroRepository.findAllByTituloContains(titulo);
    }

    public void atualizarPorId(Integer id, LivroDTO livroDTO) {
        LivroEntity livroEntity = livroRepository.findById(id).orElse(null);

        if (livroEntity != null) {
            livroRepository.save(livroEntity);
        }
    }

    public void deletarPorId(Integer id) {
        livroRepository.deleteById(id);
    }
}
