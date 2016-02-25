/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.util.ArrayList;
import Estructuras.*;
import conSql.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Miquel Ferriol
 */
public class BaseDatos {
    private ArrayList<Regata> BD;
    
    public BaseDatos(){
        
    }
    
    public void initBD(){
        BD = new ArrayList<Regata>();
        ConectaBD db = new ConectaBD();
        
        String sql = "select * from racestatus";
        try {
            Connection cn = db.getConnection();
            
            PreparedStatement st1 = cn.prepareStatement(sql);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                Regata r = new Regata();
                r.setId(rs.getInt(1));
                r.setClas(rs.getString(2));
                r.setRace(rs.getInt(3));
                r.setScheduledDate(rs.getDate(4));
                r.setRealDate(rs.getDate(5));
                r.setEntries(rs.getInt(6));
                r.setArea(rs.getString(7));
                BD.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public ArrayList<Regata> getBD(){
        return BD;
    }
    
}
