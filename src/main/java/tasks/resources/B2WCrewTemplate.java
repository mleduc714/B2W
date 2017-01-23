package tasks.resources;

import java.util.ArrayList;

public class B2WCrewTemplate implements Cloneable {
    // General Fields
    private String type;
    private String name;
    private String ID;
    private String workType;
    private String workSubType;
    private String businessUnit;
    private boolean inactive;
    private String notes;
    private String foreman;
    private ArrayList<String> employees = new ArrayList<>();
    private ArrayList<String> equipments = new ArrayList<>();
    private ArrayList<String> laborTypes = new ArrayList<>();
    private ArrayList<String> equipmentTypes = new ArrayList<>();
    private ArrayList<String> equipmentThatMoves = new ArrayList<>();

    // Transport Crew Fields
    private String transportType;

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
    public String getType() {
        return type;
    }
    public String getWorkSubType() {
        return workSubType;
    }
    public String getWorkType() {
        return workType;
    }
    public String getTransportType() {
        return transportType;
    }
    public ArrayList<String> getEquipmentThatMoves() {
        return equipmentThatMoves;
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
    public void setEquipmentThatMoves(ArrayList<String> equipmentThatMoves) {
        this.equipmentThatMoves = new ArrayList<>(equipmentThatMoves);
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
    public void setType(String type) {
        this.type = type;
    }
    public void setWorkSubType(String workSubType) {
        this.workSubType = workSubType;
    }
    public void setWorkType(String workType) {
        this.workType = workType;
    }
    public void setTransportType(String transportType) {
        this.transportType = transportType;
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
    public B2WCrewTemplate clone() {
        try {
            B2WCrewTemplate oReturn = (B2WCrewTemplate) super.clone();
            oReturn.setEmployees(this.getEmployees());
            oReturn.setEquipments(this.getEquipments());
            oReturn.setLaborTypes(this.getLaborTypes());
            oReturn.setEquipmentTypes(this.getEquipmentTypes());
            return oReturn;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
