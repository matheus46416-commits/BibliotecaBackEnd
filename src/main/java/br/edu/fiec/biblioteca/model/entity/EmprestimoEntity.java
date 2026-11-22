package br.edu.fiec.biblioteca.model.entity;

import br.edu.fiec.biblioteca.model.dto.EmprestimoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class EmprestimoEntity {

    @Id
    @GeneratedValue
    private long id;
    @Basic
    private String Situacao;
    private Integer dataEmprestimo;
    private Integer dataDevolucao;
    @OneToOne
    private ClienteEntity cliente;
    @OneToOne
    private LivroEntity livro;
    @OneToOne
    private FuncionarioEntity funcionario;

    public EmprestimoEntity(EmprestimoDTO emprestimoDTO){
        setSituacao(emprestimoDTO.getSituacao());
        setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
        setDataDevolucao(emprestimoDTO.getDataDevolucao());
        setCliente(emprestimoDTO.getCliente());
        setLivro(emprestimoDTO.getLivro());
        setFuncionario(emprestimoDTO.getFuncionario());

    }

}