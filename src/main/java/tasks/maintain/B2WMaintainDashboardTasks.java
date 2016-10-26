package tasks.maintain;

public abstract class B2WMaintainDashboardTasks extends B2WMaintainTasks {
	
	public abstract String getUserWelcome();
	public abstract String getUnassignedRepairRequests();
	public abstract String getUnscheduledPM();
	public abstract String getUnscheduledWorkOrders();
	public abstract String getPastDueWorkOrders();
	public abstract String getPendingTimeCards();
	public abstract String getWorkOrdersHeader();
	public abstract boolean selectWorkOrderByLocation(String sLocation);
	public abstract boolean selectWorkOrderByAssigned(String sAssigned);
	public abstract boolean selectWorkOrderByEquipment(String sEquipment);
	public abstract boolean selectDailyTimeCardByEmployeeName(String sName);
	public abstract boolean clickViewWorkOrdersLink();
	

}
