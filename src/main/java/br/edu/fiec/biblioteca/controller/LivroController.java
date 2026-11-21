package br.edu.fiec.biblioteca.controller;

import br.edu.fiec.biblioteca.model.dto.LivroDTO;
import br.edu.fiec.biblioteca.model.entity.LivroEntity;
import br.edu.fiec.biblioteca.service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("Livro")
public class LivroController {

    private final LivroService livroService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarLivro(@RequestBody LivroDTO livroDTO) {
        livroService.criarLivro(livroDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<LivroEntity> buscarTodos() {
        return livroService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public LivroEntity buscarPorId(@RequestParam Integer id) {
        return livroService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name", produces = APPLICATION_JSON_VALUE)
    public List<LivroEntity> buscarTodosPorNome(@RequestParam String titulo) {
        return livroService.buscarTodosPorTitulo(titulo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value= "/id", consumes = APPLICATION_JSON_VALUE)
    public void updateClientById(
            @RequestParam Integer id,
            @RequestBody LivroDTO clientDTO
    ) {
        livroService.atualizarPorId(id, clientDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@RequestParam Integer id) {
        livroService.deletarPorId(id);
    }

}