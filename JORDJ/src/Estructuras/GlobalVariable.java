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
    
    public static int LETTER_SIZE = 13;
    
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
        add("Niteroi");
        add("Ponte");
        add("Aeroport");
        add("Alpha");
        add("Bravo");
        add("Charlie");
        add("Delta");
        add("Echo");
    }};
    
    public static ArrayList<Color> COLOR = new ArrayList<Color>(){{
        add(Color.RED);
        add(Color.GREEN);
        add(Color.ORANGE);
        add(Color.BLUE);
        add(Color.PINK);
        add(Color.GRAY);
        add(Color.RED);
        add(Color.GREEN);
        add(Color.ORANGE);
        add(Color.BLUE);
        add(Color.PINK);
    }};;
    
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
    
    public static ArrayList<String> RACE_STATUS = new ArrayList<String>(){{
        add("SCHEDULED");
        add("POSTPONDMENT");
        add("ON SEQUENCE");
        add("SAILING");
        add("FINISHED");
        add("ABANDON");
        add("ON TIME");
    }}; 
    
    public static ArrayList<String> SIGNAL = new ArrayList<String>(){{
        add("DELTA");
        add("AP");
        add("AP+A");
        add("N+A");
        add("LIMA");
    }}; 
    
    public static ArrayList<String> PREP_SIG = new ArrayList<String>(){{
        add("PAPA");
        add("INDIA - 30.1");
        add("ZULU - 30.2");
        add("BLACK - 30.3");
        add("OTHER");
    }}; 
    
    public static ArrayList<String> LAST_SIG = new ArrayList<String>(){{
        add("LAST BOAT");
        add("FINISH CLOSED");
        add("AP+A");
        add("N+A");
        add("ONB PUBLICATION");
    }}; 
    //new String[] {"RECEIVED", "REVIEWING","PUBLISHED"}
    public static ArrayList<String> RESULTS = new ArrayList<String>(){{
        add("RECEIVED");
        add("REVIEWING");
        add("PUBLISHED");
    }}; 
    
    public static ArrayList<String> CHANGES = new ArrayList<String>(){{
        add("Starboard");
        add("Port");
        add("Increased");
        add("Decreased");
        add("Stb. Incr.");
        add("Prt. Incr.");
        add("Stb. Decr.");
        add("Prt. Decr.");
    }};
}
