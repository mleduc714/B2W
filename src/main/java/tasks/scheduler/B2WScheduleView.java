package tasks.scheduler;

import tasks.util.B2WScheduleItem;
import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class B2WScheduleView implements Cloneable {
    // === General Properties
    private String name;
    private String businessUnit;
    private String notes;
    private ArrayList<B2WScheduleItem> scheduleItems;
    private String resourceGrouping;
    private String secondaryGrouping;
    private ArrayList<String[]> filters;
    private ArrayList<String> roles;
    private ArrayList<String> users;

    private Date startDate;
    private String sStartDate;
    private String duration;
    private String quickSearch;

    // === Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        this.sStartDate = StringUtils.getStringFromDateByPattern(startDate, "M/d/yyyy");
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setQuickSearch(String quickSearch) {
        this.quickSearch = quickSearch;
    }
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setScheduleItems(ArrayList<B2WScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }
    public void setResourceGrouping(String resourceGrouping) {
        this.resourceGrouping = resourceGrouping;
    }
    public void setSecondaryGrouping(String secondaryGrouping) {
        this.secondaryGrouping = secondaryGrouping;
    }
    public void setFilters(ArrayList<String[]> filters) {
        this.filters = filters;
    }
    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    // === Getters
    public String getName() {
        return name;
    }
    public Date getStartDate() {
        return startDate;
    }
    public String getStartDateAsSting() { return sStartDate; }
    public String getDuration() {
        return duration;
    }
    public String getQuickSearch() {
        return quickSearch;
    }
    public String getBusinessUnit() {
        return businessUnit;
    }
    public String getNotes() {
        return notes;
    }
    public String getResourceGrouping() {
        return resourceGrouping;
    }
    public String getSecondaryGrouping() {
        return secondaryGrouping;
    }
    public ArrayList<String[]> getFilters() {
        return filters;
    }
    public ArrayList<String> getRoles() {
        return roles;
    }
    public ArrayList<String> getUsers() {
        return users;
    }
    public ArrayList<B2WScheduleItem> getScheduleItems() {
        return scheduleItems;
    }

    // === Constructors
    public B2WScheduleView(String name, String businessUnit, String notes, ArrayList<B2WScheduleItem> scheduleItems,
                           String resourceGrouping, String secondaryGrouping, ArrayList<String[]> filters,
                           ArrayList<String> roles, ArrayList<String> users) {

        this.name = name;
        this.businessUnit = businessUnit;
        this.notes = notes;
        this.scheduleItems = new ArrayList<B2WScheduleItem>(scheduleItems);
        this.resourceGrouping = resourceGrouping;
        this.secondaryGrouping = secondaryGrouping;
        this.filters = new ArrayList<String[]>(filters);
        this.roles = new ArrayList<String>(roles);
        this.users = new ArrayList<String>(users);
    }

    public B2WScheduleView clone() throws CloneNotSupportedException {
        return (B2WScheduleView)super.clone();
    }
}

