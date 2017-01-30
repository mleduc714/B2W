package tasks.maintain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.maintain.B2WMaintain;
import tasks.WebElementUtils;
import tasks.resources.B2WKendoTasks;
import tasks.util.TaskUtils;

public class B2WInventoryTasks extends B2WKendoTasks {
	
	String sInventoryToolTip = "div#Inventory-tooltip-body";
	String sWorkOrder = "span.work-Order";
	
	public boolean expandPart(String sPart){
		boolean bReturn = false;
		WebElement row = getRow(sPart);
		WebElement plus = WebElementUtils.getChildElement(row,(B2WMaintain.getKendoIconPlus()));
		if (plus != null){
			bReturn = WebElementUtils.clickElement(plus);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
				
		return bReturn;
	}
	
	public boolean collapsePart(String sPart){
		boolean bReturn = false;
		WebElement row = getRow(sPart);
		WebElement plus = WebElementUtils.getChildElement(row,(B2WMaintain.getKendoIconMinus()));
		if (plus != null){
			bReturn = WebElementUtils.clickElement(plus);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
				
		return bReturn;
	}
	public String getPartBuyer(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 2);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartCategory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 3);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartSubCategory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 4);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartCurrentInventory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 5);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartOnOrderInventory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 6);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartAllocatedInventory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 7);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartMinimumInventory(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 8);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}
	public String getPartNetPosition(String sPart){
		String sText = "";
		WebElement el = getRowColumn(sPart, 9);
		if (el != null){
			sText = el.getText();
		}
		return sText;
	}

	public ArrayList<String> getPartLocations() {
		return getInventoryDetails(0);
	}

	public ArrayList<String> getPartBins() {
		return getInventoryDetails(1);
	}
	public ArrayList<String> getCurrentInventory(){
		return getInventoryDetails(2);
		}
	public boolean editInventory(int iItem){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainInventoryDetails());
		if (el != null){
			WebElement edit = WebElementUtils.getChildElements(el, B2WMaintain.getKendoEditButton()).get(iItem);
			bReturn = WebElementUtils.clickElement(edit);
		}
		return bReturn;
		
	}
	public boolean deleteInventory(int iItem){
		boolean bReturn = false;
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainInventoryDetails());
		if (el != null){
			WebElement delete = WebElementUtils.getChildElements(el, B2WMaintain.getKendoDeleteButton()).get(iItem);
			bReturn = WebElementUtils.clickElement(delete);
		}
		return bReturn;
		
	}
	public boolean clickOnPart(String sPart){
		boolean bReturn = false;
		WebElement row = getRowColumn(sPart,1);
		if (row != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(row, By.tagName("a")));
		}
		return bReturn;
	}
	public boolean clickOnAllocatedInventory(String sPart){
		boolean bReturn = false;
		WebElement el = getRow(sPart);
		if (el != null){
			WebElement e = WebElementUtils.getChildElement(el, B2WMaintain.getMaintainInventoryAlocatedInventory());
			bReturn = WebElementUtils.clickElement(e);
		}
		return bReturn;
	}
	public String getWorkOrderFromAllocatedInventory(){
		String sText = "";
		WebElement tooltip = WebElementUtils.waitAndFindDisplayedElement(By.cssSelector(this.sInventoryToolTip));
		TaskUtils.sleep(500);
		WebElement workorder = WebElementUtils.getChildElement(tooltip, By.cssSelector(this.sWorkOrder));
		if (workorder != null){
			 sText = WebElementUtils.getChildElement(workorder, By.tagName("a")).getText();
		}
		return sText;
	}
	public boolean clickOnWorkOrderAllocatedInventory(){
		boolean bReturn = false;
		WebElement tooltip = WebElementUtils.waitAndFindDisplayedElement(By.cssSelector(this.sInventoryToolTip));
		TaskUtils.sleep(500);
		WebElement workorder = WebElementUtils.getChildElement(tooltip, By.cssSelector(this.sWorkOrder));
		if (workorder != null){
			bReturn = WebElementUtils.clickElement(WebElementUtils.getChildElement(workorder, By.tagName("a")));
		}
		return bReturn;
	}
	
	private WebElement getRow(String sPart) {
		WebElement row = null;
		List<WebElement> rows = WebElementUtils.findElements(By.cssSelector(".k-master-row"));
		Iterator<WebElement> iter = rows.iterator();
		while (iter.hasNext()){
			WebElement el = iter.next();
			List<WebElement> gridcells = WebElementUtils.getChildElements(el, By.tagName("td"));
			if (gridcells.get(1).getText().contains(sPart)){
				row = el;
				break;
			}
			
		}
		
		return row;
		
	}

	private WebElement getRowColumn(String sPart, int iCol) {
		WebElement column = null;
		WebElement el = getRow(sPart);
		if (el != null) {
			List<WebElement> gridcells = WebElementUtils.getChildElements(el, By.tagName("td"));
			column = gridcells.get(iCol);
		}
		return column;
	}
	
	public boolean clickAddToInventory() {
		boolean bReturn = false;
		
		WebElement button = getButton("Add to Inventory");
		if (button != null){
			bReturn = WebElementUtils.clickElement(button);
		}
		return bReturn;
	}
	
	private ArrayList<String> getInventoryDetails(int iColumn){

		ArrayList<String> al = new ArrayList<String>();
		WebElement el = WebElementUtils.findElement(B2WMaintain.getMaintainInventoryDetails());
		if (el != null) {
			WebElement grid = WebElementUtils.getChildElement(el, B2WMaintain.getB2WMaintainGrid());
			if (grid != null) {
				List<WebElement> rows = WebElementUtils.getChildElements(grid, B2WMaintain.getB2WKendotrTag());

				if (rows.size() > 0) {
					for (WebElement td : rows) {
						List<WebElement> columns = WebElementUtils.getChildElements(td, By.tagName("td"));
						al.add(columns.get(iColumn).getText());
					}
				}
			}
		}
		return al;
	
	}
	
	
}
