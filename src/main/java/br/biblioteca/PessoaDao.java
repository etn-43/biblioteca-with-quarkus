package br.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaDao {
    private List<Pessoa> lista = new ArrayList<>();

    PessoaDao(){
        Pessoa p = new Pessoa();
        p.setId(0);
        p.setNome("Joaquin");
        lista.add(p);
    }
    public List<Pessoa> obter() {
        return lista;
    }
}
