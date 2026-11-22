package br.edu.fiec.biblioteca.controller;

import br.edu.fiec.biblioteca.model.dto.ClienteDTO;
import br.edu.fiec.biblioteca.model.dto.EmprestimoDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.EmprestimoEntity;
import br.edu.fiec.biblioteca.service.ClienteService;
import br.edu.fiec.biblioteca.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("Emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        emprestimoService.criarEmprestimo(emprestimoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<EmprestimoEntity> buscarTodos() {
        return emprestimoService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public EmprestimoEntity buscarPorId(@RequestParam Integer id) {
        return emprestimoService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/cliente", produces = APPLICATION_JSON_VALUE)
    public List<EmprestimoEntity> buscarTodosPorCliente(@RequestParam ClienteEntity cliente) {
        return emprestimoService.buscarTodosPorCliente(cliente);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value= "/id", consumes = APPLICATION_JSON_VALUE)
    public void updateClientById(
            @RequestParam Integer id,
            @RequestBody EmprestimoDTO emprestimoDTO
    ) {
        emprestimoService.atualizarPorId(id, emprestimoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@RequestParam Integer id) {
        emprestimoService.deletarPorId(id);
    }

}
