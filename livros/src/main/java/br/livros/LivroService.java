package br.livros;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;


@ApplicationScoped
public class LivroService {
    @Inject
    LivroDao dao;


    public List<Livro> obterLivros() {
        return dao.obterLivros();
    }

    public String atualizarLivro(Livro l) {
        for (Livro livro : dao.lista){
            if(livro.getId() == l.getId()){
                livro.setDisponiveis(l.getDisponiveis());
                livro.setTitulo(l.getTitulo());
                livro.setAno(l.getAno());
                return livro.getTitulo()+" atualizado com sucesso";
            }
        }
        return dao.atualizarLivro();
    }
}
