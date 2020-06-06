/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fcane
 */
public class DataHelper {
    public static Date textoToDate(String texto) {
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            d = formatter.parse(texto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static String dateToTexto(Date date) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
