package br.edu.fiec.biblioteca.controller;

import br.edu.fiec.biblioteca.model.dto.FuncionarioDTO;
import br.edu.fiec.biblioteca.model.entity.FuncionarioEntity;
import br.edu.fiec.biblioteca.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("Funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.criarFuncionario(funcionarioDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<FuncionarioEntity> buscarTodos() {
        return funcionarioService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public FuncionarioEntity buscarPorId(@RequestParam Integer id) {
        return funcionarioService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name", produces = APPLICATION_JSON_VALUE)
    public List<FuncionarioEntity> buscarTodosPorNome(@RequestParam String name) {
        return funcionarioService.buscarTodosPorNome(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value= "/id", consumes = APPLICATION_JSON_VALUE)
    public void updateClientById(
            @RequestParam Integer id,
            @RequestBody FuncionarioDTO clientDTO
    ) {
        funcionarioService.atualizarPorId(id, clientDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@RequestParam Integer id) {
        funcionarioService.deletarPorId(id);
    }

}
