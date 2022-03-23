
package lab1_slian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Pensjonariusz {

    //dostępne typy terapii:
    public enum typyTerapii {
    CW, 
    K, 
    NW, 
    CWNW
    };
    
    // pola:
    private String imie;
    private typyTerapii typTerapii;
    private int wiek;

    // konstruktor:
    public Pensjonariusz(String imie, typyTerapii typTerapii, int wiek) {
        this.imie = imie;
        this.typTerapii = typTerapii;
        this.wiek = wiek;
    }
    
    //odczyt wartości pól:
    public typyTerapii getTypTerapii() {
        return typTerapii;
    }
    
    public String getImie() {
        return imie;
    }
    
    public int getWiek() {
        return wiek;
    }

    // przesłonięta metoda toString():
    @Override
    public String toString() {
        return this.imie + ", " + this.typTerapii.toString() + ", " + this.wiek;
    }

    // wczytanie danych z pliku .txt
    public static String Otworz( String sciezkaDoPliku) throws FileNotFoundException, IOException {
        String data = "";
        try {
            File myObj = new File(sciezkaDoPliku);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    //System.out.println(data);
                }}
         } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
         }
        return data;
    }
    
    
    
    public static Pensjonariusz[] stworzTablicePensjonariuszy(String nazwaPliku) throws IOException
    {
        String linia = Otworz(nazwaPliku);
        ArrayList<Pensjonariusz> pacjenciDoUtworzenia = new ArrayList<Pensjonariusz>();
        String nowaLinia = linia.replace('|', ',');
        String[] tablicaWiersze = nowaLinia.split(",");
        for (String t : tablicaWiersze){
            //System.out.println(t.toString());
            String[] tablicaKolumny = t.split(";");
            //System.out.println((getTypTerapiFromString(tablicaKolumny[4])).toString());
            Pensjonariusz p = new Pensjonariusz(tablicaKolumny[0], 
                    getTypTerapiFromString(tablicaKolumny[4]), 
                    Integer.parseInt( tablicaKolumny[6]));
            pacjenciDoUtworzenia.add(p); 
        }
        
        Pensjonariusz[] tablicaPensjonariuszy = new Pensjonariusz[pacjenciDoUtworzenia.size()];
        tablicaPensjonariuszy = pacjenciDoUtworzenia.toArray(tablicaPensjonariuszy);
        return tablicaPensjonariuszy;
        
    }
    
    
    public static typyTerapii getTypTerapiFromString( String typ){
        
        if (typ.equals("K")) {
            return typyTerapii.K;
        }
        else if(typ.equals("CW")) {
            return typyTerapii.CW;
        }
        else if(typ.equals("NW")) {
            return typyTerapii.NW;
        }
        else if(typ.equals("CW+NW")) {
            return typyTerapii.CWNW;
        }
        else {
            System.out.print("Brak typu w bazie, nadano domyślnie wartość CW");
            return typyTerapii.CW;
        }
        
        
    }


}
