/*package br.edu.fiec.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String Situacao;
    private Integer dataEmprestimo;
    private Integer dataDevolucao;
    private ClienteEntity cliente;
    private LivroEntity livro;
    private FuncionarioEntity funcionario;
}*/