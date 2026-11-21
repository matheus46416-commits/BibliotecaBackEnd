package br.edu.fiec.biblioteca.controller;

import br.edu.fiec.biblioteca.model.dto.ClienteDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("Cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<ClienteEntity> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ClienteEntity buscarPorId(@RequestParam Integer id) {
        return clienteService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name", produces = APPLICATION_JSON_VALUE)
    public List<ClienteEntity> buscarTodosPorNome(@RequestParam String name) {
        return clienteService.buscarTodosPorNome(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value= "/id", consumes = APPLICATION_JSON_VALUE)
    public void updateClientById(
            @RequestParam Integer id,
            @RequestBody ClienteDTO clientDTO
    ) {
        clienteService.atualizarPorId(id, clientDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@RequestParam Integer id) {
        clienteService.deletarPorId(id);
    }

}
