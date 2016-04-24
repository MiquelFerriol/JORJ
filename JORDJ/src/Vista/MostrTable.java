/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.*;
import BaseDatos.BaseDatos;
import Estructuras.GlobalVariable;
import Estructuras.Regata;
import java.awt.Color;
import javax.swing.RowFilter;
import javax.swing.table.*;
import java.awt.Component;
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
import javax.swing.RowFilter;

/**
 *
 * @author Miquel Ferriol
 */
public class MostrTable extends JFrame{
    private Timer displayTimer;        
    private String [] titulos ={"Class","Group","Race", "Date", "Entries", "Area", "Committee", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "OCS", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges","Wind Dir.","Wind Speed","Visible","id"};
    private DefaultTableModel modelo;
    private BaseDatos BD;
    private String IP;
    
    public MostrTable(BaseDatos BD) {
        super("");
        this.BD = BD;
        setIconImage(new ImageIcon(getClass().getResource("../Vista/Imagenes/Imagen1.png")).getImage());
        
        DataTable();
        JTable table = new JTable(modelo){
          @Override
          protected JTableHeader createDefaultTableHeader() {
              return new GroupableTableHeader(columnModel);
          }
        };
        /*table.setAutoCreateRowSorter(true);
        TableRowSorter sorter = new TableRowSorter<>(modelo);
        table.setRowSorter(sorter);
        RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter("true",29);
        sorter.setRowFilter(rf);*/
        TableRenderer r = new TableRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        //add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );

        ActionListener listener = (ActionEvent event) -> {
            DataTable();
            //sorter.setRowFilter(rf);
            r.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, r);
            printTable();
            table.repaint();
            displayTimer.restart();
        };
        
        displayTimer = new Timer(500, listener);
        displayTimer.start();

        TableColumnAdjuster tca = new TableColumnAdjuster(table);
        tca.adjustColumns();

        table.setRowHeight(51);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD ,GlobalVariable.LETTER_SIZE-5));
        
        initHeader(table);
    
        add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        TableColumnModel tcm = table.getColumnModel();
        tcm.removeColumn(tcm.getColumn(29));
        tcm.removeColumn(tcm.getColumn(29));
        pack();
        setVisible(true);
    }
    
    public class TableRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        ////System.out.println("COLUMN: " + column);
        if(column == 8 || column == 13){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                if(s.equals("OTHER")){
                    s = "UNIFORM";
                }
                ImageIcon icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                JLabel lbl = new JLabel();
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setIcon(icon);
                return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                return lbl;
            }
        }
        else if(column == 7){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                switch (s) {
                    case "SCHEDULED":
                        s = "SCHEDULED";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "POSTPONDMENT":
                        s = "AP";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "ON SEQUENCE":
                        s = "ORANGE";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "FINISHED":
                        s = "BLUE";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "ABANDON":
                        s = "NOVEMBER";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "SAILING":
                        s = "SAILING";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "ON TIME":
                        s = "ONTIME";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    default:
                        lbl.setText(s);
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
                        break;
                }
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.CENTER);
                lbl.setIcon(icon);
                return lbl;
            }
            
            catch(Exception e){
                JLabel lbl = new JLabel();
                return lbl;
            }
        }
        else if(column == 22){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                switch (s) {
                    case "PUBLISHED":
                        s = "LIMA";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "RECEIVED":
                        s = "GREEN";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "REVIEWING":
                        s = "YELLOW";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "INCIDENCE":
                        s = "RED";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    default:
                        lbl.setText(s);
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
                        break;
                }
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.CENTER);
                lbl.setIcon(icon);
                return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                ////System.out.println(e.getMessage());
                return lbl;
            }
        }
        else if(column == 20){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                switch (s) {
                    case "FINISH CLOSED":
                        s = "FINISH CLOSED";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "N+A":
                        s = "N+A";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "AP+A":
                        s = "AP+A";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "LAST BOAT":
                        s = "BLUE";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "ONB PUBLICATION":
                        s = "LIMA";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    default:
                        lbl.setText(s);
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
                        break;
                }
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.CENTER);
                lbl.setIcon(icon);
                return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                ////System.out.println(e.getMessage());
                return lbl;
            }
        }
        else if(column == 26){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                switch (s) {
                    case "Starboard":
                        s = "G";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Port":
                        s = "R";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Increased":
                        s = "+";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Decreased":
                        s = "-";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Stb. Incr.":
                        s = "G+";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Prt. Incr.":
                        s = "R+";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Stb. Decr.":
                        s = "G-";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Prt. Decr.":
                        s = "R-";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    default:
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
                        break;
                }
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.CENTER);
                lbl.setIcon(icon);
                return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                ////System.out.println("COLUMN 28 " + e.getMessage());
                return lbl;
            }
        } 
        //
        else if(column == 1){
            try{
                int aux = 0;
                /*for(int i = 0; i <= row; ++i){
                    if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
                }*/
                ////System.out.println(row+aux);
                String s =  modelo.getValueAt(row+aux, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                switch (s) {
                    case "Yellow Q-series":
                        s = "Q+Y";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Blue Q-series":
                        s = "Q+B";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Red Q-series":
                        s = "Q+R";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Yellow F-series":
                        s = "F+Y";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Blue F-series":
                        s = "F+B";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        //"Yellow Q-series", "Blue Q-series","Red Q-series","Yellow F-series","Blue F-series","Red F-series","Gold","Silver","Bronze","Fleet","Medal Race"
                        break;
                    case "Red F-series":
                        s = "F+R";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Gold":
                        s = "GOLD";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Silver":
                        s = "SILVER";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Bronze":
                        s = "BRONZE";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Fleet":
                        s = "FLEET";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    case "Medal Race":
                        s = "MR";
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                        break;
                    default:
                        lbl.setText(s);
                        icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
                        break;
                }
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon(icon);
                lbl.setHorizontalTextPosition(JLabel.CENTER);
                lbl.setVerticalTextPosition(JLabel.CENTER);
                lbl.setIcon(icon);
                return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                ////System.out.println(e.getMessage());
                return lbl;
            }
        }
        
        else if (column == 5){
            int aux = 0;
            /*if(row == 2) //System.out.println((Integer)modelo.getValueAt(row, 30));
            for(int i = 0; i <=  row; ++i){
                if(!(boolean)modelo.getValueAt(i, 29)) ++aux;
            }*/
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,GlobalVariable.LETTER_SIZE));
            try{
                Color col;
                String s = modelo.getValueAt(row+aux, column).toString();
                col = GlobalVariable.COLOR.get(GlobalVariable.AREA.indexOf(s));
                if(row == 2)System.out.println("row " + (row+aux) + " color " + col + " area " + s);
                
                c.setBackground(col);
                return c;
            }
            catch(Exception e){
                return c;
            }
        }
        else {
            ////System.out.println("WTF ESTA PASSANT " + column);
            //Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //c = new JLabel();
            //c.
            JLabel lbl = new JLabel();
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setVerticalAlignment(JLabel.CENTER);
            lbl.setHorizontalTextPosition(JLabel.CENTER);
            lbl.setVerticalTextPosition(JLabel.CENTER);
            if(modelo.getValueAt(row, column) != null)lbl.setText(modelo.getValueAt(row, column).toString());
            lbl.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,GlobalVariable.LETTER_SIZE));
            lbl.setBackground(Color.white);
            return lbl;
        }
    } 
        
    }
    
    public class HeaderRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,GlobalVariable.LETTER_SIZE - 5));
            try{
                Color col;
                switch(column){
                    case 1:
                        col = Color.red;
                        break;
                    case 2:
                        col = Color.green;
                        break;
                    case 3:
                        col = Color.yellow;
                        break;
                    case 4:
                        col = Color.orange;
                        break;
                    case 5:
                        col = Color.cyan;
                        break;    
                    case 6:
                        col = Color.pink;
                        break;    
                    case 7:
                        col = Color.gray;
                        break;
                    default:
                        col = Color.WHITE;
                }
                c.setBackground(col);
                return c;
            }
            catch(Exception e){
                return c;
            }
        }       
    }    
    
    private void initHeader(JTable table){
        TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_StartsAbandoned = new ColumnGroup("Starts Abandoned");
        g_StartsAbandoned.add(cm.getColumn(15));
        g_StartsAbandoned.add(cm.getColumn(16));


        ColumnGroup g_Races = new ColumnGroup("RACES");
        g_Races.add(cm.getColumn(0));
        g_Races.add(cm.getColumn(1));
        g_Races.add(cm.getColumn(2));
        g_Races.add(cm.getColumn(3));
        g_Races.add(cm.getColumn(4));
        g_Races.add(cm.getColumn(5));
        g_Races.add(cm.getColumn(6));

        ColumnGroup g_AshoreSignal = new ColumnGroup("Ashore Signals");
        g_AshoreSignal.add(cm.getColumn(8));
        g_AshoreSignal.add(cm.getColumn(9));

        ColumnGroup g_Start = new ColumnGroup("START");
        g_Start.add(cm.getColumn(10));
        g_Start.add(cm.getColumn(11));
        g_Start.add(cm.getColumn(12));
        g_Start.add(cm.getColumn(13));
        g_Start.add(cm.getColumn(14));
        g_Start.add(g_AshoreSignal);
        g_Start.add(g_StartsAbandoned);

        ColumnGroup g_Finish = new ColumnGroup("FINISH");
        g_Finish.add(cm.getColumn(17));
        g_Finish.add(cm.getColumn(18));
        g_Finish.add(cm.getColumn(19));

        ColumnGroup g_DayEnd = new ColumnGroup("DAY END");
        g_DayEnd.add(cm.getColumn(20));
        g_DayEnd.add(cm.getColumn(21));
        g_DayEnd.add(cm.getColumn(22));

        ColumnGroup g_Course = new ColumnGroup("COURSE");
        g_Course.add(cm.getColumn(23));
        g_Course.add(cm.getColumn(24));
        g_Course.add(cm.getColumn(25));
        g_Course.add(cm.getColumn(26));
        g_Course.add(cm.getColumn(27));
        g_Course.add(cm.getColumn(28));

        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.addColumnGroup(g_Races);
        header.addColumnGroup(g_Start);
        header.addColumnGroup(g_AshoreSignal);
        header.addColumnGroup(g_Finish);
        header.addColumnGroup(g_DayEnd);
        header.addColumnGroup(g_Course);
        
        header.setFont(new Font("Arial", Font.BOLD ,GlobalVariable.LETTER_SIZE));
    }
    
    private void finishTime(int row, int column){
        //System.out.println("FINISH TIME");
        if((modelo.getValueAt(row, 13) != "") && (modelo.getValueAt(row, 19) != "") ){
            SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm:ss");
            try{
                    Date date1 = timerformat.parse(modelo.getValueAt(row, 13).toString());
                    //System.out.println("DATA: " + modelo.getValueAt(row, 19).toString());
                    Date date2 = timerformat.parse(modelo.getValueAt(row, 19).toString());
                    Date date = new Date();
                    long millis = date2.getTime()-date1.getTime();
                    String hms = String.format("%02d:%02d:%02d", 
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) -  
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
                    TimeUnit.MILLISECONDS.toSeconds(millis) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                    ////System.out.println(modelo.getValueAt(row, 19).toString());
                        modelo.setValueAt(hms, row, 20);
            } catch (Exception es) {
                //System.out.println(es.getMessage());
                es.printStackTrace();
            }
        }
    }
    
    private boolean correctValue(int c, String val){
        if(!val.equals("")){
            switch(c){               
                case 3:
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = formatter.parse(val);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case 9:
                case 10:
                case 21:
                    SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = timerformat.parse(val);
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                case 11:
                case 17:
                case 18:
                    SimpleDateFormat timerformat1 = new SimpleDateFormat("HH:mm:ss");
                        try {
                            timerformat1.parse(val).getTime();
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                default:
                return true;
            }
        }
        else return true;
    }
    
    
    private void printTable(){
        ////System.out.println("DATA");
        BD.initBD();
        int rem = 0;
        for(int i = 0; i < BD.getBD().size(); ++i ){
                Regata r = BD.getBD().get(i);
                if(r.isVisible()){
                    modelo.setValueAt(r.getClas(),i-rem,0);
                    modelo.setValueAt(r.getGroup(),i-rem,1);
                    modelo.setValueAt(r.getRace(),i-rem,2);
                    modelo.setValueAt(r.getScheduledDate(),i-rem,3);
                    modelo.setValueAt(r.getEntries(),i-rem,4);
                    modelo.setValueAt(r.getArea(),i-rem,5);
                    modelo.setValueAt(r.getCommittee(),i-rem,6);
                    modelo.setValueAt(r.getRaceStatus(),i-rem,7);
                    modelo.setValueAt(r.getSignal(),i-rem,8);
                    modelo.setValueAt(r.getTime(),i-rem,9);
                    modelo.setValueAt(r.getScheduledTime(),i-rem,10);
                    modelo.setValueAt(r.getStartingTime(),i-rem,11);
                    modelo.setValueAt(r.getBoatsStarted(),i-rem,12);
                    modelo.setValueAt(r.getPreparatorySignal(),i-rem,13);
                    modelo.setValueAt(r.getOCS_DSQ(),i-rem,14);
                    modelo.setValueAt(r.getAP(),i-rem,15);
                    modelo.setValueAt(r.getGR(),i-rem,16);
                    modelo.setValueAt(r.getFinishTime(),i-rem,17);
                    modelo.setValueAt(r.getRaceTime(),i-rem,18);
                    modelo.setValueAt(r.getBoatsFinished(),i-rem,19);
                    modelo.setValueAt(r.getLastSignal(), i-rem, 20);
                    modelo.setValueAt(r.getLastSignalTime(), i-rem, 21);
                    modelo.setValueAt(r.getResults(), i-rem, 22);
                    modelo.setValueAt(r.getCourse(),i-rem,23);
                    modelo.setValueAt(r.getDistance1stLeg(),i-rem,24);
                    modelo.setValueAt(r.getBearing1stLeg(),i-rem,25);
                    modelo.setValueAt(r.getLegChanges(),i-rem,26);
                    modelo.setValueAt(r.getWindDir(),i-rem,27);
                    modelo.setValueAt(r.getWindSpeed(),i-rem,28);
                    modelo.setValueAt(r.isVisible(),i-rem,29);
                    modelo.setValueAt(r.getId(),i-rem,30);
                }
                else{
                    //modelo.removeRow(BD.getBD().size()-1-rem);
                    ++rem;
                }
        }
        CheckGrid();
    }
    
    private void DataTable(){
        
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
            
            @Override
            public String getColumnName(int column) {
                String tittle = titulos[column];
                String ret = "<html>";
                for(int i = 0; i < tittle.length(); ++i){
                    char c = tittle.charAt(i);
                    if(c == ' ') ret+= "<br>";
                    else ret+= c;
                }
                System.out.println(ret);
                return ret;
            }

        };
        
        modelo.setDataVector(new Object[][]{}, titulos);
        String [] fila = new String[titulos.length];
        BD.initBD();
        int rem = 0;
        for(int i = 0; i < BD.getBD().size(); ++i ){
            Regata r = BD.getBD().get(i);
            if(!r.isVisible())++rem;
        }
        for(int i = 0; i < BD.getBD().size()-rem; ++i){
            ////System.out.println("FILA");
            modelo.addRow(fila);
        }
        printTable();
        
    }
    
    private void CheckGrid(){
        int rows = modelo.getRowCount();
        int col = modelo.getColumnCount();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                Object ob = modelo.getValueAt(i, j);
                if (ob  == null ) {
                    //if(j == 12 && i == 0) //System.out.println("BORRAMOS" + (ob  == null));
                }
                else if(ob.toString().equals("-1") || ob.toString().equals("-1.0") || ob.toString().isEmpty()) modelo.setValueAt("", i, j);
                
            }
        }
    }
}
