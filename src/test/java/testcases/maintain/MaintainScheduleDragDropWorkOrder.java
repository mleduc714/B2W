package testcases.maintain;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.dialogs.B2WAddMaintenanceReqToWorkOrder;
import tasks.dialogs.B2WCompleteWorkOrder;
import tasks.maintain.B2WMaintainDashboardTasks;
import tasks.maintain.B2WMaintainRequestTasks;
import tasks.maintain.B2WMaintainTasks;
import tasks.maintain.B2WWorkOrdersTasks;

public class MaintainScheduleDragDropWorkOrder extends B2WTestCase {
	
	B2WNavigationTasks b2wNav = new B2WNavigationTasks();
	B2WMaintainTasks b2wMain = new B2WMaintainTasks();
	B2WMaintainDashboardTasks b2wDash = new B2WMaintainDashboardTasks();
	B2WMaintainRequestTasks b2wRequests = new B2WMaintainRequestTasks();
	B2WAddMaintenanceReqToWorkOrder addToWO = new B2WAddMaintenanceReqToWorkOrder();
	B2WWorkOrdersTasks b2wWOTasks = new B2WWorkOrdersTasks();
	B2WCompleteWorkOrder b2wComplete = new B2WCompleteWorkOrder();

	@Override
	public void testSetUp() throws Throwable {
		super.testSetUp();
	}

	@Override
	public void testTearDown() throws Throwable {
		super.testTearDown();
	}

	@Override
	public String getCategory() {
		return null;
	}

	@Override
	public String getAuthor() {
		return "mleduc";
	}

	@Override
	public String getTestDescription() {
		return "Drag Drop To Schedule";
	}

	@Override
	public boolean isSupported() {
		return true;
	}

	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		BrowserUtils.getDriver().navigate().to(getEnvProperty("deploy") + "Maintenance/Dashboard.aspx");
		// check for unscheduled work orders
		if (b2wDash.getUnscheduledWorkOrders() > 0){
			logCompare(true, b2wDash.openUnscheduledWorkOrders(), "Open Unscheduled work orders");
		}
		
	}

}
