/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Imgenes.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.*;
import BaseDatos.BaseDatos;
import Estructuras.Regata;
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
import javax.swing.table.*;

/**
 *
 * @author Miquel Ferriol
 */
public final class Table extends JPanel{
    
    Timer displayTimer;        
    private String[] COLUMNA = {"id", "Class", "Race", "ScheduledDate", "RealDate", "Entries", "Area", "Committee", "RaceStatus", "Signall", "Time","ScheduledTime", "StartingTime", "BoatsStarted", "PreparatorySignal", "OCS_DSQ", "AP", "GR", "FinishTime", "RaceTime" ,  "BoatsFinished", "LastSignal", "LastSignalTime", "Results", "Course", "Distance1stLeg", "Bearing1stLeg", "LegChanges", "WindDir", "WindSpeed","WindDir25", "WindSpeed25","WindDir50", "WindSpeed50","WindDir75", "WindSpeed75","WindDir100", "WindSpeed100"};
    private String [] titulos ={"Id", "Class", "Race", "Scheduled Date", "Real Date", "Entries", "Area", "Committee", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "Nr.OCS/DSQ", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges", "Wind Dir.", "WindSpeed","Wind Dir. 25%", "WindSpeed 25%","Wind Dir. 50%", "WindSpeed 50%","Wind Dir. 75%", "WindSpeed 75%","Wind Dir. 100%", "WindSpeed 100%"};
    
    
    public class MyRenderer extends DefaultTableCellRenderer { 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        c.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT ,15));
        return c; 
    } 

    }
    
    DefaultTableModel modelo;
    BaseDatos BD;
    
    
    public Table() {
    super(new GridLayout(1, 0));
    DataTable();
    JTable table = new JTable(modelo){
      protected JTableHeader createDefaultTableHeader() {
        return new GroupableTableHeader(columnModel);
      };
    };
    
    MyRenderer r = new MyRenderer();
    r.setHorizontalAlignment(JLabel.CENTER);
    table.setDefaultRenderer(Object.class, r);
    
    add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    ActionListener listener = (ActionEvent event) -> {
        printTable();
        displayTimer.restart();
    };
    
    table.getDefaultEditor(String.class).addCellEditorListener(
                new CellEditorListener() {
                    @Override
                    public void editingCanceled(ChangeEvent e) {
                        System.out.println("editingCanceled");
                    }

                    @Override
                    public void editingStopped(ChangeEvent e) {
                        System.out.println("editingStopped: apply additional action");
                        System.out.println(table.getSelectedColumn());
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
                });
    displayTimer = new Timer(4000, listener);
    displayTimer.start();
    
    TableColumnAdjuster tca = new TableColumnAdjuster(table);
    tca.adjustColumns();
    
    table.setRowHeight(30);
    
    table.getTableHeader().setFont(new Font("Arial", Font.BOLD ,15));
    
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
                    System.out.println(modelo.getValueAt(row, 19).toString());
                    if(!hms.equals(modelo.getValueAt(row, 19).toString())){
                        modelo.setValueAt(hms, row, 19);
                        BD.Update(row+1, COLUMNA[19], hms);
                    System.out.println("ASDSA" + modelo.getValueAt(row, 19).toString());
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
            //modelo.setValueAt(r.getEntries(),i,5);
            ImageIcon img = new ImageIcon(Diapositiva1.JPG);
            modelo.setValueAt(img,i,5);
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
        //String [] titulos ={"Id", "Class", "Race", "Scheduled Date", "Real Date", "Entries", "Area", "Committe", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "Nr.OCS/DSQ", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges", "Wind Dir.", "WindSpeed","Wind Dir. 25%", "WindSpeed 25%","Wind Dir. 50%", "WindSpeed 50%","Wind Dir. 75%", "WindSpeed 75%","Wind Dir. 100%", "WindSpeed 100%"};
        modelo = new DefaultTableModel(null, titulos);
        
        String [] fila = new String[titulos.length];
        BD = new BaseDatos();
        BD.initBD();
        int size = BD.getBD().size();
        
        for(int i = 0; i < size; ++i){
            modelo.addRow(fila);
            //System.out.println(r.getId() + " " + r.getClas() + " " + r.getRace() + " " + r.getScheduledDate() + " " + r.getRealDate() + " " + r.getEntries() + " " + r.getArea());
        }
        printTable();
        //CheckGrid();
}
    public void CheckGrid(){
        int rows = modelo.getRowCount();
        int col = modelo.getColumnCount();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                Object ob = modelo.getValueAt(i, j);
                //System.out.println(ob);
                if (ob  == null ) {
                       if(j == 12 && i == 0) System.out.println("BORRAMOS" + (ob  == null));
                }
                else if(ob.toString().equals("-1") || ob.toString().equals("-1.0") || ob.toString().isEmpty()) modelo.setValueAt("", i, j);
                
            }
        }
    }
    
    
    public static void createAndShowGUI() {

    //Create and set up the window.
    JFrame frame = new JFrame("Race Status");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_HORIZ);
    //frame.set
    //Create and set up the content pane.
    Table newContentPane = new Table();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
    
   

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(() -> {
                createAndShowGUI();
                
    });
  }
    
}
