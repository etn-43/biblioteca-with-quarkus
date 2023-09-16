package br.biblioteca;
import br.biblioteca.client.LivroDto;
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
        List<LivroDto> todosLivros = livroRestClient.obterLivros();
        for(LivroDto livro : todosLivros){
            if(livro.getTitulo().matches(e.getLivro())){
                if(Integer.parseInt(e.getQuantidadeEmprestada()) > livro.getDisponiveis()){
                    return "Quantidade do livro "+e.getLivro()+" esgotada, no momento possuimos somente "+livro.getDisponiveis();
                }
                if(validaPessoa(e.getPessoa(),e.getLivro())){
                    int quantidadeDisponivel = livro.getDisponiveis();
                    quantidadeDisponivel -= Integer.parseInt(e.getQuantidadeEmprestada());
                    livro.setDisponiveis(quantidadeDisponivel);
                    livroRestClient.atualizarLivro(livro);
                    return e.getLivro()+" foi alugado e restam "+livro.getDisponiveis();
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
                return true;
            }
        }
        return false;
    }
}
