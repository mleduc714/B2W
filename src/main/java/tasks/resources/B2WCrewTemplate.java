package tasks.resources;

import java.util.ArrayList;

public class B2WCrewTemplate implements Cloneable {
    public enum CrewType {ProductionCrew("Production Crew"), TransportCrew("Transport Crew");
        private String type;

        CrewType(String s) {
            this.type = s;
        }
    }

    private CrewType type;
    private String name;
    private String ID;
    private String workType;
    private String workSubType;
    private String businessUnit;
    private boolean inactive;
    private String notes;
    private String foreman;
    private ArrayList<String> crew;

    public boolean isInactive() {
        return inactive;
    }
    public ArrayList<String> getCrew() {
        return crew;
    }
    public String getBusinessUnit() {
        return businessUnit;
    }
    public String getForeman() {
        return foreman;
    }
    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getNotes() {
        return notes;
    }
    public CrewType getType() {
        return type;
    }
    public String getWorkSubType() {
        return workSubType;
    }
    public String getWorkType() {
        return workType;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    public void setCrew(ArrayList<String> crew) {
        this.crew = new ArrayList<>(crew);
    }
    public void setForeman(String foreman) {
        this.foreman = foreman;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setType(CrewType type) {
        this.type = type;
    }
    public void setWorkSubType(String workSubType) {
        this.workSubType = workSubType;
    }
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        B2WCrewTemplate oReturn = (B2WCrewTemplate) super.clone();
        oReturn.setCrew(this.getCrew());
        return oReturn;
    }
}
