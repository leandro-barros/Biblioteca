package Classes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro Barros
 */
public class Aluno {

    public static ArrayList<Aluno> listaAlunos = new ArrayList<>(
            Arrays.asList(
                    new Aluno(1, "LEANDRO", "13495693402", "12345", "leobaros@gmail.com", "1234525", LocalDate.of(1998, Month.MARCH, 02), "", 0, 0, 1, 0),
                    new Aluno(2, "DANILO", "1349598665", "20905", "danilo@gmail.com", "998734552", LocalDate.of(1987, Month.AUGUST, 03), "", 0, 0, 1, 0),
                    new Aluno(3, "TATIANE", "09895986076", "97734", "tatiane@gmail.com", "389734552", LocalDate.of(1992, Month.DECEMBER, 23), "", 0, 0, 4, 0),
                    new Aluno(4, "MYLLENE", "02346712483", "78734", "myllene@gmail.com", "3899342354", LocalDate.of(1991, Month.JULY, 12), "", 0, 0, 1, 0),
                    new Aluno(5, "FABIO", "12387593402", "09233", "fabio@gmail.com", "3487653412", LocalDate.of(1993, Month.MAY, 14), "", 0, 0, 2, 0),
                    new Aluno(6, "RAQUEL", "09823412343", "98423", "raquel@gmail.com", "3198743625", LocalDate.of(1991, Month.NOVEMBER, 22), "", 0, 0, 1, 0),
                    new Aluno(7, "ANA", "09834672834", "98323", "ana@gmail.com", "3286348212", LocalDate.of(1994, Month.OCTOBER, 05), "", 0, 0, 3, 0),
                    new Aluno(8, "TALITA", "12493456234", "12398", "talita@gmail.com", "3897345612", LocalDate.of(1994, Month.JANUARY, 03), "", 0, 0, 1, 0),
                    new Aluno(9, "FERNANDA", "15487523409", "95623", "fernanda@gmail.com", "3896543526", LocalDate.of(1997, Month.NOVEMBER, 21), "", 0, 0, 5, 0),
                    new Aluno(10, "JUNIOR", "15498734576", "12338", "junior@gmail.com", "389234532", LocalDate.of(1997, Month.MAY, 18), "", 0, 0, 1, 0),
                    new Aluno(11, "LUCAS", "1338763457", "34627", "lucas@gmail.com", "3896543726", LocalDate.of(1998, Month.MARCH, 19), "", 0, 0, 2, 0)
            )
    );
    public static int incrementaCodigo = 12;

    private Integer codigo;
    private String nome;
    private String cpf;
    private String matricula;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String situacao;
    private Integer quantidadeLivro;
    private Integer quantidadeDiasMultado;
    private Integer quantidadeDiasMultadoRestante;
    private Integer quantidadeEmprestimo;
    private LocalDate dataMulta;

    public Aluno(Integer codigo, String nome, String cpf, String matricula, String email, String telefone, LocalDate dataNascimento, String situacao, Integer quantidadeLivro, Integer quantidadeDiasMultado, Integer quantidadeEmprestimo, Integer quantidadeDiasMultadoRestante) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.situacao = situacao;
        this.quantidadeLivro = quantidadeLivro;
        this.quantidadeDiasMultado = quantidadeDiasMultado;
        this.quantidadeEmprestimo = quantidadeEmprestimo;
        this.quantidadeDiasMultadoRestante = quantidadeEmprestimo;

    }

    public Aluno() {

    }

    public void cadastrar(Integer codigo, String nome, String cpf, String matricula, String email, String telefone, LocalDate dataNascimento) {
        setCodigo(codigo);
        setNome(nome);
        setCpf(cpf);
        setMatricula(matricula);
        setEmail(email);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);
        setQuantidadeLivro(0);
        setQuantidadeDiasMultado(0);
        setQuantidadeEmprestimo(0);
        setSituacao("");
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getQuantidadeLivro() {
        return quantidadeLivro;
    }

    public void setQuantidadeLivro(Integer quantidadeLivro) {
        this.quantidadeLivro = quantidadeLivro;
    }

    public Integer getQuantidadeDiasMultado() {
        return quantidadeDiasMultado;
    }

    public void setQuantidadeDiasMultado(Integer quantidadeDiasMultado) {
        this.quantidadeDiasMultado = quantidadeDiasMultado;
    }

    public Integer getQuantidadeEmprestimo() {
        return quantidadeEmprestimo;
    }

    public void setQuantidadeEmprestimo(Integer quantidadeEmprestimo) {
        this.quantidadeEmprestimo = quantidadeEmprestimo;
    }

    public void setQuantidadeDiasMultadoRestante(Integer quantidadeDiasMultadoRestante) {
        this.quantidadeDiasMultadoRestante = quantidadeDiasMultadoRestante;
    }

    public Integer getQuantidadeDiasMultadoRestante() {
        return quantidadeDiasMultadoRestante;
    }

    public LocalDate getDataMulta() {
        return dataMulta;
    }

    public void setDataMulta(LocalDate dataMulta) {
        this.dataMulta = dataMulta;
    }

}
