package tasks.scheduler;

import tasks.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class B2WAssignment {
    private String assignmentType;
    private String resourceName;
    private String locationName;
    private String pickupLocation;
    private String dropoffLocation;
    private String transportationCrew;
    private String requestedBy;
    private String notes;
    private List<Date> dateList;
    private String startTime;
    private Date pickupDate;
    private Date dropoffDate;
    private String pickupTime;
    private String dropoffTime;
    private String duration;
    private B2WAssignment substitution;

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }
    public void setTransportationCrew(String transportationCrew) {
        this.transportationCrew = transportationCrew;
    }
    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
    public void setDropoffTime(String dropoffTime) {
        this.dropoffTime = dropoffTime;
    }
    public void makeSubstitution(String substitutionName) {
        this.substitution = new B2WAssignment(this);
        this.substitution.setResourceName(substitutionName);
        this.substitution.setAssignmentType(B2WAssignmentType.SUBSTITUTION_TYPE);
        this.assignmentType = B2WAssignmentType.SUBSTITUTED_TYPE;
    }

    public String getAssignmentType() {
        return assignmentType;
    }
    public String getResourceName() {
        return resourceName;
    }
    public String getLocationName() {
        return locationName;
    }
    public String getPickupLocation() {
        return pickupLocation;
    }
    public String getDropoffLocation() {
        return dropoffLocation;
    }
    public String getTransportationCrew() {
        return transportationCrew;
    }
    public String getRequestedBy() {
        return requestedBy;
    }
    public String getNotes() {
        return notes;
    }
    public List<Date> getDateList() {
        return dateList;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getDuration() {
        return duration;
    }
    public String getStartDate() { return StringUtils.getStringFromDateByPattern(dateList.get(0), "M/d/yyyy"); }
    public String getEndDate() { return StringUtils.getStringFromDateByPattern(dateList.get(1), "M/d/yyyy"); }
    public Date getPickupDate() { return pickupDate; }
    public Date getDropoffDate() {
        return dropoffDate;
    }
    public String getDropoffTime() {
        return dropoffTime;
    }
    public String getPickupTime() {
        return pickupTime;
    }
    public B2WAssignment getSubstitution() {
        return substitution;
    }

    public B2WAssignment(String assignmentType, String resourceName, String locationName, String requestedBy, String notes,
                         List<Date> dateList, String startTime, String duration) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.locationName = locationName;
        this.requestedBy = requestedBy;
        this.notes = notes;
        this.dateList = dateList;
        this.startTime = startTime;
        this.duration = duration;
    }

    public B2WAssignment(String assignmentType, String resourceName, String locationName, String requestedBy, String notes,
                         String startDate, String endDate, String startTime, String duration) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.locationName = locationName;
        this.requestedBy = requestedBy;
        this.notes = notes;

        Date dStartDate = StringUtils.getDateFromStringWithPattern(startDate, "M/d/yyyy");
        Date dEndDate = StringUtils.getDateFromStringWithPattern(endDate, "M/d/yyyy");
        dateList = new ArrayList<Date>();
        dateList.add(dStartDate);
        dateList.add(dEndDate);
        this.startTime = startTime;
        this.duration = duration;
    }

    public B2WAssignment(String assignmentType, String resourceName, String pickupLocation, String dropoffLocation,
                  Date pickupDate, String pickupTime, Date dropoffDate, String dropoffTime,
                  String requestedBy, String notes, String transportationCrew) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.dropoffDate = dropoffDate;
        this.dropoffTime = dropoffTime;
        this.requestedBy = requestedBy;
        this.notes = notes;
        this.transportationCrew = transportationCrew;
    }

    B2WAssignment(String assignmentType, String resourceName, String pickupLocation, String dropoffLocation,
                  Date pickupDate, String pickupTime, String duration,
                  String requestedBy, String notes, String transportationCrew) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.duration = duration;
        this.requestedBy = requestedBy;
        this.notes = notes;
        this.transportationCrew = transportationCrew;
    }

    public B2WAssignment(B2WAssignment assignment) {
        this.assignmentType = assignment.getAssignmentType();
        this.resourceName = assignment.getResourceName();
        this.locationName = assignment.getLocationName();
        this.dropoffLocation = assignment.getDropoffLocation();
        this.requestedBy = assignment.getRequestedBy();
        this.notes = assignment.getNotes();
        this.dateList = new ArrayList<Date>(assignment.getDateList());
        this.startTime = assignment.getStartTime();
        this.pickupDate = assignment.getPickupDate();
        this.dropoffDate = assignment.getDropoffDate();
        this.pickupTime = assignment.getPickupTime();
        this.dropoffTime = assignment.getDropoffTime();
        this.duration = assignment.getDuration();
    }
}