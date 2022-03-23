/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1_slian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ania
 */
public class Lab1_slian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // testowanie klasy Pensjonariusz:
        Pensjonariusz p = new Pensjonariusz("Henryk", Pensjonariusz.typyTerapii.CW, 81);
        System.out.println(p.toString());
        Pensjonariusz.Otworz("dane.txt");
        Pensjonariusz[] pencjonariusze = Pensjonariusz.stworzTablicePensjonariuszy("dane.txt");
        
        
        // testowanie Grupowanie:

        Grupowanie.PobierzOsobyZdanejTerapii(Pensjonariusz.typyTerapii.CWNW, pencjonariusze);
        Grupowanie.SprawdzLiczebnoscGrupy(Pensjonariusz.typyTerapii.NW, pencjonariusze);

        // metody w mainie:
        Wyswietl(pencjonariusze);
        Wyswietl(getTypyPensjonariusze(pencjonariusze));
        
    }
    
    static public void Wyswietl(Pensjonariusz[] pencjonariusze) {
        for (Pensjonariusz pen : pencjonariusze) {
            System.out.println(pen.toString());
        }
    }
    
    static public void Wyswietl(String[] typyTerapii) {
        
        HashSet<String> hashset = new HashSet<>();
        for (int i = 0; i < typyTerapii.length; i++) {
            if(!(hashset.contains(typyTerapii[i]))) {
                hashset.add(typyTerapii[i]);
            }
        }
        
        System.out.print(hashset);   
    }
    
    public static String[] getTypyPensjonariusze(Pensjonariusz[] pen) {
        List<String> posrednia = new ArrayList<>();
        for (Pensjonariusz p: pen) {
            posrednia.add((p.getTypTerapii()).toString());
        }
        
        String[] typy = new String[posrednia.size()];
        typy = posrednia.toArray(typy);
        return typy;
    }
    
    
}
