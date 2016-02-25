/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jordj;
import BaseDatos.*;
import Estructuras.*;
import conSql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Miquel Ferriol
 */
public class JORDJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDatos BD = new BaseDatos();
        BD.initBD();
        int size = BD.getBD().size();
        for(int i = 0; i < size; ++i){
        Regata r = BD.getBD().get(i);
            System.out.println(r.getId() + " " + r.getClas() + " " + r.getRace() + " " + r.getScheduledDate() + " " + r.getRealDate() + " " + r.getEntries() + " " + r.getArea());
        }
    }
    
}
