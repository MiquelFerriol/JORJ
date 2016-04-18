/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author Miquel Ferriol
 */
public final class GlobalVariable {
    public static ArrayList<String> CLASS = new ArrayList<String>(){{
        add("RS:X M");
        add("RS:X W");
        add("LASER STD");
        add("LASER RAD");
        add("470 M");
        add("470 W");
        add("FINN");
        add("49ER");
        add("FX ONE");
        add("NACRA");
    }}; 
    
    public static ArrayList<String> GROUP = new ArrayList<String>(){{
        add("Yellow Q-series");
        add("Blue Q-series");
        add("Red Q-series");
        add("Yellow F-series");
        add("Blue F-series");
        add("Red F-series");
        add("Gold");
        add("Silver");
        add("Bronze");
        add("Fleet");
        add("Medal Race");
    }}; 
    //new String[] {"Yellow Q-series", "Blue Q-series","Red Q-series","Yellow F-series","Blue F-series","Red F-series","Gold","Silver","Bronze","Fleet","Medal Race"}
    public static ArrayList<String> AREA = new ArrayList<String>(){{
        add("Päo Açucar");
        add("Escola Naval");
        add("Copacabana");
        add("Pai");
        add("Aeroport");
        add("Alpha");
        add("Bravo");
        add("Charlie");
        add("Delta");
        add("Echo");
        add("Bravo");
    }};
    
    public static ArrayList<Color> COLOR;
    
    //new String[] {"RS:X M", "RS:X W","LASER STD","LASER RAD", "470 M", "470 W","FINN","49ER","FX ONE","NACRA"}
    public static ArrayList<String> COMMITEE = new ArrayList<String>(){{
        add("Christoph");
        add("Maria");
        add("Stogg");
        add("Luiggi");
        add("Sulis");
        add("John");
        add("Other");
    }}; 


    
}
