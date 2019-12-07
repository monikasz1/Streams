package sda.mszymanowicz;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
//        Używając klas strumieni IO
//        1.W pętli wczytywać kolejne linie tekstu dopóki użytkownik nie wpisze „exit”
//        2.Program obliczający pierwiastki równania kwadratowego
//          •Użytkownik podaje współczynniki z klawiatury
//          •Wynik wyświetlany jest na ekranie


///         to jest sprawdzenie kodu ASKI jakiegoś znaku przez try/catch - warto zachować, bo czesto przydaje się
       /*try {
            char c = (char) System.in.read();
            System.out.println("Wpisany znak to: " + c);
            System.out.println("Jego kod ASCII to: " + (byte) c);
        } catch (IOException e) {
            System.out.println("Nie udało sie odczytać z klawiatury");
        }
/// wczytywanie pojedyńczej linii tekstu
       /* InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String linia = br.readLine();
            System.out.print("Wczytana linia tekstu to: ");
            System.out.println(linia);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        1.W pętli wczytywać kolejne linie tekstu dopóki użytkownik nie wpisze „exit”
//        zakomentowane dwie linie kodu bo pojawiły sie wyżej
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);

       /* String line = "";
        while (!"exit".equals(line)) {
            try {
                System.out.println("Wpisz linię tekstu: ");
                line = br.readLine();
                System.out.println("Wczytano: " + line);
            }catch (IOException e){
                e.printStackTrace();
            }
        }


//           2.Program obliczający pierwiastki równania kwadratowego
//          •Użytkownik podaje współczynniki z klawiatury
//          •Wynik wyświetlany jest na ekranie
        //wczytać współczynniki abc

        double A = 0;
        double B = 0;
        double C = 0;
        String a;
        String b;
        String c;
        boolean isOK = false; //zmienna która będzie sprawdzać czy poprawnie jest wpisane

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj współczynniki Równania kwadratowego (Ax^2 + Bx + C = 0)");
//całość wrzucić w pętlę while // to jest dość częsty schemat, z whilem i isOK

        while (!isOK) {

            try {
                isOK = true;

                System.out.print("A = ");
                a = br.readLine();
                System.out.print("B = ");
                b = br.readLine();
                System.out.print("C = ");
                c = br.readLine();   //ta linia będzie stringiem, dlatego musimy wcześniej zdefiniować stringa
                                    //                A = 5
                                    //                B = 8
                                    //                C = 21

                //łańcuch znakowy i robimy z tego obiekt - to jest parsowanie
                A = Double.parseDouble(a);
                B = Double.parseDouble(b);
                C = Double.parseDouble(c);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ex) {
                System.out.println("Wpisałeś coś co nie jest liczbą");
                isOK = false;
                System.out.println("Spróbuj jeszcze raz");
            }
        }


        double delta = B * B - 4 * A * C;
        System.out.println(delta);

        //if-a jeśli wynik to będzie liczba ujemna
        if (delta < 0) {
            System.out.println("Brak pierwiastków rzeczywistych");
        } else if (delta == 0) {
            double x = -B/(2*A);
            System.out.println("Jeden pierwiastek rzeczywisty: x = " + x );
        } else {
            double x1 = (-B - Math.sqrt(delta))/ (2*A);
            double x2 = (-B - Math.sqrt(delta))/ (2*A);
            System.out.println("Dwa pierwiastki : X1 = " + x1 +", X2 = " + x2);
        }


        // wyllistowanie katalogu

        File katalog = new File("c:/");
        String[] zawartosc = katalog.list();
        for (int i = 0; i < zawartosc.length; i++) {
            System.out.println(zawartosc[i]);
        }

        // wczytujemy pliki z katalogu zaczynające się od litery wskazanej przez uzytkownika. mozna to zrobić za pomoca klasy anonimowej
//obiekt klasy fileNameFilter

        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String letter = "";
        try {
            letter = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String finalLetter = letter;
        FilenameFilter fnf = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //taki schemat będzie zawsze obowiązywał przy listowaniu, tworzymy wzorzec string --> później obiekt wzorca pattern --> później obiekt wzorca  matcher

                String pat = finalLetter + ".*";
                Pattern patern = Pattern.compile(pat);
                Matcher matcher = patern.matcher(name);  // jeśli jakaś nazwa bedzie pasowała do wzoraca, to zwrói true
                return  matcher.matches();
            }
        };  //tu jest średnik bo to jest klasa anonimowa
//obiekt fnf musimy zastosować do wylistowania

        File katalog = new File("c:/");
        String [] zawartosc = katalog.list(fnf);     //TU W ARGUMENCIE PODAJEMY FNF
        for (int i = 0; i < zawartosc.length; i++) {
            System.out.println(zawartosc[i]);
        }

    }
}