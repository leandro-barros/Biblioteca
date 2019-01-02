package Classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro Barros
 */
public class Autor {

    public static ArrayList<Autor> listaAutores = new ArrayList<>(
            Arrays.asList(
                    new Autor(1, "GUIMARÃES ROSA"),
                    new Autor(2, "LEANDRO BARROS"),
                    new Autor(3, "AUGUSTO"),
                    new Autor(4, "PAULO VILELA"),
                    new Autor(5, "FÁBIO SOUZA")
            )
    );

    public static int incrementaCodigo = 6;

    private Integer codigo;
    private String nomeAutor;

    public Autor(Integer codigo, String nomeAutor) {
        this.codigo = codigo;
        this.nomeAutor = nomeAutor;
    }

    public Autor() {

    }

    public void cadastrar(Integer codigo, String nomeAutor) {
        setCodigo(codigo);
        setNomeAutor(nomeAutor);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

}
