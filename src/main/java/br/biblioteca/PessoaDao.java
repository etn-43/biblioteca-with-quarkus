package br.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaDao {
    private List<Pessoa> lista = new ArrayList<>();
    private int id = 0;

    PessoaDao(){
        Pessoa p = new Pessoa();
        p.setId(id);
        p.setNome("Joaquin");
        lista.add(p);
    }
    public List<Pessoa> obter() {
        return lista;
    }

    public Pessoa adicionar(Pessoa p) {
        id += 1;
        p.setId(id);
        lista.add(p);
        return p;
    }
}
