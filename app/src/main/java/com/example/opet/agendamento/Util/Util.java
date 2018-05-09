package com.example.opet.agendamento.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by opet on 09/05/2018.
 */

public class Util {

        public static Date toDate (String data) throws ParseException {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        }

        public static String toString (Date data) {
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        }
}
