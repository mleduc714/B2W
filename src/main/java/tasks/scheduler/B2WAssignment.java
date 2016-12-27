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
        this.dateList = new ArrayList<Date>(dateList);
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
        recalculateDatesByDuration();
        recalculateDatesByEndDate();
    }
    public void setDuration(String duration) {
        this.duration = duration;
        recalculateDatesByDuration();
    }
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
        recalculateDatesByEndDate();
    }
    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
        this.startTime = pickupTime;
        recalculateDatesByEndDate();
    }
    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
        recalculateDatesByEndDate();
    }
    public void setDropoffTime(String dropoffTime) {
        this.dropoffTime = dropoffTime;
        recalculateDatesByEndDate();
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
    public Date getEndDateAsDate() {
        return this.dateList.get(dateList.size() - 1);
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
       int days = calcDiffInDays(this.getStartDateAsDate(), moveDate);
        this.dateList.set(0, DateUtils.addDays(this.dateList.get(0), days));
        this.dateList.set(dateList.size() - 1, DateUtils.addDays(this.dateList.get(dateList.size() - 1), days));
    }
    public void resizeTo(String edge, Date resizeDate) {

        if (edge.toLowerCase().equals("right")) {
            int days = calcDiffInDays(this.getEndDateAsDate(), resizeDate);
            this.dateList.set(dateList.size() - 1, DateUtils.addDays(this.dateList.get(dateList.size() - 1), days));
        } else if (edge.toLowerCase().equals("left")) {
            int days = calcDiffInDays(this.getStartDateAsDate(), resizeDate);
            this.dateList.set(0, DateUtils.addDays(this.dateList.get(0), days));
        }
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

        //recalculateDatesByDuration();
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
        this.dateList = dateList;
        setPickupTime(pickupTime);
        this.startTime = pickupTime;
        setDropoffTime(dropoffTime);
        setRequestedBy(requestedBy);
        setNotes(notes);
        setTransportationCrew(transportationCrew);

        //recalculateDatesByEndDate();
    }

    public B2WAssignment(String assignmentType, String resourceName, String locationName, String notes,
                         List<Date> dateList) {

        this.assignmentType = assignmentType;
        this.resourceName = resourceName;
        this.locationName = locationName;
        this.requestedBy = "";
        this.notes = notes;
        this.dateList = new ArrayList<Date>(dateList);
        setStartTime("0:00 AM");
        setDuration("0:00 AM");
        //this.startTime = "0:00 AM";
        //this.duration = "0:00 AM";

        recalculateDatesByDuration();
        /*
        String tmpStartDate = this.getStartDate() + " " + getStartTime();
        Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(0, startDate);

        tmpStartDate = getEndDate() + " " + this.duration;
        Date endDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
        this.dateList.set(dateList.size()-1, endDate);
        */
    }

    public B2WAssignment clone() {
        try {
            //return (B2WAssignment) super.clone();

            B2WAssignment oClone = (B2WAssignment) super.clone();
            oClone.setDateList(new ArrayList<Date>(this.getDateList()));
            return oClone;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    private void recalculateDatesByDuration() {
        if ((getStartDate() != null) && (getStartTime() != null) && (getEndDate() != null) && (getDuration() != null)) {
            String tmpStartDate = this.getStartDate() + " " + this.getStartTime();
            Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
            this.dateList.set(0, startDate);
            Date endDate;
            if (duration.toLowerCase().contains(":")) {
                String sEndDate = this.getEndDate() + " " + this.getDuration();
                endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
            } else {
                String sEndDate = this.getEndDate() + " " + this.getStartTime();
                endDate = StringUtils.getDateFromStringWithPattern(sEndDate, "M/d/yyyy h:mm a");
                endDate = DateUtils.addHours(endDate, StringUtils.getHoursFromDuration(this.getDuration()));
                endDate = DateUtils.addMinutes(endDate, StringUtils.getMinutesFromDuration(this.getDuration()));
            }
            this.dateList.set(dateList.size() - 1, endDate);
        }
    }
    private void recalculateDatesByEndDate() {
        if ((this.getStartDate() != null) && (this.getStartTime() != null) && (this.getEndDate() != null) && (this.getDropoffTime() != null)) {
            //ToDo: Issue SCHED-3142 : Remove after fix
            String tmpStartDate = this.getStartDate() + " 0:00 AM";
            //String tmpStartDate = this.getStartDate() + " " + getStartTime();
            //===================================================================
            Date startDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
            this.dateList.set(0, startDate);

            //ToDo: Issue SCHED-3142 : Remove after fix
            tmpStartDate = this.getEndDate() + " 0:00 AM";
            //tmpStartDate = getEndDate() + " " + getDropoffTime();
            //===================================================================
            Date endDate = StringUtils.getDateFromStringWithPattern(tmpStartDate, "M/d/yyyy h:mm a");
            this.dateList.set(dateList.size() - 1, endDate);
        }
    }
    private int calcDiffInDays(Date startDate, Date endDate) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(startDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);

        return calendar.get(Calendar.DAY_OF_YEAR) - currentCalendar.get(Calendar.DAY_OF_YEAR);
    }
}