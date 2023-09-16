package br.biblioteca.client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;


@ApplicationScoped
public class LivroService implements LivroRestClient {
    @Inject
    LivroDao dao;

    @Override
    public List<Livro> obter() {
        return dao.obter();
    }
}
