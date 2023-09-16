package br.biblioteca;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
public class PessoaResource {
    @Inject
    PessoaService service;

    @Inject
    EmprestimoService emprestimoService;

    @Path("/pessoas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> obterPessoas(){ return service.obterPessoas(); }

    @Path("/pessoa")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa adicionarPessoa(Pessoa p){ return service.adicionarPessoas(p); }

    @Path("/emprestimo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String realizarEmprestimo(Emprestimo e){
        return emprestimoService.emprestimoLivro(e);
    }

}
