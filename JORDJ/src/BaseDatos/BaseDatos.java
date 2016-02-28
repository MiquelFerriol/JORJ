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
    private Connection cn;
    ConectaBD db;
    
    public BaseDatos(){
        db = new ConectaBD();
    }
    
    public void initBD(){
        BD = new ArrayList<>();
        System.out.println("Conectados");
        String sql = "select * from racestatus";
        try {
            cn = db.getConnection();
            PreparedStatement st1 = cn.prepareStatement(sql);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                Regata r = new Regata();
                r.setId(rs.getInt(1));
                r.setClas(rs.getString(2));
                r.setRace(rs.getInt(3));
                r.setScheduledDate(rs.getString(4));
                r.setRealDate(rs.getString(5));
                r.setEntries(rs.getInt(6));
                r.setArea(rs.getString(7));
                r.setCommittee(rs.getString(8));
                r.setRaceStatus(rs.getString(9));
                r.setSignal(rs.getString(10));
                r.setTime(rs.getString(11));
                r.setScheduledTime(rs.getString(12));
                r.setStartingTime(rs.getString(13));
                r.setBoatsStarted(rs.getInt(14));
                r.setPreparatorySignal(rs.getString(15));
                r.setOCS_DSQ(rs.getInt(16));
                r.setAP(rs.getInt(17));
                r.setGR(rs.getInt(18));
                r.setFinishTime(rs.getString(19));
                r.setRaceTime(rs.getString(20));
                r.setBoatsFinished(rs.getInt(21));
                r.setLastSignal(rs.getString(22));
                r.setLastSignalTime(rs.getString(23));
                r.setResults(rs.getString(24));
                r.setCourse(rs.getString(25));
                r.setDistance1stLeg(rs.getFloat(26));
                r.setBearing1stLeg(rs.getInt(27));
                r.setLegChanges(rs.getString(28));
                r.setWindDir(rs.getInt(29));
                r.setWindSpeed(rs.getInt(30));
                r.setWindDir25(rs.getInt(31));
                r.setWindSpeed25(rs.getInt(32));
                r.setWindDir50(rs.getInt(33));
                r.setWindSpeed50(rs.getInt(34));
                r.setWindDir75(rs.getInt(35));
                r.setWindSpeed75(rs.getInt(36));
                r.setWindDir100(rs.getInt(37));
                r.setWindSpeed100(rs.getInt(38));
                
                BD.add(r);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public ArrayList<Regata> getBD(){
        return BD;
    }
    
    public void Update(int id, String col, Object value){
        cn = db.getConnection();
        try {
            String sql = "UPDATE racestatus " + "SET " + col + " = '" + value + "' WHERE id = " + id + ";";
            System.out.println(sql);
            PreparedStatement st = cn.prepareStatement(sql);
            st.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            try {
            String sql = "UPDATE racestatus " + "SET " + col + " = -1 WHERE id = " + id + ";";
            System.out.println(sql);
            PreparedStatement st = cn.prepareStatement(sql);
            st.executeUpdate();
            cn.close();
            
            } catch (SQLException q) {
            
                System.out.println("Error: " + q.getMessage());
            }
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
    
}
