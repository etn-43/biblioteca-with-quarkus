package br.biblioteca;
import br.biblioteca.client.LivroRestClient;
import br.biblioteca.client.LivroService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class EmprestimoService {

    @Inject
    @RestClient
    LivroRestClient livroRestClient;

    
}
