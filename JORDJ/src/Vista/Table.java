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
import Estructuras.Regata;
import java.awt.Color;
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
import javax.swing.SwingUtilities;

/**
 *
 * @author Miquel Ferriol
 */


public final class Table extends JFrame{
    
    private Timer displayTimer;        
    private String[] COLUMNA = {"id", "Class","Grp", "Race", "ScheduledDate", "RealDate", "Entries", "Area", "Committee", "RaceStatus", "Signall", "Time","ScheduledTime", "StartingTime", "BoatsStarted", "PreparatorySignal", "OCS_DSQ", "AP", "GR", "FinishTime", "RaceTime" ,  "BoatsFinished", "LastSignal", "LastSignalTime", "Results", "Course", "Distance1stLeg", "Bearing1stLeg", "LegChanges", "WindDir", "WindSpeed","WindDir25", "WindSpeed25","WindDir50", "WindSpeed50","WindDir75", "WindSpeed75","WindDir100", "WindSpeed100"};
    private String [] titulos ={"Id", "Class", "Group","Race",  "Scheduled Date", "Real Date", "Entries", "Area", "Committee", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "Nr.OCS/DSQ", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges", "Wind Dir.", "WindSpeed","Wind Dir. 25%", "WindSpeed 25%","Wind Dir. 50%", "WindSpeed 50%","Wind Dir. 75%", "WindSpeed 75%","Wind Dir. 100%", "WindSpeed 100%"};
    private DefaultTableModel modelo;
    private BaseDatos BD;
    
    public class TableRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        //System.out.println("COLUMN: " + column);
        if(column == 10 || column == 15){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
        else if(column == 9){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
        else if(column == 24){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
                //System.out.println(e.getMessage());
                return lbl;
            }
        }
        else if(column == 22){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
                //System.out.println(e.getMessage());
                return lbl;
            }
        }
        else if(column == 28){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
                System.out.println(e.getMessage());
                return lbl;
            }
        } 
        //
        else if(column == 2){
            try{
                String s =  modelo.getValueAt(row, column).toString();
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
                //System.out.println(e.getMessage());
                return lbl;
            }
        }
        
