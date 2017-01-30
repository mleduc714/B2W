package appobjects;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WCommonObjects {
	
	 public static By getB2WPageContentGrid(){
		    return By.cssSelector(B2WUIMap.b2w_pagecontentlistinggridview);
	 }
	 public static By getB2WPageContentDetailPanel() {
		 	return By.cssSelector(B2WUIMap.b2w_pagecontentdetailpanel);
	 }
	 public static By getB2WPageProductPanel() {
		 	return By.cssSelector(B2WUIMap.b2w_pageproductpanel);
	 }
	 public static By getB2WPageContentContentDetailPanel() {
		 	return By.cssSelector(B2WUIMap.b2w_pagecontentcontentdetailpanel);
	 }
	 public static By getB2WPagePanelError() {
		 return By.cssSelector(B2WUIMap.b2w_pagecontentcontentdetailpanel);
	 }
	 public static By getB2WGridHeader() {
		 return By.cssSelector(B2WUIMap.b2w_gridheader);
	 }
}
