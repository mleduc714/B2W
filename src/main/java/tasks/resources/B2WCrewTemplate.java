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
    private ArrayList<String> employees;
    private ArrayList<String> equipments;
    private ArrayList<String> laborTypes;
    private ArrayList<String> equipmentTypes;

    public boolean isInactive() {
        return inactive;
    }
    public ArrayList<String> getEmployees() {
        return employees;
    }
    public ArrayList<String> getEquipments() {
        return equipments;
    }
    public ArrayList<String> getEquipmentTypes() {
        return equipmentTypes;
    }
    public ArrayList<String> getLaborTypes() {
        return laborTypes;
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
    public void setEmployees(ArrayList<String> employees) {
        this.employees = new ArrayList<>(employees);
    }
    public void setEquipments(ArrayList<String> equipments) {
        this.equipments = new ArrayList<>(equipments);
    }
    public void setEquipmentTypes(ArrayList<String> equipmentTypes) {
        this.equipmentTypes = new ArrayList<>(equipmentTypes);
    }
    public void setLaborTypes(ArrayList<String> laborTypes) {
        this.laborTypes = new ArrayList<>(laborTypes);
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

    public void addEmployeesMembers(ArrayList<String> crew) {
        this.employees.addAll(crew);
    }
    public void removeEmployeesMembers(ArrayList<String> crew) {
        this.employees.removeAll(crew);
    }

    public void addEquipmentsMembers(ArrayList<String> crew) {
        this.equipments.addAll(crew);
    }
    public void removeEquipmentsMembers(ArrayList<String> crew) {
        this.equipments.removeAll(crew);
    }

    public void addLaborTypesMembers(ArrayList<String> crew) {
        this.laborTypes.addAll(crew);
    }
    public void removeLaborTypesMembers(ArrayList<String> crew) {
        this.laborTypes.removeAll(crew);
    }

    public void addEquipmentTypesMembers(ArrayList<String> crew) {
        this.equipmentTypes.addAll(crew);
    }
    public void removeEquipmentTypesMembers(ArrayList<String> crew) {
        this.equipmentTypes.removeAll(crew);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        B2WCrewTemplate oReturn = (B2WCrewTemplate) super.clone();
        oReturn.setEmployees(this.getEmployees());
        oReturn.setEquipments(this.getEquipments());
        oReturn.setLaborTypes(this.getLaborTypes());
        oReturn.setEquipmentTypes(this.getEquipmentTypes());
        return oReturn;
    }
}
