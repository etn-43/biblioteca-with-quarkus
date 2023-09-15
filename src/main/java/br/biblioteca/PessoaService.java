package br.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PessoaService {
    @Inject
    PessoaDao dao;
    public List<Pessoa> obter() {
        return dao.obter();
    }

    public Pessoa adicionar(Pessoa p) {
        return dao.adicionar(p);
    }
}
