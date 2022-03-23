/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1_slian;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ania
 */
public class Grupowanie {
    
    public static int SprawdzLiczebnoscGrupy(Pensjonariusz.typyTerapii typTerapii, Pensjonariusz[] pencjonariusze){
        Pensjonariusz[] poddaniTerapii = PobierzOsobyZdanejTerapii(typTerapii, pencjonariusze);
        System.out.println("Poddani terapii: " + typTerapii.toString() + " -> " + poddaniTerapii.length);
        return poddaniTerapii.length;
    }
    
    public static Pensjonariusz[] PobierzOsobyZdanejTerapii(Pensjonariusz.typyTerapii typTerapii, Pensjonariusz[] pencjonariusze){
    
        List<Pensjonariusz> posrednia = new ArrayList<>();
        for (int i = 0; i < pencjonariusze.length; i++) {
            if ((typTerapii.toString()).equals((pencjonariusze[i].getTypTerapii()).toString())) {
                //System.out.println("Znaleznione: " + (pencjonariusze[i].getTypTerapii()).toString());
                Pensjonariusz p = new Pensjonariusz(
                        pencjonariusze[i].getImie(),
                        pencjonariusze[i].getTypTerapii(),
                        pencjonariusze[i].getWiek()  );
                posrednia.add(p);
                //System.out.println(p.toString());
            }
        }
        
        Pensjonariusz[] poddaniTerapii = new Pensjonariusz[posrednia.size()];
        poddaniTerapii = posrednia.toArray(poddaniTerapii);
        
        return poddaniTerapii;
    }
    
}
