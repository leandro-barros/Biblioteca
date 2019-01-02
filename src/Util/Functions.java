package Util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author Leandro Barros
 */
public class Functions {

    public static boolean isValidData(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static int diferencaDias(LocalDate dataInicial, LocalDate dataFinal) {
        return (int) DAYS.between(dataInicial, dataFinal);
    }

    public static boolean fimDeSemana(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

    public static boolean dataMenorQueHoje(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        LocalDate hoje = LocalDate.now();
        return dataVerificada.compareTo(hoje) <= 0;
    }

    public static boolean isEmpty(String text, boolean useTrim) {
        if (text == null) {
            return true;
        }
        if (useTrim) {
            text = text.trim();
        }
        if (text.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String text) {
        return Functions.isEmpty(text, true);
    }

    public static String spaceRemover(String text) {
        text = text.replaceAll("\\s+", " ");
        return text;
    }

    public static void soNumeros(java.awt.event.KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public static String dataString(LocalDate data) {
        String dataString = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dataString;
    }

}
