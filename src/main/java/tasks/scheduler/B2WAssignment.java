package tasks.scheduler;

import org.apache.commons.lang3.time.DateUtils;
import tasks.util.StringUtils;

import java.util.*;

public class B2WAssignment implements Cloneable {
    private String assignmentType;
    private String resourceName;
    private String locationName;
    private String pickupLocationType;
    private String pickupLocation;
    private String dropoffLocationType;
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
    public void setPickupLocationType(String pickupLocationType) {
        this.pickupLocationType = pickupLocationType;
    }
    public void setDropoffLocationType(String dropoffLocationType) {
        this.dropoffLocationType = dropoffLocationType;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
        this.locationName = dropoffLocation;
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

    public String getAssignmentType() {
        return assignmentType;
    }
    public String getResourceName() {
        return resourceName;
    }
    public String getLocationName() {
        return locationName;
    }
    public String getPickupLocationType() {
        return pickupLocationType;
    }
    public String getPickupLocation() {
        return pickupLocation;
    }
    public String getDropoffLocationType() {
        return dropoffLocationType;
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
    public Date getStartDateAsDate() {
        return this.dateList.get(0);
    }
    public String getEndDate() { return StringUtils.getStringFromDateByPattern(dateList.get(dateList.size()-1), "M/d/yyyy"); }
    public String getPickupDate() { return StringUtils.getStringFromDateByPattern(dateList.get(0), "M/d/yyyy"); }
    public String getDropoffDate() { return StringUtils.getStringFromDateByPattern(dateList.get(dateList.size()-1), "M/d/yyyy"); }
    public String getDropoffTime() {
        return dropoffTime;
    }
    public String getPickupTime() {
        return pickupTime;
    }
    public B2WAssignment getSubstitution() {
        return substitution;
    }

    // Public Methods
    public void makeSubstitution(String substitutionName) {
        this.substitution = this.clone();
        this.substitution.setResourceName(substitutionName);
        this.substitution.setAssignmentType(B2WAssignmentType.SUBSTITUTION_TYPE);
        this.assignmentType = B2WAssignmentType.SUBSTITUTED_TYPE;
    }
    public void removeSubstitution()  {
        this.assignmentType = B2WAssignmentType.EMPLOYEE_TYPE;
        this.substitution = null;
    }

    public void moveTo(Date moveDate) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(this.getStartDateAsDate());
        currentCalendar.set(Calendar.HOUR, 0);
        currentCalendar.set(Calendar.MINUTE, 0);
        currentCalendar.set(Calendar.SECOND, 0);
        currentCalendar.set(Calendar.MILLISECOND, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(moveDate);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long diff = calendar.getTimeInMillis() - currentCalendar.getTimeInMillis();

        long days = diff / 1000 / 60 / 60 / 24;

        this.dateList.set(0, DateUtils.addDays(this.dateList.get(0), (int) days));
        this.dateList.set(dateList.size() - 1, DateUtils.addDays(this.dateList.get(dateList.size() - 1), (int) days));
    }

    // Constructors
    public B2WAssignment(String assignmentType, String resourceName, String locationName, String requestedBy, String notes,
                         List<Date> dateList, String startTime, String duration) {

        setAssignmentType(assignmentType);
        setResourceName(resourceName);
        setLocationName(locationName);
        setRequestedBy(requestedBy);
        setNotes(notes);
        setDateList(dateList);
        setStartTime(startTime);
        setDuration(duration);

        String tmpStartDate = this.getStartDate() + " " + getStartTime();
        Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(0, startDate);
        Date endDate;
        if (duration.toLowerCase().contains(":") ) {
            String sEndDate = getEndDate() + " " + duration;
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
        } else {
            String sEndDate = getEndDate() + " " + getStartTime();
            endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
            endDate = DateUtils.addHours(endDate, StringUtils.getHoursFromDuration(duration));
            endDate = DateUtils.addMinutes(endDate, StringUtils.getMinutesFromDuration(duration));
        }
        this.dateList.set(dateList.size()-1, endDate);
    }

    public B2WAssignment(String assignmentType, String resourceName, String pickupLocationType, String pickupLocation, Date pickupDate, String pickupTime,
                         String dropoffLocationType, String dropoffLocation, Date dropoffDate, String dropoffTime,
                         String requestedBy, String notes, String transportationCrew) {

        ArrayList<Date> dateList = new ArrayList<Date>();
        dateList.add(pickupDate);
        dateList.add(dropoffDate);

        setAssignmentType(assignmentType);
        setResourceName(resourceName);
        setPickupLocationType(pickupLocationType);
        setPickupLocation(pickupLocation);
        setDropoffLocationType(dropoffLocationType);
        setDropoffLocation(dropoffLocation);
        setLocationName(dropoffLocation);
        setDateList(dateList);
        setPickupTime(pickupTime);
        setStartTime(pickupTime);
        setDropoffTime(dropoffTime);
        setRequestedBy(requestedBy);
        setNotes(notes);
        setTransportationCrew(transportationCrew);

        //ToDo: Issue SCHED-3142 : Remove after fix
        String tmpStartDate = this.getStartDate() + " 0:00 AM";
        //String tmpStartDate = this.getStartDate() + " " + getStartTime();
        //===================================================================
        Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(0, startDate);

        //ToDo: Issue SCHED-3142 : Remove after fix
        tmpStartDate = getEndDate() + " 0:00 AM";
        //tmpStartDate = getEndDate() + " " + dropoffTime;
        //===================================================================
        Date endDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(dateList.size()-1, endDate);
    }

    public B2WAssignment(String assignmentType, String resourceName, String locationName, String notes,
                         List<Date> dateList) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.locationName = locationName;
        this.requestedBy = "";
        this.notes = notes;
        this.dateList = new ArrayList<Date>(dateList);
        this.startTime = "0:00 AM";
        this.duration = "0:00 AM";

        String tmpStartDate = this.getStartDate() + " " + getStartTime();
        Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(0, startDate);

        tmpStartDate = getEndDate() + " " + this.duration;
        Date endDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(dateList.size()-1, endDate);
    }

    public B2WAssignment clone() {
        try {
            return (B2WAssignment) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}