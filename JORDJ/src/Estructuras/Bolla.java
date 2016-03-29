/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Miquel Ferriol
 */
public class Bolla {
    private String Name;
    private char N_S;
    private String NDegree;
    private String NMinutes;
    private char E_W;
    private String EDegree;
    private String EMinutes;

    public Bolla(String s) {
        Name = "";
        NDegree= "";
        NMinutes= "";
        EDegree= "";
        EMinutes= "";
        int point = 0;
        int cont = 0;
        while(point < s.length()){
            if(s.charAt(point) != '-'){
                switch(cont){
                    case 0:
                        Name += s.charAt(point);
                        break;
                    case 1:
                        N_S = s.charAt(point);
                        break;
                    case 2:
                        NDegree += s.charAt(point);
                        break;
                    case 3:
                        NMinutes += s.charAt(point);
                        break;
                    case 4:
                        E_W = s.charAt(point);
                        break;
                    case 5:
                        EDegree += s.charAt(point);
                        break;
                    case 6:
                        EMinutes += s.charAt(point);
                        break;
                }
            }
            else{
                ++cont;
                //System.out.println("ENTRO");
            }
            ++point;
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getN_S() {
        return N_S;
    }

    public void setN_S(char N_S) {
        this.N_S = N_S;
    }

    public String getNDegree() {
        return NDegree;
    }

    public void setNDegree(String NDegree) {
        this.NDegree = NDegree;
    }

    public String getNMinutes() {
        return NMinutes;
    }

    public void setNMinutes(String NMinutes) {
        this.NMinutes = NMinutes;
    }

    public char getE_W() {
        return E_W;
    }

    public void setE_W(char E_W) {
        this.E_W = E_W;
    }

    public String getEDegree() {
        return EDegree;
    }

    public void setEDegree(String EDegree) {
        this.EDegree = EDegree;
    }

    public String getEMinutes() {
        return EMinutes;
    }

    public void setEMinutes(String EMinutes) {
        this.EMinutes = EMinutes;
    }
    
    
}
