/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BaseDatos.BaseDatos;
import Estructuras.Regata;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import BaseDatos.BaseDatos;
import Estructuras.Regata;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import javax.swing.table.TableModel;

/**
 *
 * @author Miquel Ferriol
 */
public class Table extends JPanel{
    public String[] COLUMNA = {"id", "Class", "Race", "ScheduledDate", "RealDate", "Entries", "Area", "Committe", "RaceStatus", "Signal", "Time","ScheduledTime", "StartingTime", "BoatsStarted", "PreparatorySignal", "OCS/DSQ", "AP", "GR", "FinishTime", "RaceTime" ,  "BoatsFinished", "LastSignal", "LastSignalTime", "Results", "Course", "Distance1stLeg", "Bearing1stLeg", "LegChanges", "WindDir", "WindSpeed","WindDir25", "WindSpeed25","WindDir50", "WindSpeed50","Wind Dir75", "WindSpeed75","WindDir100", "WindSpeed100"};
    
    public class MyRenderer extends DefaultTableCellRenderer { 
        public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        return c; 
    } 

    }
    
    DefaultTableModel modelo;
    BaseDatos BD;
    
    
    public class SimpleTableDemo  implements TableModelListener {

    public SimpleTableDemo(JTable table) {
        table.getModel().addTableModelListener(this);
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        System.out.println("id: " + (row+1) + " columna: " + COLUMNA[column] + " " + (column+1) + " " + data);
        BD.Update(row+1, COLUMNA[column], data);
    }
}
    public Table() {
    super(new GridLayout(1, 0));
    cargarCliente();
    JTable table = new JTable(modelo);
    MyRenderer r = new MyRenderer();
    r.setHorizontalAlignment(JLabel.CENTER);
    table.setDefaultRenderer(Object.class, r);

    SimpleTableDemo p = new SimpleTableDemo(table);
    //table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    add(scrollPane);
    
}
    
    public final void cargarCliente(){
        String [] titulos ={"Id", "Class", "Race", "Scheduled Date", "Real Date", "Entries", "Area", "Committe", "RACE STATUS", "Signal", "Time","Scheduled Time", "Starting Time", "Boats Started", "Preparatory Signal", "Nr.OCS/DSQ", "AP", "GR", "Finish Time", "Race Time" ,  "Boats Finished", "Last Signal", "Last Signal Time", "Results", "Course", "Distance 1stLeg", "Bearing1stLeg", "LegChanges", "Wind Dir.", "WindSpeed","Wind Dir. 25%", "WindSpeed 25%","Wind Dir. 50%", "WindSpeed 50%","Wind Dir. 75%", "WindSpeed 75%","Wind Dir. 100%", "WindSpeed 100%"};
        modelo = new DefaultTableModel(null, titulos);
        
        String [] fila = new String[titulos.length];
        BD = new BaseDatos();
        BD.initBD();
        
        int size = BD.getBD().size();
        
        for(int i = 0; i < size; ++i){
            Regata r = BD.getBD().get(i);
            fila[0] = ((Integer)r.getId()).toString();
            fila[1] = r.getClas();
            fila[2] = ((Integer)r.getRace()).toString();
            fila[3] = r.getScheduledDate().toString();
            fila[4] = r.getRealDate().toString();
            fila[5] = ((Integer)r.getEntries()).toString();
            fila[6] = r.getArea();
            modelo.addRow(fila);
            System.out.println(r.getId() + " " + r.getClas() + " " + r.getRace() + " " + r.getScheduledDate() + " " + r.getRealDate() + " " + r.getEntries() + " " + r.getArea());
        }
}
    
    private static void createAndShowGUI() {

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
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
    
}
