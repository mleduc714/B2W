package tasks.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import appobjects.maintain.B2WMaintain;
import appobjects.resources.B2WEquipment;
import tasks.B2WKendo;
import tasks.WebElementUtils;
import tasks.util.TaskUtils;

public abstract class B2WKendoDialog extends B2WKendo {

	Logger log = Logger.getLogger(B2WKendoDialog.class);

	private int getRandomNumber(int iSize) {
		Random rand = new Random();
		int randnumber = rand.nextInt(iSize);
		return randnumber;
	}

	public List<WebElement> getListofElementsFromGrid(WebElement grid) {
		return WebElementUtils.getChildElements(grid, By.tagName("tr"));
	}

	public WebElement getItemFromAddItemDialog(String sText) {
		WebElement item = null;
		WebElement dialog = getDisplayedWindow();
		List<WebElement> items = WebElementUtils.getChildElements(dialog, By.tagName("p"));
		Iterator<WebElement> iterB = items.iterator();
		while (iterB.hasNext()) {
			WebElement temp = iterB.next();
			if (temp.getText().startsWith(sText)) {
				item = temp;
			}
		}
		return item;
	}

	protected boolean clickSave() {

		boolean bReturn = false;
		WebElement savebutton = null;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null) {
			savebutton = WebElementUtils.getChildElement(window, B2WEquipment.getKendoLargeSaveButton());
			if (savebutton != null){
				bReturn = WebElementUtils.clickElement(savebutton);
				bReturn &= WebElementUtils.waitForElementInvisible(window);
				waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
			}else{
				log.debug("Could not find save button");
			}
		}
		return bReturn;

	}

	public boolean clickDone() {
		boolean bReturn = false;
		WebElement el = WebElementUtils.waitAndFindDisplayedElement(B2WMaintain.getKendoLargeDoneButton());
		if (el != null){
			bReturn =WebElementUtils.clickElement(el);
			bReturn &= WebElementUtils.waitForElementInvisible(el);
		}
		return bReturn;
	}
	
	public WebElement getDisplayedWindow() {
		WebElement window = null;
		List<WebElement> windows = WebElementUtils.findElements(B2WMaintain.getKendoWindow());
		Iterator<WebElement> iter = windows.iterator();
		while (iter.hasNext()){
			WebElement temp = iter.next();
			if (temp.isDisplayed()){
				window = temp;
			}
		}
		return window;
	}

	protected boolean clickNext() {

		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement buttoncontainer = WebElementUtils.getChildElement(window, B2WEquipment.getKendoButtonContainer());
			WebElement nextbutton = buttoncontainer.findElement(B2WEquipment.getKendoButtonNext());
			bReturn = WebElementUtils.clickElement(nextbutton);
			waitForPageNotBusy(WebElementUtils.MEDIUM_TIME_OUT);
		}
		return bReturn;
	
	}
	
	protected boolean clickCancel() {

		boolean bReturn = false;
		TaskUtils.sleep(500);
		WebElement window = getDisplayedWindow();
		if (window != null){
			WebElement cancelbutton = WebElementUtils.getChildElement(window, B2WEquipment.getKendoCancelButton());
			bReturn = WebElementUtils.clickElement(cancelbutton);
		}
		return bReturn;
	}
	
	public List<WebElement> getFormElements(By by) {
		List<WebElement> elements = new ArrayList<WebElement>();
		WebElement parent = WebElementUtils.waitAndFindDisplayedElement(by);
		List<WebElement> list = WebElementUtils.getChildElements(parent, By.tagName("p"));
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement el = iter.next();
			String sClass = el.getAttribute("class");
			if (sClass.startsWith("form")) {
				elements.add(el);
			}
		}

		return elements;
	}

	public WebElement getParentOfLabel(String sLabel) {
		WebElement label = null;
		WebElement content = getDisplayedWindow();
		if (content != null) {
			label = WebElementUtils.getParentElement(
					WebElementUtils.getChildElementContainsText(content, By.tagName("label"), sLabel));

		}
		return label;
	}

	protected boolean selectFromDialog(String sPart, int col) {

		boolean bReturn = false;
		WebElement window = getDisplayedWindow();
		log.debug("Looking for Part " + sPart);
		if (window != null) {
			WebElement grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			if (WebElementUtils.waitForElementStale(grid, 1)) {
				grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			}
			Iterator<WebElement> itr = getChildElementsFromGrid(grid);
			while (itr.hasNext()) {
				WebElement item = itr.next();
				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				String sText = gridcontent.get(col).getText();
				if (sText.equals("")) {
					Coordinates coordinate = ((Locatable) item).getCoordinates();
					coordinate.onPage();
					coordinate.inViewPort();
				}
				sText = gridcontent.get(col).getText();
				if (sText.startsWith(sPart)) {
					bReturn = WebElementUtils
							.clickElement(WebElementUtils.getChildElement(gridcontent.get(0), By.tagName("input")));
					break;
				}
			}
		}
		return bReturn;
	}

	protected String selectAnyItemFromDialog() {
		String sText = "";

		WebElement window = getDisplayedWindow();
		if (window != null) {
			WebElement grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			if (WebElementUtils.waitForElementStale(grid, 1)) {
				grid = WebElementUtils.getChildElement(window, B2WMaintain.getKendoGridContent());
			}
			if (grid != null) {
				List<WebElement> list = getListofElementsFromGrid(grid);
				Random rand = new Random();

				int randnumber = rand.nextInt(list.size());
				WebElement item = list.get(randnumber);

				List<WebElement> gridcontent = WebElementUtils.getChildElements(item, By.tagName("td"));
				sText = gridcontent.get(1).getText();
				if (sText.equals("")) {
					Coordinates coordinate = ((Locatable) item).getCoordinates();
					coordinate.onPage();
					coordinate.inViewPort();
				}
				sText = gridcontent.get(1).getText();
				WebElementUtils.clickElement(WebElementUtils.getChildElement(gridcontent.get(0), By.tagName("input")));
			}
		}
		return sText;
	}

	protected String selectRandomItemFromDropDown() {
		WebElement item = null;
		String sText = "";
		List<WebElement> list = WebElementUtils.findElements(B2WEquipment.getKendoLists());
		Iterator<WebElement> iter = list.iterator();
		log.debug("There are " + list.size() + " to find the correct drop down");
		while (iter.hasNext()) {
			WebElement els = iter.next();
			String hidden = els.getAttribute("aria-hidden");
			if (hidden != null && hidden.equals("false")) {
				List<WebElement> items = els.findElements(B2WEquipment.getKendoDropDownItem());
				while (sText.length() < 2) {
					item = items.get(getRandomNumber(items.size()));
					sText = item.getText();
				}
				if (item != null) {
					sText = item.getText();
					WebElementUtils.clickElement(item);
				} else {
					log.debug("Could not select item");
				}
			}
		}
		return sText;
	}

	protected boolean clickButton(String sButton) {
		WebElement window = getDisplayedWindow();
		List<WebElement> list = WebElementUtils.getChildElements(window, B2WMaintain.getKendoButton());
		for (WebElement el : list) {
			if (el.getText().equals(sButton)) {
				el.click();
			}
		}
		return false;

	}

	protected boolean openDropDownMenu(WebElement el, String sLabel) {
		boolean bReturn = false;
		WebElement label = WebElementUtils.getChildElementContainsText(el, By.tagName("label"), sLabel);
		if (el != null) {
			bReturn = WebElementUtils.clickElement(WebElementUtils
					.getChildElement(WebElementUtils.getParentElement(label), B2WMaintain.getKendoDropDown()));
		}
		return bReturn;
	}

	protected boolean enterDropDownMenu(WebElement el, String sLabel, String sText) {
		boolean bReturn = false;
		WebElement label = WebElementUtils.getChildElementContainsText(el, By.tagName("label"), sLabel);
		if (el != null) {
			WebElement dd = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label),
					B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(dd);
			bReturn &= WebElementUtils.sendKeys(dd, sText);
		}
		return bReturn;
	}

	public WebElement getFormElement(String sLabel, By by) {
		WebElement child = null;
		WebElement content = getDisplayedWindow();
		if (content != null) {
			WebElement label = WebElementUtils.getChildElementContainsText(content, By.tagName("label"), sLabel);
			if (label != null) {
				child = WebElementUtils.getChildElement(WebElementUtils.getParentElement(label), by);
			}
		}
		return child;
	}

	public String getItemsByRowColumnFromGrid(int iRow, int iColumn) {
		String itemstext = "";
		WebElement header = getDisplayedWindow();
		WebElement grid = WebElementUtils.getChildElement(header, B2WMaintain.getKendoGridContent());
		List<WebElement> list = getRowsFromGrid(grid);
		try {
			if (list.size() > 0) {
				List<WebElement> gridcontent = WebElementUtils.getChildElements(list.get(iRow), By.tagName("td"));
				if (gridcontent.size() > 0) {
					String sText = gridcontent.get(iColumn).getText();
					if (sText.equals("")) {
						Coordinates coordinate = ((Locatable) list.get(iRow)).getCoordinates();
						coordinate.onPage();
						coordinate.inViewPort();
					}
					sText = gridcontent.get(iColumn).getText();
					itemstext = sText;
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.debug("Column/Row does not exist");
		}
		return itemstext;
	}
	protected boolean setNumericField(String sLabel, String sText){
		boolean bReturn = false;
		WebElement dd = getFormElement(sLabel,B2WMaintain.getKendoNumericTextBox());
		if (dd != null){
			List<WebElement> inputs = WebElementUtils.getChildElements(dd, B2WMaintain.getKendoDropDown());
			bReturn = WebElementUtils.clickElement(inputs.get(0));
			bReturn &= WebElementUtils.sendKeys(inputs.get(1), sText);
		}
		return bReturn;

	}

}
