package com.cadastro.cadastroBack.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    private Boolean ativo = true;



    public void atualizarCadastro(CadastroAtualizacao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.sobrenome() != null) {
            this.sobrenome = dados.sobrenome();
        }
    }
    
    
    public void excluirLogicamente() {
        this.ativo = false;
    }

}
