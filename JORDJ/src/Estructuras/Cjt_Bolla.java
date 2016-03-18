/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import java.util.ArrayList;

/**
 *
 * @author Miquel Ferriol
 */
public class Cjt_Bolla {
    private ArrayList<Bolla> cjt_Bolla;

    public Cjt_Bolla() {
        cjt_Bolla = new ArrayList<>();
    }

    public Bolla getI(int i){
        return cjt_Bolla.get(i);
    }
    
    public void setI(int i, Bolla b){
        cjt_Bolla.set(i, b);
    }
    
    public void add(Bolla b){
        cjt_Bolla.add(b);
    }
    
    
}
