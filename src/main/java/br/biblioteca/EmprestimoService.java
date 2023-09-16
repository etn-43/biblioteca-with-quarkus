package br.biblioteca;
import br.biblioteca.client.Livro;
import br.biblioteca.client.LivroRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class EmprestimoService {

    @Inject
    PessoaDao pessoaDao;

    @Inject
    @RestClient
    LivroRestClient livroRestClient;

    public  String emprestimoLivro(Emprestimo e){
        List<Livro> todosLivros = livroRestClient.obterLivros();
        for(Livro livro : todosLivros){
            if(livro.getTitulo().matches(e.getLivro())){
                if(Integer.parseInt(e.getQuantidadeEmprestada()) > livro.getDisponiveis()){
                    return "Quantidade do livro "+e.getLivro()+" esgotada, no momento possuimos somente "+livro.getDisponiveis();
                }
                if(validaPessoa(e.getPessoa(),e.getLivro())){
                    livro.setDisponiveis(livro.getDisponiveis()-Integer.parseInt(e.getQuantidadeEmprestada()));
                    return e.getLivro();
                }
                return "Pessoa "+e.getPessoa()+" não encontrada na base de dados";
            }
        }
        return "Livro não encontrado";
    }

    private boolean validaPessoa(String pessoa, String livroDaPessoa){
        List<Pessoa> pessoasCadastradas = pessoaDao.obterPessoas();
        for(Pessoa p : pessoasCadastradas){
            if(p.getNome().matches(pessoa)){
                p.getLivrosAlugados().add(livroDaPessoa);
                return true;
            }
        }
        return false;
    }
}
