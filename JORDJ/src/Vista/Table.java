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
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Miquel Ferriol
 */


public final class Table extends JFrame{
    
    private Timer displayTimer;        
    private String[] COLUMNA = {"id", "Class", "Race", "ScheduledDate", "RealDate", "Entries", "Area", "Committee", "RaceStatus", "Signall", "Time","ScheduledTime", "StartingTime", "BoatsStarted", "PreparatorySignal", "OCS_DSQ", "AP", "GR", "FinishTime", "RaceTime" ,  "BoatsFinished", "LastSignal", "LastSignalTime", "Results", "Course", "Distance1stLeg", "Bearing1stLeg", "LegChanges", "WindDir", "WindSpeed","WindDir25", "WindSpeed25","WindDir50", "WindSpeed50","WindDir75", "WindSpeed75","WindDir100", "WindSpeed100"};
    private String [] titulos ={"Id", "Class", "Race", "Scheduled Date", "Real Date", "Entries", "Area", "Committee", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "Nr.OCS/DSQ", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges", "Wind Dir.", "WindSpeed","Wind Dir. 25%", "WindSpeed 25%","Wind Dir. 50%", "WindSpeed 50%","Wind Dir. 75%", "WindSpeed 75%","Wind Dir. 100%", "WindSpeed 100%"};
    private DefaultTableModel modelo;
    private BaseDatos BD;
    
    public class TableRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        if(column == 9 || column == 14 || column == 27){
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
        else if(column == 8){
            try{
                String s =  modelo.getValueAt(row, column).toString();
                JLabel lbl = new JLabel();
                ImageIcon icon; 
                if(s.equals("SCHEDULED")){
                    s = "YELLOW";
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                    lbl.setText("SCHEDULED");
                    
                }
                else if(s.equals("POSTPONDMENT")){
                    s = "AP";
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                }
                else if(s.equals("ON SEQUENCE")){
                    s = "ORANGE";
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                }
                else if (s.equals("FINISHED")){
                    s = "BLUE"; 
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                }
                else if (s.equals("ABANDON")){
                    s = "NOVEMBER";
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                }
                else if (s.equals("SAILING")){
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                }
                else if (s.equals("ON TIME")){
                    s = "WHITE";
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + s + ".JPG"));
                    lbl.setText("ON TIME");
                }
                else{
                    lbl.setText(s);
                    icon = new ImageIcon(getClass().getResource("Imagenes/" + "WHITE" + ".JPG"));
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
        else if (column == 6){
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
        /*if(column == 28){
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
                    //System.out.println("editingStopped: apply additional action");
                    //System.out.println(table.getSelectedColumn());
                    int column = table.getSelectedColumn();
                    int row = table.getSelectedRow();
                    Object data = modelo.getValueAt(row, column);

                    if(correctValue(column, data.toString())){
                            BD.Update(row+1, COLUMNA[column], data);
                        }
                    else if (!"".equals(data.toString())){
                        modelo.setValueAt("", row, column);
                    }

                    if(column == 12 || column == 18){
                            finishTime(row,column);
                    }

                }
            }
        );
        
        displayTimer = new Timer(4000, listener);
        displayTimer.start();

        TableColumnAdjuster tca = new TableColumnAdjuster(table);
        tca.adjustColumns();

        table.setRowHeight(50);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD ,15));
        
        initHeader(table);
    
        add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        pack();
        setVisible(true);
    }
    
    private void initHeader(JTable table){
        TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_StartsAbandoned = new ColumnGroup("Starts Abandoned");
        g_StartsAbandoned.add(cm.getColumn(16));
        g_StartsAbandoned.add(cm.getColumn(17));


        ColumnGroup g_Races = new ColumnGroup("RACES");
        g_Races.add(cm.getColumn(1));
        g_Races.add(cm.getColumn(2));
        g_Races.add(cm.getColumn(3));
        g_Races.add(cm.getColumn(4));
        g_Races.add(cm.getColumn(5));
        g_Races.add(cm.getColumn(6));
        g_Races.add(cm.getColumn(7));

        ColumnGroup g_AshoreSignal = new ColumnGroup("Ashore Signals");
        g_AshoreSignal.add(cm.getColumn(9));
        g_AshoreSignal.add(cm.getColumn(10));

        ColumnGroup g_Start = new ColumnGroup("START");
        g_Start.add(cm.getColumn(11));
        g_Start.add(cm.getColumn(12));
        g_Start.add(cm.getColumn(13));
        g_Start.add(cm.getColumn(14));
        g_Start.add(cm.getColumn(15));
        g_Start.add(g_AshoreSignal);
        g_Start.add(g_StartsAbandoned);

        ColumnGroup g_Finish = new ColumnGroup("FINISH");
        g_Finish.add(cm.getColumn(18));
        g_Finish.add(cm.getColumn(19));
        g_Finish.add(cm.getColumn(20));

        ColumnGroup g_DayEnd = new ColumnGroup("DAY END");
        g_DayEnd.add(cm.getColumn(21));
        g_DayEnd.add(cm.getColumn(22));
        g_DayEnd.add(cm.getColumn(23));

        ColumnGroup g_Course = new ColumnGroup("COURSE");
        g_Course.add(cm.getColumn(24));
        g_Course.add(cm.getColumn(25));
        g_Course.add(cm.getColumn(26));
        g_Course.add(cm.getColumn(27));
        g_Course.add(cm.getColumn(28));
        g_Course.add(cm.getColumn(29));

        ColumnGroup g_SailingConditions = new ColumnGroup("SAILING CONDITIONS");
        g_SailingConditions.add(cm.getColumn(30));
        g_SailingConditions.add(cm.getColumn(31));
        g_SailingConditions.add(cm.getColumn(32));
        g_SailingConditions.add(cm.getColumn(33));
        g_SailingConditions.add(cm.getColumn(34));
        g_SailingConditions.add(cm.getColumn(35));    
        g_SailingConditions.add(cm.getColumn(36));
        g_SailingConditions.add(cm.getColumn(37));

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
        if((modelo.getValueAt(row, 12) != "") && (modelo.getValueAt(row, 18) != "") ){
            SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm:ss");
            try{
                    Date date1 = timerformat.parse(modelo.getValueAt(row, 12).toString());
                    Date date2 = timerformat.parse(modelo.getValueAt(row, 18).toString());
                    Date date = new Date();
                    long millis = date2.getTime()-date1.getTime();
                    String hms = String.format("%02d:%02d:%02d", 
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) -  
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
                    TimeUnit.MILLISECONDS.toSeconds(millis) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                    //System.out.println(modelo.getValueAt(row, 19).toString());
                    if(!hms.equals(modelo.getValueAt(row, 19).toString())){
                        modelo.setValueAt(hms, row, 19);
                        BD.Update(row+1, COLUMNA[19], hms);
                    //System.out.println("ASDSA" + modelo.getValueAt(row, 19).toString());
                }
            } catch (Exception es) {
            }
        }
        else{
            modelo.setValueAt("", row, 19);
            BD.Update(row+1, COLUMNA[19], "");
        }
    }
    
    public boolean correctValue(int c, String val){
        if(!val.equals("")){
            switch(c){               
                case 3:
                case 4:
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = formatter.parse(val);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case 10:
                case 11:
                case 22:
                    SimpleDateFormat timerformat = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = timerformat.parse(val);
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                case 12:
                case 18:
                case 19:
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
    
    
    public void printTable(){
        BD.initBD();
        
        for(int i = 0; i < BD.getBD().size(); ++i ){
            Regata r = BD.getBD().get(i);
            modelo.setValueAt(r.getId(),i,0);
            modelo.setValueAt(r.getClas(),i,1);
            modelo.setValueAt(r.getRace(),i,2);
            modelo.setValueAt(r.getScheduledDate(),i,3);
            modelo.setValueAt(r.getRealDate(),i,4);
            modelo.setValueAt(r.getEntries(),i,5);
            modelo.setValueAt(r.getArea(),i,6);
            modelo.setValueAt(r.getCommittee(),i,7);
            modelo.setValueAt(r.getRaceStatus(),i,8);
            modelo.setValueAt(r.getSignal(),i,9);
            modelo.setValueAt(r.getTime(),i,10);
            modelo.setValueAt(r.getScheduledTime(),i,11);
            modelo.setValueAt(r.getStartingTime(),i,12);
            modelo.setValueAt(r.getBoatsStarted(),i,13);
            modelo.setValueAt(r.getPreparatorySignal(),i,14);
            modelo.setValueAt(r.getOCS_DSQ(),i,15);
            modelo.setValueAt(r.getAP(),i,16);
            modelo.setValueAt(r.getGR(),i,17);
            modelo.setValueAt(r.getFinishTime(),i,18);
            modelo.setValueAt(r.getRaceTime(),i,19);
            modelo.setValueAt(r.getBoatsFinished(),i,20);
            modelo.setValueAt(r.getLastSignal(), i, 21);
            modelo.setValueAt(r.getLastSignalTime(), i, 22);
            modelo.setValueAt(r.getResults(), i, 23);
            modelo.setValueAt(r.getCourse(),i,24);
            modelo.setValueAt(r.getDistance1stLeg(),i,25);
            modelo.setValueAt(r.getBearing1stLeg(),i,26);
            modelo.setValueAt(r.getLegChanges(),i,27);
            modelo.setValueAt(r.getWindDir(),i,28);
            modelo.setValueAt(r.getWindSpeed(),i,29);
            modelo.setValueAt(r.getWindDir25(),i,30);
            modelo.setValueAt(r.getWindSpeed25(),i,31);
            modelo.setValueAt(r.getWindDir50(),i,32);
            modelo.setValueAt(r.getWindSpeed50(),i,33);
            modelo.setValueAt(r.getWindDir75(),i,34);
            modelo.setValueAt(r.getWindSpeed75(),i,35);
            modelo.setValueAt(r.getWindDir100(),i,36);
            modelo.setValueAt(r.getWindSpeed100(),i,37);
        }
        CheckGrid();
    }
    
    public final void DataTable(){
        
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
    
    public void CheckGrid(){
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
