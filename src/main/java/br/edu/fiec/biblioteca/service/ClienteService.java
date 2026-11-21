package br.edu.fiec.biblioteca.service;

import br.edu.fiec.biblioteca.model.dto.ClienteDTO;
import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public void criarCliente(ClienteDTO clienteDTO) {
        clienteRepository.save(new ClienteEntity(clienteDTO));
    }

    public List<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<ClienteEntity> buscarTodosPorNome(String email) {
        return clienteRepository.findAllByNomeContains(email);
    }

    public void atualizarPorId(Integer id, ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);

        if (clienteEntity != null) {
            clienteEntity.setNome(clienteDTO.getNome());
            clienteEntity.setEmail(clienteDTO.getEmail());
            clienteEntity.setTelefone(clienteDTO.getTelefone());
            clienteEntity.setReputacao(clienteDTO.getReputacao());
            clienteEntity.setResidencia(clienteDTO.getResidencia());
            clienteRepository.save(clienteEntity);
        }
    }

    public void deletarPorId(Integer id) {
        clienteRepository.deleteById(id);
    }
}