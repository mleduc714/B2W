package appobjects.jobs;

import org.openqa.selenium.By;

import appobjects.B2WUIMap;

public class B2WJobsDialogs {
	
	public static final String b2w_jobsaddselectbutton = "a[id$='SelectControl_SelectButton']";
	public static final String b2w_jobsaddsearchbutton = "a[id$='SearchControl_SearchButton']";
	public static final String b2w_jobsaddbutton = "a[id$='Dialog_AddButton']";
	
	public static By getB2WJobsaddSearchText() {
		return By.cssSelector(B2WUIMap.b2w_jobsadddialogsearchclass);
	}
	public static By getB2WJobsaddSelectText() {
		return By.cssSelector(B2WUIMap.b2w_jobsadddialogselectclass);
	}
	public static By getB2WJobsaddselectbutton() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddselectbutton);
	}
	public static By getB2WJobsaddsearchbutton() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddsearchbutton);
	}
	public static By getB2WJobsaddbutton() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddbutton);
	}
	public static By getB2WJobscancelbutton() {
		return By.cssSelector(B2WUIMap.b2w_jobscancelbutton);
		}
	public static By getB2WJobsaddgrid() {
		return By.cssSelector(B2WUIMap.b2w_jobsgridview);
	}
	
	
	
//	public static By getB2WJobsaddmaterialssearchjs() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialssearchjs);
//	}
//	public static By getB2WJobsaddmaterialsidjs() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialsidjs);
//	}
//	public static By getB2WJobsaddmaterialssearchbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialssearchbutton);
//	}
//	public static By getB2WJobsaddmaterialsselectbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialsselectbutton);
//	}
//	public static By getB2WJobsaddmaterialsaddbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialsaddbutton);
//	}
//	public static By getB2WJobsaddsubcontractorssearch() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorssearch);
//	}
//	public static By getB2WJobsaddsubcontractorsid() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorsid);
//	}
//	public static By getB2WJobsaddsubcontractorssearchbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorssearchbutton);
//	}
//	public static By getB2WJobsaddsubcontractorsselectbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorsselectbutton);
//	}
//	public static By getB2WJobsaddsubcontractorsaddbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorsaddbutton);
//	}
//	public static By getB2WJobsaddtrucksubcontractorssearch() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorssearch);
//	}
//	public static By getB2WJobsaddtrucksubcontractorsid() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorsid);
//	}
//	public static By getB2WJobsaddtrucksubcontractorssearchbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorssearchbutton);
//	}
//	public static By getB2WJobsaddtrucksubcontractorsselectbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorsselectbutton);
//	}
//	public static By getB2WJobsaddtrucksubcontractorsaddbutton() {
//		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorsaddbutton);
	
	public static By getB2WJobsaddsubcontractorsgridview() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorsgridview);
	}
	public static By getB2WJobsaddtrucksubcontractorsgridview() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorsgridview);
	}
	public static By getB2WJobsaddmaterialsgridview() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialsgridview);
	}
	public static By getB2WJobsaddvendorsgridview() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddvendorsgridview);
	}
	public static By getB2WJobsaddsubcontractorsgridviewchkbox() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddsubcontractorgridviewcheckbox);
	}
	public static By getB2WJobsaddtrucksubcontractorsgridviewchkbox() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddtrucksubcontractorgridviewcheckbox);
	}
	public static By getB2WJobsaddmaterialsgridviewchkbox() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddmaterialgridviewcheckbox);
	}
	public static By getB2WJobsaddvendorsgridviewchkbox() {
		return By.cssSelector(B2WUIMap.b2w_jobsaddvendorsgridviewcheckbox);
	}
}
