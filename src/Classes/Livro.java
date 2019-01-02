package Classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro Barros
 */
public class Livro {

    public static ArrayList<Livro> listaLivros = new ArrayList<>(
            Arrays.asList(
                    new Livro(1, "JAVA WEB", Autor.listaAutores.get(1), "NOVATEC", Genero.listaGeneros.get(6), 1, 2009, 10, 10),
                    new Livro(2, "GUERRA E PAZ", Autor.listaAutores.get(0), "SARAIVA", Genero.listaGeneros.get(1), 1, 2017, 2, 2),
                    new Livro(3, "A MOTANHA MÁGICA", Autor.listaAutores.get(2), "ÁTICA", Genero.listaGeneros.get(4), 2, 2011, 8, 8),
                    new Livro(4, "USE A CABEÇA", Autor.listaAutores.get(4), "COSAC", Genero.listaGeneros.get(6), 2, 2014, 8, 8),
                    new Livro(5, "FOLHAS DE RELVA", Autor.listaAutores.get(3), "", Genero.listaGeneros.get(1), 2, 2008, 9, 9),
                    new Livro(6, "MATEMÁTICA APLICADA", Autor.listaAutores.get(2), "MODERNA", Genero.listaGeneros.get(2), 2, 2001, 12, 12),
                    new Livro(7, "O DIÁRIO PERDIDO", Autor.listaAutores.get(3), "SARAIVA", Genero.listaGeneros.get(3), 4, 2011, 7, 7),
                    new Livro(8, "VIDAS SECAS", Autor.listaAutores.get(4), "Novatec 7", Genero.listaGeneros.get(4), 2, 2011, 9, 9),
                    new Livro(9, "O PROTETOR", Autor.listaAutores.get(0), "Novatec 2", Genero.listaGeneros.get(0), 6, 2011, 12, 12),
                    new Livro(10, "FUNDAMENTOS DE FÍSICA", Autor.listaAutores.get(1), "ÁTICA", Genero.listaGeneros.get(5), 4, 2011, 13, 13),
                    new Livro(11, "NOVAS PALAVRAS", Autor.listaAutores.get(2), "AP CULTURAL", Genero.listaGeneros.get(3), 2, 2011, 15, 15)
            )
    );
    public static int incrementaCodigo = 12;

    private Integer codigo;
    private String titulo;
    private Autor autor;
    private String editora;
    private Genero genero;
    private Integer edicao;
    private Integer ano;
    private Integer quantidadeExemplares;
    private Integer quantidadeDisponivel;
    private Integer qtdEmprestimoPeriodo;

    public Livro(Integer codigo, String titulo, Autor autor, String editora, Genero genero, Integer edicao, Integer ano, Integer quantidadeExemplares, Integer quantidadeDisponivel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.edicao = edicao;
        this.ano = ano;
        this.quantidadeExemplares = quantidadeExemplares;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Livro() {

    }

    public void cadastrar(Integer codigo, String titulo, Autor autor, String editora, Integer edicao, Integer ano, Genero genero, Integer quantidade) {
        setCodigo(codigo);
        setTitulo(titulo);
        setAutor(autor);
        setEditora(editora);
        setEdicao(edicao);
        setAno(ano);
        setQuantidadeExemplares(quantidade);
        setQuantidadeDisponivel(quantidade);
        setGenero(genero);
    }

    public static Livro buscarLivro(Integer codigo) {
        for (Livro livro : listaLivros) {
            if (codigo == livro.getCodigo()) {
                return livro;
            }
        }
        return null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(Integer quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQtdEmprestimoPeriodo() {
        return qtdEmprestimoPeriodo;
    }

    public void setQtdEmprestimoPeriodo(Integer qtdEmprestimoPeriodo) {
        this.qtdEmprestimoPeriodo = qtdEmprestimoPeriodo;
    }

}
