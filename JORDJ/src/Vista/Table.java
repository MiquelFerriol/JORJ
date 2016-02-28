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

/**
 *
 * @author Miquel Ferriol
 */
public final class Table extends JPanel{
    
    Timer displayTimer;        
    private String[] COLUMNA = {"id", "Class", "Race", "ScheduledDate", "RealDate", "Entries", "Area", "Committee", "RaceStatus", "Signal", "Time","ScheduledTime", "StartingTime", "BoatsStarted", "PreparatorySignal", "OCS/DSQ", "AP", "GR", "FinishTime", "RaceTime" ,  "BoatsFinished", "LastSignal", "LastSignalTime", "Results", "Course", "Distance1stLeg", "Bearing1stLeg", "LegChanges", "WindDir", "WindSpeed","WindDir25", "WindSpeed25","WindDir50", "WindSpeed50","Wind Dir75", "WindSpeed75","WindDir100", "WindSpeed100"};
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
    //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    //Add the scroll pane to this panel.
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
                    }
                });
    displayTimer = new Timer(4000, listener);
    displayTimer.start();
    
    TableColumnAdjuster tca = new TableColumnAdjuster(table);
    tca.adjustColumns();
    
    table.setRowHeight(30);
    
    table.getTableHeader().setFont(new Font("Arial", Font.BOLD ,15));
    
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

                                timerformat.parse(val).getTime();
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
                if (ob  == null || ob.toString().equals("-1") || ob.toString().isEmpty()) {
                    modelo.setValueAt("", i, j);
                }
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
