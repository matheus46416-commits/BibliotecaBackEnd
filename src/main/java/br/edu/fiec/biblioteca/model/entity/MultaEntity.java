package br.edu.fiec.biblioteca.model.entity;

import br.edu.fiec.biblioteca.model.dto.MultaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MultaEntity {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private ClienteEntity cliente;
    @OneToOne
    private LivroEntity livro;
    @OneToOne
    private FuncionarioEntity funcionario;
    @OneToOne
    private EmprestimoEntity emprestimoEntity;
    @Column(nullable = false)
    private Double valor;

    public MultaEntity(MultaDTO multaDTO){
        setCliente(multaDTO.getCliente());
        setLivro(multaDTO.getLivro());
        setFuncionario(multaDTO.getFuncionario());
        setEmprestimoEntity(multaDTO.getEmprestimo());
        setValor(multaDTO.getValor());
    }








}