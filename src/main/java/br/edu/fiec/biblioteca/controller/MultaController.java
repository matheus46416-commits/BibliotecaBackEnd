package br.edu.fiec.biblioteca.controller;

import br.edu.fiec.biblioteca.model.dto.ClienteDTO;
import br.edu.fiec.biblioteca.model.dto.MultaDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.MultaEntity;
import br.edu.fiec.biblioteca.service.ClienteService;
import br.edu.fiec.biblioteca.service.MultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("Multa")
public class MultaController {

    private final MultaService multaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void criarMulta(@RequestBody MultaDTO multaDTO) {
        multaService.criarMulta(multaDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<MultaEntity> buscarTodos() {
        return multaService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public MultaEntity buscarPorId(@RequestParam Integer id) {
        return multaService.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/cliente", produces = APPLICATION_JSON_VALUE)
    public List<MultaEntity> buscarTodosPorCliente(@RequestParam ClienteEntity cliente) {
        return multaService.buscarTodosPorCliente(cliente);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/id", consumes = APPLICATION_JSON_VALUE)
    public void updateClientById(
            @RequestParam Integer id,
            @RequestBody MultaDTO multaDTO
    ) {
        multaService.atualizarPorId(id, multaDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void deleteClientById(@RequestParam Integer id) {
        multaService.deletarPorId(id);
    }
}
