package tasks.scheduler;

import tasks.util.B2WScheduleItem;

import java.util.Date;
import java.util.List;

public class B2WScheduleView {
    // === General Properties
    private String name;
    private String businessUnit;
    private String notes;
    private List<B2WScheduleItem> itemList;
    private String resourceGrouping;
    private String secondaryGrouping;
    private String[][] filters;
    private List<String> roles;
    private List<String> users;

    private Date startDate;
    private int duration;
    private String quickSearch;

    // === Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDuration(int duration) {
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

    public void setItemList(List<B2WScheduleItem> itemList) {
        this.itemList = itemList;
    }

    public void setResourceGrouping(String resourceGrouping) {
        this.resourceGrouping = resourceGrouping;
    }

    public void setSecondaryGrouping(String secondaryGrouping) {
        this.secondaryGrouping = secondaryGrouping;
    }

    public void setFilters(String[][] filters) {
        this.filters = filters;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    // === Getters
    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getDuration() {
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

    public List<B2WScheduleItem> getItemList() {
        return itemList;
    }

    public String getResourceGrouping() {
        return resourceGrouping;
    }

    public String getSecondaryGrouping() {
        return secondaryGrouping;
    }

    public String[][] getFilters() {
        return filters;
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getUsers() {
        return users;
    }

    // === Constructors
    public B2WScheduleView(String name) {
        setName(name);
        setStartDate(new Date());
        setDuration(7);
    }

    public B2WScheduleView(String name, Date startDate, int duration) {
        setName(name);
        setStartDate(startDate);
        setDuration(duration);
    }
}

