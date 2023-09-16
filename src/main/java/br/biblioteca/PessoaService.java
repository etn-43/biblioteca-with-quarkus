package br.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PessoaService {
    @Inject
    PessoaDao dao;
    public List<Pessoa> obterPessoas() {
        return dao.obterPessoas();
    }

    public Pessoa adicionarPessoas(Pessoa p) {
        return dao.adicionarPessoas(p);
    }
}
