package br.livros;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LivroDao {
    public List<Livro> lista = new ArrayList<>();

    public LivroDao(){
        Livro l = new Livro();
        l.setId(0);
        l.setTitulo("Codigos em javascript");
        l.setAno(2020);
        l.setDisponiveis(3);
        lista.add(l);
    }
    public List<Livro> obterLivros() {
        return lista;
    }

    public String atualizarLivro() {
        return "Livro não encontrado";
    }
}
