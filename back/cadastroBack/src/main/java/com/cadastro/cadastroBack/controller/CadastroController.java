package com.cadastro.cadastroBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastroBack.model.Cadastro;
import com.cadastro.cadastroBack.model.CadastroAtualizacao;
import com.cadastro.cadastroBack.model.CadastroRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    //------------------------------------- I N J E Ç Ã O ---------------------------------------------//
    
    @Autowired
    private CadastroRepository cadastroRepository;


    //---------------------------------------- C R U D ------------------------------------------------//

    @PostMapping
    @Transactional
    public Cadastro criarCadastro(@RequestBody Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @GetMapping
    public List<Cadastro> listarCadastros() {
        return cadastroRepository.findAll();
    }

    // @Transactional -----> As alterações só serão salvas se tudo der certo, Se algo der erro no meio do caminho, ele dá rollback automaticamente (SEMPRE USAR!) //
    
    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody CadastroAtualizacao dados) {
        var cadastro = cadastroRepository.getReferenceById(id);
        cadastro.atualizarCadastro(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        var cadastro = cadastroRepository.getReferenceById(id);
        cadastro.excluirLogicamente();
    }

    //---------------------------------------- C R U D ------------------------------------------------//


}
