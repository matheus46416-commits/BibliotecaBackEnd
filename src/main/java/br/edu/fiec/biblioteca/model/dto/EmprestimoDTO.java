package br.edu.fiec.biblioteca.model.dto;

import br.edu.fiec.biblioteca.model.entity.ClienteEntity;
import br.edu.fiec.biblioteca.model.entity.FuncionarioEntity;
import br.edu.fiec.biblioteca.model.entity.LivroEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoDTO {

    private String Situacao;
    private Integer dataEmprestimo;
    private Integer dataDevolucao;
    private ClienteEntity cliente;
    private LivroEntity livro;
    private FuncionarioEntity funcionario;

}
