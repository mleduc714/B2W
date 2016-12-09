package tasks.scheduler;

import java.util.Date;
import java.util.List;

public class B2WAssignment {
    private static String assignmentType;
    private static String resourceName;
    private static String locationName;
    private static String pickupLocation;
    private static String dropoffLocation;
    private static String transportationCrew;
    private static String requestedBy;
    private static String notes;
    private static List<Date> dateList;
    private static String startTime;
    private static Date pickupDate;
    private static Date dropoffDate;
    private static String pickupTime;
    private static String dropoffTime;
    private static String duration;

    public static void setAssignmentType(String assignmentType) {
        B2WAssignment.assignmentType = assignmentType;
    }
    public static void setResourceName(String resourceName) {
        B2WAssignment.resourceName = resourceName;
    }
    public static void setLocationName(String locationName) {
        B2WAssignment.locationName = locationName;
    }
    public static void setPickupLocation(String pickupLocation) {
        B2WAssignment.pickupLocation = pickupLocation;
    }
    public static void setDropoffLocation(String dropoffLocation) {
        B2WAssignment.dropoffLocation = dropoffLocation;
    }
    public static void setTransportationCrew(String transportationCrew) {
        B2WAssignment.transportationCrew = transportationCrew;
    }
    public static void setRequestedBy(String requestedBy) {
        B2WAssignment.requestedBy = requestedBy;
    }
    public static void setNotes(String notes) {
        B2WAssignment.notes = notes;
    }
    public static void setDateList(List<Date> dateList) {
        B2WAssignment.dateList = dateList;
    }
    public static void setStartTime(String startTime) {
        B2WAssignment.startTime = startTime;
    }
    public static void setDuration(String duration) {
        B2WAssignment.duration = duration;
    }

    public static String getAssignmentType() {
        return assignmentType;
    }
    public static String getResourceName() {
        return resourceName;
    }
    public static String getLocationName() {
        return locationName;
    }
    public static String getPickupLocation() {
        return pickupLocation;
    }
    public static String getDropoffLocation() {
        return dropoffLocation;
    }
    public static String getTransportationCrew() {
        return transportationCrew;
    }
    public static String getRequestedBy() {
        return requestedBy;
    }
    public static String getNotes() {
        return notes;
    }
    public static List<Date> getDateList() {
        return dateList;
    }
    public static String getStartTime() {
        return startTime;
    }
    public static String getDuration() {
        return duration;
    }

    B2WAssignment(String assignmentType, String resourceName, String locationName, String requestedBy, String notes,
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

    B2WAssignment(String assignmentType, String resourceName, String pickupLocation, String dropoffLocation,
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
}



