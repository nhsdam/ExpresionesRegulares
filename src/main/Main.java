package main;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    String texto;

    public static void leerFichero(){
        File file = null;
        Scanner sc = null;
        try {
            file = new File("archivo.txt");
            sc = new Scanner(file);

            while(sc.hasNextLine()){
                validadorCorreo(sc.nextLine());
            }

        } catch (FileNotFoundException exc) {
            System.err.println("1"+exc.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }

        }
    }

    public static void main(String[] args) {
        leerFichero();
    }

    public static void validadorCorreo(String ma){
        // Expresión regular para comprobar Correos Electronicos
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // Clase para comprobar
        Matcher m = patron.matcher(ma);

        // Devuelve un Booleano / True si coincide y False si no coincide.
        if(m.matches()){
            System.out.println(ma);
        }
    }
}
