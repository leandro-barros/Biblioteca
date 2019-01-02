package Classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Leandro Barros
 */
public class Genero {

    public static ArrayList<Genero> listaGeneros = new ArrayList<>(
            Arrays.asList(
                    new Genero(1, "AÇÃO"),
                    new Genero(2, "ROMÂNCE"),
                    new Genero(3, "MATEMÁTICA"),
                    new Genero(4, "PORTUGUÊS"),
                    new Genero(5, "AVENTURA"),
                    new Genero(6, "EXATAS"),
                    new Genero(7, "DESENVOLVIMENTO")
            )
    );
    public static int incrementaCodigo = 8;

    private Integer codigo;
    private String nomeGenero;

    public Genero(Integer codigo, String nomeGenero) {
        this.codigo = codigo;
        this.nomeGenero = nomeGenero;
    }

    public Genero() {

    }

    public void cadastrar(Integer codigo, String nomeGenero) {
        setCodigo(codigo);
        setNomeGenero(nomeGenero);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

}
