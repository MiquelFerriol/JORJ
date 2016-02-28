/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Miquel Ferriol
 */
public class Regata {
    private int id;
    private String Class;
    private int Race;
    private String ScheduledDate;
    private String RealDate;
    private int Entries;
    private String Area;
    private String Committee;
    private String RaceStatus;
    private String Signal;
    private String Time;
    private String ScheduledTime;
    private String StartingTime;
    private int BoatsStarted;
    private String PreparatorySignal;
    private int OCS_DSQ;
    private int AP;
    private int GR;
    private String FinishTime;
    private String RaceTime;
    private int BoatsFinished;
    private String LastSignal;
    private String LastSignalTime;
    private String Results;
    private String Course;
    private float Distance1stLeg;
    private int Bearing1stLeg;
    private String LegChanges;
    private int WindDir;
    private int WindSpeed;
    private int WindDir25;
    private int WindSpeed25;
    private int WindDir50;
    private int WindSpeed50;
    private int WindDir75;
    private int WindSpeed75;
    private int WindDir100;
    private int WindSpeed100;

    public Regata(){
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Class
     */
    public String getClas() {
        return Class;
    }

    /**
     * @param Class the Class to set
     */
    public void setClas(String Class) {
        this.Class = Class;
    }

    /**
     * @return the Race
     */
    public int getRace() {
        return Race;
    }

    /**
     * @param Race the Race to set
     */
    public void setRace(int Race) {
        this.Race = Race;
    }

    /**
     * @return the ScheduledDate
     */
    public String getScheduledDate() {
        return ScheduledDate;
    }

    /**
     * @param ScheduledDate the ScheduledDate to set
     */
    public void setScheduledDate(String ScheduledDate) {
        this.ScheduledDate = ScheduledDate;
    }

    /**
     * @return the RealDate
     */
    public String getRealDate() {
        return RealDate;
    }

    /**
     * @param RealDate the RealDate to set
     */
    public void setRealDate(String RealDate) {
        
        this.RealDate = RealDate;
    }

    /**
     * @return the Entries
     */
    public int getEntries() {
        return Entries;
    }

    /**
     * @param Entries the Entries to set
     */
    public void setEntries(int Entries) {
        this.Entries = Entries;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }
    
    
   
    
}
