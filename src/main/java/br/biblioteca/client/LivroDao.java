package br.biblioteca.client;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LivroDao {
    private List<Livro> lista = new ArrayList<>();

    LivroDao(){
        Livro l = new Livro();
        l.setId(0);
        l.setTitulo("Codigos em java");
        l.setAno(2020);
        l.setDisponiveis(3);
        lista.add(l);
    }
    public List<Livro> obterLivros() {
        return lista;
    }


}
