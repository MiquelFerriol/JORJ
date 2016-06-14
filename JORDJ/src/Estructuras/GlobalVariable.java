/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.*;
import BaseDatos.BaseDatos;
import Estructuras.Regata;
import Estructuras.*;
import java.awt.Color;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Font;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.swing.table.*;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;
import java.awt.Component;
import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;
import javax.swing.table.*;
import javax.swing.SwingUtilities;
/**
 *
 * @author Miquel Ferriol
 */
public final class GlobalVariable {
    
    public static int LETTER_SIZE = 13;
    public static int LETTER_SIZE_T = 10;
    public static String DATE = "all";
    
    public static ArrayList<String> CLASS = new ArrayList<String>(){{
        add("RI");
        add("OPIS");
        add("OPI1");
        add("OPI2");
        add("OPI3");
        add("J80");
        add("EUROPE");
        add("CATAS");
        add("29ER");
        add("RSX M");
        add("RSX W");
        add("LASER STD");
        add("LASER RAD");
        add("4-7");
        add("470 M");
        add("470 W");
        add("FINN");
        add("49ER");
        add("FX ONE");
        add("NACRA");
        add("420 M");
        add("420 W");
    }}; 
    
    public static ArrayList<String> GROUP = new ArrayList<String>(){{
        add("YellowQ");
        add("BlueQ");
        add("RedQ");
        add("YellowF");
        add("BlueF");
        add("RedF");
        add("Gold");
        add("Silver");
        add("Bronze");
        add("Fleet");
        add("MR");
    }};
    
    public static ArrayList<String> LABEL_GROUP_TEXT = new ArrayList<String>(){{
        add("Q");
        add("Q");
        add("Q");
        add("F");
        add("F");
        add("F");
        add("G");
        add("S");
        add("B");
        add("F");
        add("MR");
    }}; 
    
    public static ArrayList<Color> LABEL_GROUP_COLOR = new ArrayList<Color>(){{
        add(Color.YELLOW);
        add(Color.BLUE);
        add(Color.RED);
        add(Color.YELLOW);
        add(Color.BLUE);
        add(Color.RED);
        add(Color.YELLOW);
        add(Color.BLUE);
        add(Color.RED);
        add(Color.GREEN);
        add(Color.ORANGE);
    }}; 
    //new String[] {"Yellow Q-series", "Blue Q-series","Red Q-series","Yellow F-series","Blue F-series","Red F-series","Gold","Silver","Bronze","Fleet","Medal Race"}
    public static ArrayList<String> AREA = new ArrayList<String>(){{
        add("Päo Açucar");
        add("Escola Naval");
        add("Copacabana");
        add("Niteroi");
        add("Ponte");
        add("Aeroport");
        add("Pai");
        add("Ponte");
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
        add(Color.PINK);
        add(Color.YELLOW);
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
        add("GENERAL RECALL");
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
        add("UNIFORM");
    }}; 
    
    
    
    public static ArrayList<String> LAST_SIG = new ArrayList<String>(){{
        add("LAST BOAT"); //LAST
        add("FINISH CLOSED"); //CLOSED
        add("AP+A");
        add("N+A");
        add("ONB PUBLICATION"); //ONB
    }}; 
    //new String[] {"RECEIVED", "REVIEWING","PUBLISHED"}
    public static ArrayList<String> RESULTS = new ArrayList<String>(){{
        add("RECEIVED");    //R
        add("REVIEWING");   //?
        add("PUBLISHED");   //L
        add("INCIDENCE");
    }}; 
    
    public static ArrayList<String> CHANGES = new ArrayList<String>(){{
        add("Starboard");   //STB
        add("Port");        //PRT
        add("Increased");   //+
        add("Decreased");   //-
        add("Stb. Incr.");  //STB+
        add("Prt. Incr.");  //PRT+
        add("Stb. Decr.");  //STB-
        add("Prt. Decr.");  //STB-
    }};
}
