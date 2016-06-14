/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BaseDatos.BaseDatos;
import Estructuras.Regata;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import Estructuras.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.ImageIcon;
/**
 *
 * @author Miquel Ferriol
 */
public class BollaTable extends JFrame{
    
    private String[] COLUMNA = {"Id","Race","Race","Mark1","Mark2","Mark3","Mark4","Mark5","Mark6","Mark7","Mark8","Mark9","Mark10","Mark11","Mark12"};
    private String [] titulos ={"Id","Race","Race","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    private DefaultTableModel modelo;
    private BaseDatos BD;
    private Timer displayTimer;     
    
    public BollaTable(BaseDatos BD) {
        super("");
        this.BD = BD;
        try{
            setIconImage(new ImageIcon(getClass().getResource("Imagenes/IMAGE1.PNG")).getImage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        DataTable();
        JTable bTable = new JTable(modelo){
          @Override
          protected JTableHeader createDefaultTableHeader() {
              return new GroupableTableHeader(columnModel);
          }
        };
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        bTable.setDefaultRenderer(Object.class, r);
        //add(new JScrollPane(bTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );

        ActionListener listener = (ActionEvent event) -> {
            printTable();
            displayTimer.restart();
        };
        displayTimer = new Timer(4000, listener);
        displayTimer.start();

        bTable.getDefaultEditor(String.class).addCellEditorListener(
            new CellEditorListener() {
                @Override
                public void editingCanceled(ChangeEvent e) {
                    ////System.out.println("editingCanceled");
                }

                @Override
                public void editingStopped(ChangeEvent e) {
                    
                    //System.out.println("editingStopped: apply additional action");
                    ////System.out.println(bTable.getSelectedColumn());
                    int column = bTable.getSelectedColumn();
                    int row = bTable.getSelectedRow();
                    lastCol = column;
                    lastRow = row;
                    if(row != -1 && column != -1){
                        Object data = modelo.getValueAt(row, column);

                        if(correctValue(column, data.toString())){
                            BD.Update(row+1, COLUMNA[(column-3)/7 + 3], createVal(row,column,data.toString()));
                            //System.out.println(createVal(row,column,data.toString())+ " " + COLUMNA[(column-3)/7 + 3]);
                        }
                        else if (!"".equals(data.toString())){
                            //System.out.println("INCORRECT");
                            modelo.setValueAt("", row, column);
                        }
                    }
                }
            }
        );
        
        TableColumnAdjuster tca = new TableColumnAdjuster(bTable);
        tca.adjustColumns();

        bTable.setRowHeight(25);

        bTable.getTableHeader().setFont(new Font("Arial", Font.BOLD ,15));
        
        initDesplegable(bTable);
        initHeader(bTable);
    
        add(new JScrollPane(bTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        pack();
        setVisible(true);
    }
    
    private String createVal(int r, int c, String data){
        String s = "";
            if((c-3)%7 == 0){
                s = data +"-"+ modelo.getValueAt(r, c+1)+"-"+ modelo.getValueAt(r, c+2)+"-"+ modelo.getValueAt(r, c+3)+"-"+ modelo.getValueAt(r, c+4)+"-"+ modelo.getValueAt(r, c+5)+"-"+ modelo.getValueAt(r, c+6);
            }
            else if((c-3)%7 == 1){
                s =  modelo.getValueAt(r, c-1)+"-"+data+"-"+ modelo.getValueAt(r, c+1)+"-"+ modelo.getValueAt(r, c+2)+"-"+ modelo.getValueAt(r, c+3)+"-"+ modelo.getValueAt(r, c+4)+"-"+ modelo.getValueAt(r, c+5);
            }
            else if((c-3)%7 == 2){
                s =  modelo.getValueAt(r, c-2)+"-"+ modelo.getValueAt(r, c-1)+"-"+ data+"-"+ modelo.getValueAt(r, c+1)+"-"+ modelo.getValueAt(r, c+2)+"-"+ modelo.getValueAt(r, c+3)+"-"+ modelo.getValueAt(r, c+4);
            }
            else if((c-3)%7 == 3){
                s =  modelo.getValueAt(r, c-3)+"-"+ modelo.getValueAt(r, c-2)+"-"+ modelo.getValueAt(r, c-1)+"-"+data+"-"+ modelo.getValueAt(r, c+1)+"-"+ modelo.getValueAt(r, c+2)+"-"+ modelo.getValueAt(r, c+3);
            }
            else if((c-3)%7 == 4){
                s = modelo.getValueAt(r, c-4)+"-"+ modelo.getValueAt(r, c-3)+"-"+ modelo.getValueAt(r, c-2)+"-"+ modelo.getValueAt(r, c-1)+"-" +data +"-"+ modelo.getValueAt(r, c+1)+"-"+ modelo.getValueAt(r, c+2);
            }
            else if((c-3)%7 == 5){
                s = modelo.getValueAt(r, c-5)+"-"+ modelo.getValueAt(r, c-4)+"-"+ modelo.getValueAt(r, c-3)+"-"+ modelo.getValueAt(r, c-2)+"-"+ modelo.getValueAt(r, c-1)+"-"+ data +"-"+ modelo.getValueAt(r, c+1);
            }
            else if((c-3)%7 == 6){
                s = modelo.getValueAt(r, c-6)+"-"+ modelo.getValueAt(r, c-5)+"-"+ modelo.getValueAt(r, c-4)+"-"+ modelo.getValueAt(r, c-3)+"-"+ modelo.getValueAt(r, c-2)+"-"+ modelo.getValueAt(r, c-1)+"-"+ data;
            }
            else return s;
        return s;
    }
    
    
    

    private boolean correctValue(int c, String val){
        if(!val.equals("")){
            if((c-3)%7 == 0){
                return true;
            }
            else if((c-3)%7 == 1){
                return val.contains("N") || val.contains("S");
            }
            else if((c-3)%7 == 2){
                try{
                    int aux = Integer.parseInt(val);
                    return aux <= 360 && aux >= 0;// && Integer.parseInt(val) >= 0;
                }
                catch(Exception e){
                    return false;
                }
            }
            else if((c-3)%7 == 3){
                try{
                    Double aux = Double.parseDouble(val);
                    return aux < 60 && aux >= 0;// && Integer.parseInt(val) >= 0;
                }
                catch(Exception e){
                    return false;
                }
                
            }
            else if((c-3)%7 == 4){
                return val.contains("E") || val.contains("W");
            }
            else if((c-3)%7 == 5){
                try{
                    int aux = Integer.parseInt(val);
                    return aux <= 360 && aux >= 0;// && Integer.parseInt(val) >= 0;
                }
                catch(Exception e){
                    return false;
                }
                
            }
            else if((c-3)%7 == 6){
                try{
                    Double aux = Double.parseDouble(val);
                    return aux < 60 && aux >= 0;// && Integer.parseInt(val) >= 0;
                }
                catch(Exception e){
                    return false;
                }
                
            }
            else return false;
        }
        else return true;
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
                //System.out.println("CAMBIADO");
            
        }
    }
    int lRow;
    boolean cont = false;
    int lastCol = -1;
    int lastRow = -1;
    
    private void initDesplegable(JTable bTable){
        Desplegable dClass = new Desplegable(1,new String[] {"RS:X M", "RS:X W","LASER STD","LASER RAD", "470 M", "470 W","FINN",	"49ER",	"FX ONE","NACRA"});
        dClass.addItemListener ((ItemEvent itemEvent) -> {
            int state1 = itemEvent.getStateChange();
            TableModel model = bTable.getModel();
            int col = bTable.getSelectedColumn();
            int row = bTable.getSelectedRow();
            //System.out.println("row: " + row + " col: " + col + " race: " + dClass.getSelectedItem());
            if(lastCol != col || lastRow != row && (col == 1)){
                BD.Update(row+1, COLUMNA[col], dClass.getSelectedItem());
                lastCol = col;
                lastRow = row;
            }
        });       
    }
    
    private void initHeader(JTable bTable){
        TableColumnModel cm = bTable.getColumnModel();
        
        ColumnGroup g_WP1 = new ColumnGroup("WP1");
        g_WP1.add(cm.getColumn(3));
        g_WP1.add(cm.getColumn(4));
        g_WP1.add(cm.getColumn(5));
        g_WP1.add(cm.getColumn(6));
        g_WP1.add(cm.getColumn(7));
        g_WP1.add(cm.getColumn(8));
        g_WP1.add(cm.getColumn(9));
        ColumnGroup g_WP2 = new ColumnGroup("WP2");
        g_WP2.add(cm.getColumn(10));
        g_WP2.add(cm.getColumn(11));
        g_WP2.add(cm.getColumn(12));
        g_WP2.add(cm.getColumn(13));
        g_WP2.add(cm.getColumn(14));
        g_WP2.add(cm.getColumn(15));
        g_WP2.add(cm.getColumn(16));
        ColumnGroup g_WP3 = new ColumnGroup("WP3");
        g_WP3.add(cm.getColumn(17));
        g_WP3.add(cm.getColumn(18));
        g_WP3.add(cm.getColumn(19));
        g_WP3.add(cm.getColumn(20));
        g_WP3.add(cm.getColumn(21));
        g_WP3.add(cm.getColumn(22));
        g_WP3.add(cm.getColumn(23));
        ColumnGroup g_WP4 = new ColumnGroup("WP4");
        g_WP4.add(cm.getColumn(24));
        g_WP4.add(cm.getColumn(25));
        g_WP4.add(cm.getColumn(26));
        g_WP4.add(cm.getColumn(27));
        g_WP4.add(cm.getColumn(28));
        g_WP4.add(cm.getColumn(29));
        g_WP4.add(cm.getColumn(30));
        ColumnGroup g_WP5 = new ColumnGroup("WP5");
        g_WP5.add(cm.getColumn(31));
        g_WP5.add(cm.getColumn(32));
        g_WP5.add(cm.getColumn(33));
        g_WP5.add(cm.getColumn(34));
        g_WP5.add(cm.getColumn(35));
        g_WP5.add(cm.getColumn(36));
        g_WP5.add(cm.getColumn(37));
        ColumnGroup g_WP6 = new ColumnGroup("WP6");
        g_WP6.add(cm.getColumn(38));
        g_WP6.add(cm.getColumn(39));
        g_WP6.add(cm.getColumn(40));
        g_WP6.add(cm.getColumn(41));
        g_WP6.add(cm.getColumn(42));
        g_WP6.add(cm.getColumn(43));
        g_WP6.add(cm.getColumn(44));
        ColumnGroup g_WP7 = new ColumnGroup("WP7");
        g_WP7.add(cm.getColumn(45));
        g_WP7.add(cm.getColumn(46));
        g_WP7.add(cm.getColumn(47));
        g_WP7.add(cm.getColumn(48));
        g_WP7.add(cm.getColumn(49));
        g_WP7.add(cm.getColumn(50));
        g_WP7.add(cm.getColumn(51));
        ColumnGroup g_WP8 = new ColumnGroup("WP8");
        g_WP8.add(cm.getColumn(52));
        g_WP8.add(cm.getColumn(53));
        g_WP8.add(cm.getColumn(54));
        g_WP8.add(cm.getColumn(55));
        g_WP8.add(cm.getColumn(56));
        g_WP8.add(cm.getColumn(57));
        g_WP8.add(cm.getColumn(58));
        ColumnGroup g_WP9 = new ColumnGroup("WP9");
        g_WP9.add(cm.getColumn(59));
        g_WP9.add(cm.getColumn(60));
        g_WP9.add(cm.getColumn(61));
        g_WP9.add(cm.getColumn(62));
        g_WP9.add(cm.getColumn(63));
        g_WP9.add(cm.getColumn(64));
        g_WP9.add(cm.getColumn(65));
        ColumnGroup g_WP10 = new ColumnGroup("WP10");
        g_WP10.add(cm.getColumn(66));
        g_WP10.add(cm.getColumn(67));
        g_WP10.add(cm.getColumn(68));
        g_WP10.add(cm.getColumn(69));
        g_WP10.add(cm.getColumn(70));
        g_WP10.add(cm.getColumn(71));
        g_WP10.add(cm.getColumn(72));
        ColumnGroup g_WP11 = new ColumnGroup("WP11");
        g_WP11.add(cm.getColumn(73));
        g_WP11.add(cm.getColumn(74));
        g_WP11.add(cm.getColumn(75));
        g_WP11.add(cm.getColumn(76));
        g_WP11.add(cm.getColumn(77));
        g_WP11.add(cm.getColumn(78));
        g_WP11.add(cm.getColumn(79));
        ColumnGroup g_WP12 = new ColumnGroup("WP12");
        g_WP12.add(cm.getColumn(80));
        g_WP12.add(cm.getColumn(81));
        g_WP12.add(cm.getColumn(82));
        g_WP12.add(cm.getColumn(83));
        g_WP12.add(cm.getColumn(84));
        g_WP12.add(cm.getColumn(85));
        g_WP12.add(cm.getColumn(86));

        GroupableTableHeader header = (GroupableTableHeader)bTable.getTableHeader();
        header.addColumnGroup(g_WP1);
        header.addColumnGroup(g_WP2);
        header.addColumnGroup(g_WP3);
        header.addColumnGroup(g_WP4);
        header.addColumnGroup(g_WP5);
        header.addColumnGroup(g_WP6);
        header.addColumnGroup(g_WP7);
        header.addColumnGroup(g_WP8);
        header.addColumnGroup(g_WP9);
        header.addColumnGroup(g_WP10);
        header.addColumnGroup(g_WP11);
        header.addColumnGroup(g_WP12);
        
        header.setFont(new Font("Arial", Font.BOLD ,15));
    }
    
    private void printTable(){
        BD.initBD();
        for(int i = 0; i < BD.getBD().size(); ++i ){
            Cjt_Bolla cjt = BD.getBDB().get(i);
            Regata r = BD.getBD().get(i);
            modelo.setValueAt(r.getId(),i,0);
            modelo.setValueAt(r.getClas(),i,1);
            ////System.out.println("RACE:" + r.getRace());
            modelo.setValueAt(r.getRace(), i, 2);
            for(int j = 0; j < 12; ++j){
                modelo.setValueAt(cjt.getI(j).getName(),i,3+7*j);
                modelo.setValueAt(cjt.getI(j).getN_S(),i,4+7*j);
                modelo.setValueAt(cjt.getI(j).getNDegree(),i,5+7*j);
                modelo.setValueAt(cjt.getI(j).getNMinutes(),i,6+7*j);
                modelo.setValueAt(cjt.getI(j).getE_W(),i,7+7*j);
                modelo.setValueAt(cjt.getI(j).getEDegree(),i,8+7*j);
                modelo.setValueAt(cjt.getI(j).getEMinutes(),i,9+7*j);
            }
        }
        CheckGrid();
    }
    
    private void DataTable(){
        
        modelo = new DefaultTableModel();
        modelo.setDataVector(new Object[][]{}, titulos);
        String [] fila = new String[titulos.length];
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
}
    

