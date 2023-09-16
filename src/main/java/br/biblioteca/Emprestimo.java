package br.biblioteca;

public class Emprestimo {
    private String pessoa;
    private String livro;

    public String getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public void setQuantidadeEmprestada(String quantidadeEmprestada) {
        this.quantidadeEmprestada = quantidadeEmprestada;
    }

    private String quantidadeEmprestada;



    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}
