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



    public String getCommittee() {
        return Committee;
    }

    public String getRaceStatus() {
        return RaceStatus;
    }

    public String getSignal() {
        return Signal;
    }

    public String getTime() {
        return Time;
    }

    public String getScheduledTime() {
        return ScheduledTime;
    }

    public String getStartingTime() {
        return StartingTime;
    }

    public int getBoatsStarted() {
        return BoatsStarted;
    }

    public String getPreparatorySignal() {
        return PreparatorySignal;
    }

    public int getOCS_DSQ() {
        return OCS_DSQ;
    }

    public int getAP() {
        return AP;
    }

    public int getGR() {
        return GR;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public String getRaceTime() {
        return RaceTime;
    }

    public int getBoatsFinished() {
        return BoatsFinished;
    }

    public String getLastSignal() {
        return LastSignal;
    }

    public String getLastSignalTime() {
        return LastSignalTime;
    }

    public String getResults() {
        return Results;
    }

    public String getCourse() {
        return Course;
    }

    public float getDistance1stLeg() {
        return Distance1stLeg;
    }

    public int getBearing1stLeg() {
        return Bearing1stLeg;
    }

    public String getLegChanges() {
        return LegChanges;
    }

    public int getWindDir() {
        return WindDir;
    }

    public int getWindSpeed() {
        return WindSpeed;
    }

    public int getWindDir25() {
        return WindDir25;
    }

    public int getWindSpeed25() {
        return WindSpeed25;
    }

    public int getWindDir50() {
        return WindDir50;
    }

    public int getWindSpeed50() {
        return WindSpeed50;
    }

    public int getWindDir75() {
        return WindDir75;
    }

    public int getWindSpeed75() {
        return WindSpeed75;
    }

    public int getWindDir100() {
        return WindDir100;
    }

    public int getWindSpeed100() {
        return WindSpeed100;
    }

    public void setCommittee(String Committee) {
        this.Committee = Committee;
    }

    public void setRaceStatus(String RaceStatus) {
        this.RaceStatus = RaceStatus;
    }

    public void setSignal(String Signal) {
        this.Signal = Signal;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setScheduledTime(String ScheduledTime) {
        this.ScheduledTime = ScheduledTime;
    }

    public void setStartingTime(String StartingTime) {
        this.StartingTime = StartingTime;
    }

    public void setBoatsStarted(int BoatsStarted) {
        this.BoatsStarted = BoatsStarted;
    }

    public void setPreparatorySignal(String PreparatorySignal) {
        this.PreparatorySignal = PreparatorySignal;
    }

    public void setOCS_DSQ(int OCS_DSQ) {
        this.OCS_DSQ = OCS_DSQ;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public void setGR(int GR) {
        this.GR = GR;
    }

    public void setFinishTime(String FinishTime) {
        this.FinishTime = FinishTime;
    }

    public void setRaceTime(String RaceTime) {
        this.RaceTime = RaceTime;
    }

    public void setBoatsFinished(int BoatsFinished) {
        this.BoatsFinished = BoatsFinished;
    }

    public void setLastSignal(String LastSignal) {
        this.LastSignal = LastSignal;
    }

    public void setLastSignalTime(String LastSignalTime) {
        this.LastSignalTime = LastSignalTime;
    }

    public void setResults(String Results) {
        this.Results = Results;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public void setDistance1stLeg(float Distance1stLeg) {
        this.Distance1stLeg = Distance1stLeg;
    }

    public void setBearing1stLeg(int Bearing1stLeg) {
        this.Bearing1stLeg = Bearing1stLeg;
    }

    public void setLegChanges(String LegChanges) {
        this.LegChanges = LegChanges;
    }

    public void setWindDir(int WindDir) {
        this.WindDir = WindDir;
    }

    public void setWindSpeed(int WindSpeed) {
        this.WindSpeed = WindSpeed;
    }

    public void setWindDir25(int WindDir25) {
        this.WindDir25 = WindDir25;
    }

    public void setWindSpeed25(int WindSpeed25) {
        this.WindSpeed25 = WindSpeed25;
    }

    public void setWindDir50(int WindDir50) {
        this.WindDir50 = WindDir50;
    }

    public void setWindSpeed50(int WindSpeed50) {
        this.WindSpeed50 = WindSpeed50;
    }

    public void setWindDir75(int WindDir75) {
        this.WindDir75 = WindDir75;
    }

    public void setWindSpeed75(int WindSpeed75) {
        this.WindSpeed75 = WindSpeed75;
    }

    public void setWindDir100(int WindDir100) {
        this.WindDir100 = WindDir100;
    }

    public void setWindSpeed100(int WindSpeed100) {
        this.WindSpeed100 = WindSpeed100;
    }
    
    
   
    
}
