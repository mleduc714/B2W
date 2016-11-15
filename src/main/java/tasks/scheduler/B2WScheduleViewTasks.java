package tasks.scheduler;

import org.openqa.selenium.WebElement;

import appobjects.scheduler.B2WScheduleAssignments;
import appobjects.scheduler.B2WScheduleView;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public class B2WScheduleViewTasks {
	
	public boolean clickOnCrews(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrews());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crews by Assignment Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnCrewsByAssignmentLocation(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsByAssignmentLocation());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crews by Assignment Location");
			}
		}
		return bReturn;
	}
	
	
	public boolean clickOnCrewsByWorkSubtype(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsByWorkSubtype());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crews by Work Subtype");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnCrewsByWorkType(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsByWorkType());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crews by Work Type");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnCrewsByWorkTypeAndWorkSubtype(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsByWorkTypeAndSubtype());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Crews by Work Type & Subtype");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEmployeeSchedule(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEmployeeSchedule());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Employee Schedule");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEmployeesByAssignmentLocation(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEmployeesByAssignmentLocation());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Employees by Assignment Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEmployeesByBusinessUnit(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEmployeesByBusinessUnit());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Employees by Assignment Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEmployeesByLaborType(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEmployeesByLaborType());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Employees by Labor Type");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByCategory(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByCategory());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Category");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByCategoryAndLocation(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByCategoryAndLocation());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Category & Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByCategoryAndType(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByCategoryAndType());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Category & Type");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByLocation(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByLocation());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByLocationAndCategory(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByLocationAndCategory());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Location & Category");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByLocationAndType(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByLocationAndType());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Location & Type");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByType(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByType());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Type");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByTypeAndCategory(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByTypeAndCategory());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Type & Category");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentGroupedByTypeAndLocation(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getEquipmentGroupedByTypeAndLocation());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Grouped by Type & Location");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule1(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule1());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 1");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule2(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule2());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 2");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule3(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule3());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 3");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule4(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule4());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 4");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule5(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule5());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 5");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule6(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule6());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 6");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule7(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule7());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 7");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule8(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule8());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 8");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnEquipmentSchedule9(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getCrewsEquipmentSchedule9());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Equipment Schedule 9");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentAtRt93Exit18(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentAtRT93Exit18());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment at RT93 Exit 18");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentDownForMaintenance(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentDownForMaintenance());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment Down For Maintenance");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentScheduledForMaintenance(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentScheduledForMaintenance());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment Scheduled for Maintenance");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentThatMovesOtherEquipment(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentThatMovesOtherEquipment());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment that Moves Other Equipment");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentThatRequiresMoves(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentThatRequiresMoves());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment that Requires Moves");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentWithGPS(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentWithGPS());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment with GPS");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByEquipmentWithMemoEvents(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByEquipmentWithMemoEvents());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Equipment With Memo Events");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByOwnedEquipmentAtEqYardOrHQ(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByOwnedEquipmentAtEqYardOrHQ());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Owned Equipment at Eq. Yard or HQ");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByRentedAndSubcontractedEquipment(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByRentedAndSubcontractedEquipment());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Rented & Subcontracted Equipment");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredByRentedCranes(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredByRentedCranes());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Rented Cranes");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredBySelfMobileEquipment(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredBySelfMobileEquipment());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Self Mobile Equipment");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredBySitework(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredBySitework());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Sitework");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnFilteredBySubcontractedTriAxles(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getFilteredBySubcontractedTriAxles());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Filtered by Subcontracted Tri-Axles");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnJobSites(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getJobSites());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Job Sites");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnJobSitesPlaces(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getJobSitesPlaces());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Job Sites - Places");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnMortsInactiveEquipment(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getMortsInactiveEquipment());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Mort's <Inactive> Equipment");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnMortsActiveEquipment(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getMortsActiveEquipment());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Mort's Active Equipment");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnNortheastDivisionAndPaversAndGraders(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getNortheastDivisionAndPaversAndGraders());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Northeast Division & Pavers & 'Graders'");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnNorthwestDivisionPaversGraders(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getNorthwestDivisionPaversGraders());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Northwest Division Pavers-Graders");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnPlaces(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getPlaces());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Places");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnSouthernDivisionSiteworkSpecial(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getSouthernDivisionSiteworkSpecial());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Southern Division Sitework \"Special\"");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnSouthwestDivisionPaversGraders(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getSouthwestDivisionPaversGraders());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Southwest Division Pavers--Graders");
			}
		}
		return bReturn;
	}
	
	public boolean clickOnRandomCharacters(){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WScheduleView.getRandomCharacters());
		if(el != null){
			if (WebElementUtils.clickElement(el)) {
				bReturn = new TaskUtils().waitForProductPanel("Z!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~“”‘’!\"#$%&'()*+-./:;<=>?@[\\]^_`{|}~“”‘’");
			}
		}
		return bReturn;
	}
	
	
	public boolean openScheduleViewList(){
            WebElement el = WebElementUtils.findElement(B2WScheduleAssignments.getScheduleProductPageIcon());
            if (el != null) {
                if (WebElementUtils.clickElement(el)) {
                    WebElement panel = WebElementUtils.waitAndFindDisplayedElement(B2WScheduleAssignments.getScheduleViewNavigateMenu());
                   return WebElementUtils.switchToFrame(B2WScheduleAssignments.getScheduleViewNavigateMenu(), 1);
                    
                }
            }
            return false;
	}

}
