package Classes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro Barros
 */
public class Emprestimo {

    public static ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>(
            Arrays.asList(
                    new Emprestimo(1, Aluno.listaAlunos.get(8), Livro.listaLivros.get(3), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(2, Aluno.listaAlunos.get(2), Livro.listaLivros.get(4), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(3, Aluno.listaAlunos.get(4), Livro.listaLivros.get(2), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(4, Aluno.listaAlunos.get(2), Livro.listaLivros.get(3), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(5, Aluno.listaAlunos.get(0), Livro.listaLivros.get(9), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(6, Aluno.listaAlunos.get(1), Livro.listaLivros.get(5), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(7, Aluno.listaAlunos.get(3), Livro.listaLivros.get(6), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(8, Aluno.listaAlunos.get(6), Livro.listaLivros.get(7), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(9, Aluno.listaAlunos.get(5), Livro.listaLivros.get(3), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(10, Aluno.listaAlunos.get(7), Livro.listaLivros.get(6), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(11, Aluno.listaAlunos.get(10), Livro.listaLivros.get(10), LocalDate.of(2018, Month.OCTOBER, 18), LocalDate.of(2018, Month.OCTOBER, 25), "DEVOLVIDO", LocalDate.of(2018, Month.OCTOBER, 25), 0),
                    new Emprestimo(12, Aluno.listaAlunos.get(8), Livro.listaLivros.get(0), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(13, Aluno.listaAlunos.get(8), Livro.listaLivros.get(4), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(14, Aluno.listaAlunos.get(2), Livro.listaLivros.get(1), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(15, Aluno.listaAlunos.get(4), Livro.listaLivros.get(6), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(16, Aluno.listaAlunos.get(6), Livro.listaLivros.get(10), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(17, Aluno.listaAlunos.get(10), Livro.listaLivros.get(3), LocalDate.of(2018, Month.OCTOBER, 26), LocalDate.of(2018, Month.NOVEMBER, 02), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 02), 0),
                    new Emprestimo(18, Aluno.listaAlunos.get(8), Livro.listaLivros.get(1), LocalDate.of(2018, Month.OCTOBER, 31), LocalDate.of(2018, Month.NOVEMBER, 07), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 07), 0),
                    new Emprestimo(19, Aluno.listaAlunos.get(2), Livro.listaLivros.get(3), LocalDate.of(2018, Month.OCTOBER, 31), LocalDate.of(2018, Month.NOVEMBER, 07), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 07), 0),
                    new Emprestimo(20, Aluno.listaAlunos.get(6), Livro.listaLivros.get(10), LocalDate.of(2018, Month.OCTOBER, 31), LocalDate.of(2018, Month.NOVEMBER, 07), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 07), 0),
                    new Emprestimo(21, Aluno.listaAlunos.get(8), Livro.listaLivros.get(6), LocalDate.of(2018, Month.OCTOBER, 31), LocalDate.of(2018, Month.NOVEMBER, 07), "DEVOLVIDO", LocalDate.of(2018, Month.NOVEMBER, 07), 0)
            )
    );
    public static int incrementaCodigo = 22;

    private Integer codigo;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevisaoDevolucao;
    private String situacao;
    private LocalDate dataDevolucao;
    private Integer quantidadeRenovacao;

    public Emprestimo(Integer codigo, Aluno aluno, Livro livro, LocalDate dataEmprestimo, LocalDate dataPrevisaoDevolucao, String situacao, LocalDate dataDevolucao, Integer quantidadeRenovacao) {
        this.codigo = codigo;
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
        this.situacao = situacao;
        this.dataDevolucao = dataDevolucao;
        this.quantidadeRenovacao = quantidadeRenovacao;
    }

    public Emprestimo() {

    }

    public void cadastrar(Integer codigo, Livro livro, Aluno aluno, LocalDate dataEmprestimo, LocalDate dataPrevisaoDevolucao, String situacao) {
        setCodigo(codigo);
        setLivro(livro);
        setAluno(aluno);
        setDataEmprestimo(dataEmprestimo);
        setDataPrevisaoDevolucao(dataPrevisaoDevolucao);
        setSituacao(situacao);
        setDataDevolucao(getDataDevolucao());
        setQuantidadeRenovacao(0);
    }

    public static Emprestimo emprestimoLivroPeriodo(Livro livro, LocalDate dataInicial, LocalDate dataFinal) {
        Emprestimo emprestimoPeriodo = null;
        livro.setQtdEmprestimoPeriodo(0);
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getLivro().getCodigo() == livro.getCodigo()) {
                if (emprestimo.getDataEmprestimo().isAfter(dataInicial) && emprestimo.getDataEmprestimo().isBefore(dataFinal)) {
                    livro.setQtdEmprestimoPeriodo(livro.getQtdEmprestimoPeriodo() + 1);
                    if (emprestimoPeriodo == null) {
                        emprestimoPeriodo = emprestimo;
                    }
                }
            }
        }
        return emprestimoPeriodo;
    }

    public static int getIncrementaCodigo() {
        return incrementaCodigo;
    }

    public static void setIncrementaCodigo(int incrementaCodigo) {
        Emprestimo.incrementaCodigo = incrementaCodigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevisaoDevolucao() {
        return dataPrevisaoDevolucao;
    }

    public void setDataPrevisaoDevolucao(LocalDate dataPrevisaoDevolucao) {
        this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getQuantidadeRenovacao() {
        return quantidadeRenovacao;
    }

    public void setQuantidadeRenovacao(Integer quantidadeRenovacao) {
        this.quantidadeRenovacao = quantidadeRenovacao;
    }

}