        else if (column == 7){
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,15));
            try{
                Color col;
                String s = modelo.getValueAt(row, column).toString();
                switch(s){
                    case "Päo Açucar":
                        col = Color.red;
                        break;
                    case "Escola Naval":
                        col = Color.green;
                        break;
                    case "Ponte":
                        col = Color.yellow;
                        break;
                    case "Copacabana":
                        col = Color.orange;
                        break;
                    case "Niteroi":
                        col = Color.cyan;
                        break;    
                    case "Pai":
                        col = Color.pink;
                        break;    
                    case "Aeroport":
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
        /*else if(column == 28){
            //System.out.println("KAPPA");
            try{
                
            int g = Integer.parseInt(modelo.getValueAt(row, 29).toString());
            System.out.println("Graus: " + g );
            int s = Integer.parseInt(modelo.getValueAt(row, 30).toString());
            JLabel lbl = new JLabel();
            ImageIcon icon = new ImageIcon(getClass().getResource("Imagenes/Viento/0.png"));
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            int type = BufferedImage.TYPE_INT_RGB;  // other options, see api
            BufferedImage image = new BufferedImage(h, w, type);
            Graphics2D g2 = image.createGraphics();
            g2.rotate(Math.toRadians(90+g), w/2.0, h/2.0);
            g2.drawImage(icon.getImage(), 0,0,Color.WHITE, lbl);
            
            g2.dispose();
            icon = new ImageIcon(image);
            lbl.setIcon(icon);
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setVerticalAlignment(JLabel.CENTER);
            return lbl;
            }
            catch(Exception e){
                JLabel lbl = new JLabel();
                return lbl;
            }
        }*/
        
        else {
            //System.out.println("WTF ESTA PASSANT " + column);
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,15));
            c.setBackground(Color.white);
            return c;
        }
    } 
        
    }
    
    public class HeaderRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,15));
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
    
    public Table() {
        super("");
        DataTable();
        JTable table = new JTable(modelo){
          @Override
          protected JTableHeader createDefaultTableHeader() {
              return new GroupableTableHeader(columnModel);
          }
        };
        TableRenderer r = new TableRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);

        //add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );

        ActionListener listener = (ActionEvent event) -> {
            printTable();
            displayTimer.restart();
        };

        table.getDefaultEditor(String.class).addCellEditorListener(
            new CellEditorListener() {
                @Override
                public void editingCanceled(ChangeEvent e) {
                    //System.out.println("editingCanceled");
                }

                @Override
                public void editingStopped(ChangeEvent e) {
                    
                    System.out.println("editingStopped: apply additional action");
                    //System.out.println(table.getSelectedColumn());
                    int column = table.getSelectedColumn();
                    int row = table.getSelectedRow();
                    lastCol = column;
                    lastRow = row;
                    if(row != -1 && column != -1){
                        Object data = modelo.getValueAt(row, column);

                        if(correctValue(column, data.toString())){
                                BD.Update(row+1, COLUMNA[column], data);
                            }
                        else if (!"".equals(data.toString())){
                            modelo.setValueAt("", row, column);
                        }

                        if(column == 13 || column == 19){
                                finishTime(row,column);
                        }
                    }
                }
            }
        );
        
        displayTimer = new Timer(4000, listener);
        displayTimer.start();

        TableColumnAdjuster tca = new TableColumnAdjuster(table);
        tca.adjustColumns();

        table.setRowHeight(51);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD ,15));
        
        initDesplegable(table);
        initHeader(table);
    
        add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        pack();
        setVisible(true);
    }
    
    public class Desplegable extends JComboBox{
        int col;
        public Desplegable(int col, String[] DATA){
            super(DATA);
            super.setEditable(true);
            this.col = col;
            setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,15));
            setBackground(Color.white);
        }
        
        public int getCol(){
            return col;
        }
    }
    
    public void itemStateChanged(ItemEvent e, Desplegable d, int r, int c) {
        if ((e.getStateChange() == ItemEvent.SELECTED)) {
            int selection = d.getSelectedIndex();
                System.out.println("CAMBIADO");
            
        }
    }
    int lRow;
    boolean cont = false;
    int lastCol = -1;
    int lastRow = -1;
    
    private void initDesplegable(JTable table){
        Desplegable dClass = new Desplegable(1,new String[] {"RS:X M", "RS:X W","LASER STD","LASER RAD", "470 M", "470 W","FINN",	"49ER",	"FX ONE","NACRA"});
        dClass.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 1)){
                BD.Update(row+1, COLUMNA[col], dClass.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceClass= new DefaultCellEditor(dClass);
        table.getColumnModel().getColumn(1).setCellEditor(dceClass);
        
        Desplegable dArea = new Desplegable(1,new String[] {"Päo Açucar", "Escola Naval","Niteroi","Ponte", "Copacabana", "Pai","Aeroport"});
        dArea.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 6)){
                BD.Update(row+1, COLUMNA[col], dArea.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceArea= new DefaultCellEditor(dArea);
        table.getColumnModel().getColumn(7).setCellEditor(dceArea);
        
        Desplegable dCommittee = new Desplegable(1,new String[] {"Christoph", "Maria","Stogg","Luiggi", "Sulis", "John","Other"});
        dCommittee.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 7)){
                BD.Update(row+1, COLUMNA[col], dCommittee.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceCommittee= new DefaultCellEditor(dCommittee);
        table.getColumnModel().getColumn(8).setCellEditor(dceCommittee);
        
        Desplegable dRaceStatus = new Desplegable(1,new String[] {"SCHEDULED", "POSTPONDMENT","ON SEQUENCE","SAILING", "FINISHED", "ABANDON","ON TIME"});
        dRaceStatus.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 8) ){
                BD.Update(row+1, COLUMNA[col], dRaceStatus.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceRaceStatus= new DefaultCellEditor(dRaceStatus);
        table.getColumnModel().getColumn(9).setCellEditor(dceRaceStatus);
        
        Desplegable dSignal = new Desplegable(1,new String[] {"DELTA", "AP","AP+A","N+A", "LIMA"});
        dSignal.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 9)){
                BD.Update(row+1, COLUMNA[col], dSignal.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceSignal= new DefaultCellEditor(dSignal);
        table.getColumnModel().getColumn(10).setCellEditor(dceSignal);
        
        Desplegable dPrepSig = new Desplegable(1,new String[] {"PAPA", "INDIA - 30.1","ZULU - 30.2","BLACK - 30.3", "OTHER"});
        dPrepSig.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 14)){
                BD.Update(row+1, COLUMNA[col], dPrepSig.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dcePrepSig= new DefaultCellEditor(dPrepSig);
        table.getColumnModel().getColumn(15).setCellEditor(dcePrepSig);
        
        Desplegable dLastSig = new Desplegable(1,new String[] {"LAST BOAT", "FINISH CLOSED","AP+A","N+A", "ONB PUBLICATION"});
        dLastSig.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 21)){
                BD.Update(row+1, COLUMNA[col], dLastSig.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceLastSig= new DefaultCellEditor(dLastSig);
        table.getColumnModel().getColumn(22).setCellEditor(dceLastSig);
        
        Desplegable dResults = new Desplegable(1,new String[] {"RECEIVED", "REVIEWING","PUBLISHED"});
        dResults.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 23)){
                BD.Update(row+1, COLUMNA[col], dResults.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceResults= new DefaultCellEditor(dResults);
        table.getColumnModel().getColumn(24).setCellEditor(dceResults);
        
        Desplegable dGroup = new Desplegable(1,new String[] {"Yellow Q-series", "Blue Q-series","Red Q-series","Yellow F-series","Blue F-series","Red F-series","Gold","Silver","Bronze","Fleet","Medal Race"});
        dGroup.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 2)){
                BD.Update(row+1, COLUMNA[col], dGroup.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceGroup= new DefaultCellEditor(dGroup);
        table.getColumnModel().getColumn(2).setCellEditor(dceGroup);
        
        Desplegable dChanges = new Desplegable(1,new String[] {"Starboard", "Port","Increased","Decreased","Stb. Incr.","Prt. Incr.","Stb. Decr.","Prt. Decr."});
        dChanges.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = table.getModel();
            int col = table.getSelectedColumn();
            int row = table.getSelectedRow();
            System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 28)){
                BD.Update(row+1, COLUMNA[col], dChanges.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });
        DefaultCellEditor dceChanges= new DefaultCellEditor(dChanges);
        table.getColumnModel().getColumn(28).setCellEditor(dceChanges);
        
        
    }
    
    private void initHeader(JTable table){
        TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_StartsAbandoned = new ColumnGroup("Starts Abandoned");
        g_StartsAbandoned.add(cm.getColumn(17));
        g_StartsAbandoned.add(cm.getColumn(18));


        ColumnGroup g_Races = new ColumnGroup("RACES");
        g_Races.add(cm.getColumn(1));
        g_Races.add(cm.getColumn(2));
        g_Races.add(cm.getColumn(3));
        g_Races.add(cm.getColumn(4));
        g_Races.add(cm.getColumn(5));
        g_Races.add(cm.getColumn(6));
        g_Races.add(cm.getColumn(7));
        g_Races.add(cm.getColumn(8));

        ColumnGroup g_AshoreSignal = new ColumnGroup("Ashore Signals");
        g_AshoreSignal.add(cm.getColumn(10));
        g_AshoreSignal.add(cm.getColumn(11));

        ColumnGroup g_Start = new ColumnGroup("START");
        g_Start.add(cm.getColumn(12));
        g_Start.add(cm.getColumn(13));
        g_Start.add(cm.getColumn(14));
        g_Start.add(cm.getColumn(15));
        g_Start.add(cm.getColumn(16));
        g_Start.add(g_AshoreSignal);
        g_Start.add(g_StartsAbandoned);

        ColumnGroup g_Finish = new ColumnGroup("FINISH");
        g_Finish.add(cm.getColumn(19));
        g_Finish.add(cm.getColumn(20));
        g_Finish.add(cm.getColumn(21));

        ColumnGroup g_DayEnd = new ColumnGroup("DAY END");
        g_DayEnd.add(cm.getColumn(22));
        g_DayEnd.add(cm.getColumn(23));
        g_DayEnd.add(cm.getColumn(24));

        ColumnGroup g_Course = new ColumnGroup("COURSE");
        g_Course.add(cm.getColumn(25));
        g_Course.add(cm.getColumn(26));
        g_Course.add(cm.getColumn(27));
        g_Course.add(cm.getColumn(28));
        g_Course.add(cm.getColumn(29));
        g_Course.add(cm.getColumn(30));

        ColumnGroup g_SailingConditions = new ColumnGroup("SAILING CONDITIONS");
        g_SailingConditions.add(cm.getColumn(31));
        g_SailingConditions.add(cm.getColumn(32));
        g_SailingConditions.add(cm.getColumn(33));
        g_SailingConditions.add(cm.getColumn(34));
        g_SailingConditions.add(cm.getColumn(35));
        g_SailingConditions.add(cm.getColumn(36));    
        g_SailingConditions.add(cm.getColumn(37));
        g_SailingConditions.add(cm.getColumn(38));

        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.addColumnGroup(g_Races);
        header.addColumnGroup(g_Start);
        header.addColumnGroup(g_AshoreSignal);
        header.addColumnGroup(g_Finish);
        header.addColumnGroup(g_DayEnd);
        header.addColumnGroup(g_Course);
        header.addColumnGroup(g_SailingConditions);
        
        header.setFont(new Font("Arial", Font.BOLD ,15));
    }
    
    private void finishTime(int row, int column){
        System.out.println("FINISH TIME");
        if((modelo.getValueAt(row, 13) != "") && (modelo.getValueAt(row, 19) != "") ){
            SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm:ss");
            try{
                    Date date1 = timerformat.parse(modelo.getValueAt(row, 13).toString());
                    Date date2 = timerformat.parse(modelo.getValueAt(row, 19).toString());
                    Date date = new Date();
                    long millis = date2.getTime()-date1.getTime();
                    String hms = String.format("%02d:%02d:%02d", 
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) -  
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
                    TimeUnit.MILLISECONDS.toSeconds(millis) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                    //System.out.println(modelo.getValueAt(row, 19).toString());
                    if(!hms.equals(modelo.getValueAt(row, 20).toString())){
                        modelo.setValueAt(hms, row, 20);
                        BD.Update(row+1, COLUMNA[20], hms);
                    //System.out.println("ASDSA" + modelo.getValueAt(row, 19).toString());
                }
            } catch (Exception es) {
                System.out.println(es.getMessage());
                es.printStackTrace();
            }
        }
        else{
            modelo.setValueAt("", row, 20);
            BD.Update(row+1, COLUMNA[20], "");
        }
    }
    
    private boolean correctValue(int c, String val){
        if(!val.equals("")){
            switch(c){               
                case 4:
                case 5:
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = formatter.parse(val);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case 11:
                case 12:
                case 23:
                    SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = timerformat.parse(val);
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                case 13:
                case 19:
                case 20:
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
        BD.initBD();
        
        for(int i = 0; i < BD.getBD().size(); ++i ){
            Regata r = BD.getBD().get(i);
            modelo.setValueAt(r.getId(),i,0);
            modelo.setValueAt(r.getClas(),i,1);
            modelo.setValueAt(r.getGroup(),i,2);
            modelo.setValueAt(r.getRace(),i,3);
            modelo.setValueAt(r.getScheduledDate(),i,4);
            modelo.setValueAt(r.getRealDate(),i,5);
            modelo.setValueAt(r.getEntries(),i,6);
            modelo.setValueAt(r.getArea(),i,7);
            modelo.setValueAt(r.getCommittee(),i,8);
            modelo.setValueAt(r.getRaceStatus(),i,9);
            modelo.setValueAt(r.getSignal(),i,10);
            modelo.setValueAt(r.getTime(),i,11);
            modelo.setValueAt(r.getScheduledTime(),i,12);
            modelo.setValueAt(r.getStartingTime(),i,13);
            modelo.setValueAt(r.getBoatsStarted(),i,14);
            modelo.setValueAt(r.getPreparatorySignal(),i,15);
            modelo.setValueAt(r.getOCS_DSQ(),i,16);
            modelo.setValueAt(r.getAP(),i,17);
            modelo.setValueAt(r.getGR(),i,18);
            modelo.setValueAt(r.getFinishTime(),i,19);
            modelo.setValueAt(r.getRaceTime(),i,20);
            modelo.setValueAt(r.getBoatsFinished(),i,21);
            modelo.setValueAt(r.getLastSignal(), i, 22);
            modelo.setValueAt(r.getLastSignalTime(), i, 23);
            modelo.setValueAt(r.getResults(), i, 24);
            modelo.setValueAt(r.getCourse(),i,25);
            modelo.setValueAt(r.getDistance1stLeg(),i,26);
            modelo.setValueAt(r.getBearing1stLeg(),i,27);
            modelo.setValueAt(r.getLegChanges(),i,28);
            modelo.setValueAt(r.getWindDir(),i,29);
            modelo.setValueAt(r.getWindSpeed(),i,30);
            modelo.setValueAt(r.getWindDir25(),i,31);
            modelo.setValueAt(r.getWindSpeed25(),i,32);
            modelo.setValueAt(r.getWindDir50(),i,33);
            modelo.setValueAt(r.getWindSpeed50(),i,34);
            modelo.setValueAt(r.getWindDir75(),i,35);
            modelo.setValueAt(r.getWindSpeed75(),i,36);
            modelo.setValueAt(r.getWindDir100(),i,37);
            modelo.setValueAt(r.getWindSpeed100(),i,38);
        }
        CheckGrid();
    }
    
    private void DataTable(){
        
        modelo = new DefaultTableModel();
        modelo.setDataVector(new Object[][]{}, titulos);
        String [] fila = new String[titulos.length];
        
        BD = new BaseDatos();
        BD.initBD();
        int size = BD.getBD().size();
        
        for(int i = 0; i < size; ++i){
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
                    if(j == 12 && i == 0) System.out.println("BORRAMOS" + (ob  == null));
                }
                else if(ob.toString().equals("-1") || ob.toString().equals("-1.0") || ob.toString().isEmpty()) modelo.setValueAt("", i, j);
                
            }
        }
    }
    
    
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {
        Table table = new Table();
                
    });
  }
    
}
