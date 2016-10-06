package tasks.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appobjects.resources.B2WAddMaterials;
import tasks.WebElementUtils;

public class B2WDialogTasks {

	public List<WebElement> getRowsFromDialog() {
		WebElement grid = WebElementUtils.waitAndFindDisplayedElement(B2WAddMaterials.getCheckboxGrid());
		return grid.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
	}
}
