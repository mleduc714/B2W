package tasks.util;

public class B2WScheduleItem {

    private String ScheduleFormat;
    private String ResourceName;
    private boolean Assignments;
    private boolean Needs;
    private boolean Events;
    private boolean MoveAssignments;
    private boolean MoveOrders;
    private boolean Target;

    private String RL_EQUIPMENT = "Assignments;Needs;Events;Move Assignments;Move Orders";
    private String RL_EMPLOYEES = "Assignments;Needs;Events";

    private String LV_EQUIPMENT = "Assignments;Needs;Events;Move Assignments;Move Orders";
    private String LV_EMPLOYEES = "Assignments;Needs;Events";
    private String LV_JOBSITES = "Events";
    private String LV_PLACES = "Events";
    private String LV_PRODUCTIONCREWS = "Assignments;Needs;Target";

    private String CV_PRODUCTIONCREWS = "Assignments;Needs";
    private String CV_TRANSPORTATIONCREWS = "Assignments";
    private String CV_EQUIPMENT = "Assignments;Needs;Events;Move Assignments;Move Orders";
    private String CV_EMPLOYEES = "Assignments;Needs;Events";

    public B2WScheduleItem() {
        setAssignments(false);
        setNeeds(false);
        setEvents(false);
        setMoveAssignments(false);
        setMoveOrders(false);
        setTarget(false);
    }

    public String getResourceName() { return ResourceName; }

    public void setResourceName(String resourceName) {
        if (resourceName.equals("Equipment")) {
            setAssignments(true);
            setNeeds(true);
            setEvents(true);
            setMoveAssignments(true);
            setMoveOrders(true);
        } else if (resourceName.equals("Employees")) {
            setAssignments(true);
            setNeeds(true);
            setEvents(true);
        } else if (resourceName.equals("Job Sites")) {
            setEvents(true);
        } else if (resourceName.equals("Places")) {
            setEvents(true);
        } else if (resourceName.equals("Production Crews")) {
            setAssignments(true);
            setNeeds(true);
            if (getScheduleFormat().equals("Location View")) {
                setTarget(true);
            }
        }
        ResourceName = resourceName;
    }

    public boolean isAssignments() {
        return Assignments;
    }

    public void setAssignments(boolean assignments) {
        Assignments = assignments;
    }

    public boolean isNeeds() {
        return Needs;
    }

    public void setNeeds(boolean needs) {
        Needs = needs;
    }

    public boolean isEvents() {
        return Events;
    }

    public void setEvents(boolean events) {
        Events = events;
    }

    public boolean isMoveAssignments() {
        return MoveAssignments;
    }

    public void setMoveAssignments(boolean moveAssignments) {
        MoveAssignments = moveAssignments;
    }

    public boolean isMoveOrders() {
        return MoveOrders;
    }

    public void setMoveOrders(boolean moveOrders) {
        MoveOrders = moveOrders;
    }

    public boolean isTarget() {
        return Target;
    }

    public void setTarget(boolean target) {
        Target = target;
    }

    public String getScheduleFormat() {
        return ScheduleFormat;
    }

    public void setScheduleFormat(String scheduleFormat) {
        ScheduleFormat = scheduleFormat;
    }

    public boolean isItemAvailable(String sValue) {
        boolean bResult = false;
        if (getScheduleFormat().equals("Resource Listing")) {
            if (getResourceName().equals("Equipment")) { bResult = RL_EQUIPMENT.contains(sValue);
            } else if (getResourceName().equals("Employees")) { bResult = RL_EMPLOYEES.contains(sValue); }
        } else if (getScheduleFormat().equals("Location View")) {
            if (getResourceName().equals("Job Sites")) { bResult = LV_JOBSITES.contains(sValue);
            } else if (getResourceName().equals("Places")) { bResult = LV_PLACES.contains(sValue);
            } else if (getResourceName().equals("Production Crews")) { bResult = LV_PRODUCTIONCREWS.contains(sValue);
            } else if (getResourceName().equals("Equipment")) { bResult = LV_EQUIPMENT.contains(sValue);
            } else if (getResourceName().equals("Employees")) { bResult = LV_EMPLOYEES.contains(sValue);
            }
        } else if (getScheduleFormat().equals("Crew View ")) {
            if (getResourceName().equals("Production Crews")) { bResult = CV_PRODUCTIONCREWS.contains(sValue);
            } else if (getResourceName().equals("Transportation Crews")) { bResult = CV_TRANSPORTATIONCREWS.contains(sValue);
            } else if (getResourceName().equals("Equipment")) { bResult = CV_EQUIPMENT.contains(sValue);
            } else if (getResourceName().equals("Employees")) { bResult = CV_EMPLOYEES.contains(sValue);
            }
        }
        return  bResult;
    }
}
