package testcases;

import java.util.LinkedHashMap;
import java.util.Set;

import com.b2w.test.B2WTestCase;

import tasks.B2WNavigationTasks;
import tasks.BrowserUtils;
import tasks.setup.B2WSchedulesTasks;
import tasks.util.B2WScheduleItem;
import tasks.util.TaskUtils;
import tasks.util.Timer;


public class B2WScheduleCreateTest extends B2WTestCase{
	
	private static LinkedHashMap<String,Long> linkTable = new LinkedHashMap<String,Long>();

	@Override
	public void testSetUp() throws Throwable {
		// TODO Auto-generated method stub
		super.testSetUp();
	}

	@Override
	public void testMain() throws Throwable {
		// TODO Auto-generated method stub
		super.testMain();
		createSchedule();
	}

	@Override
	public void testTearDown() throws Throwable {
		// TODO Auto-generated method stub
		super.testTearDown();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "mleduc";
	}

	@Override
	public String getDataPath() {
		// for properties files of test data
		return "data/test";
	}

	@Override
	public boolean isSupported() {
		// for specific browser
		return true;
	}

	@Override
	public String getCategory() {
		// Category of the within ops
		return null;
	}
	
	public static void createSchedule() throws Exception {
		
		Timer timer = new Timer();
		
		B2WSchedulesTasks schedulesTasks = new B2WSchedulesTasks();
		
		B2WNavigationTasks navigationTasks = new B2WNavigationTasks();
		
		navigationTasks.openSchedules();
		
		schedulesTasks.clickCreateScheduleViewDialog();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Create Schedule", timer.getTotalTime());
		
		schedulesTasks.setName("New Schedule Task");
		
		schedulesTasks.setBU("Organization");
		
		schedulesTasks.setNotes("This is a new test Schedule View.");
		
		schedulesTasks.setScheduleFormat("Resource Listing");
		
		B2WScheduleItem schedItem = new B2WScheduleItem();
		 
		schedulesTasks.setGrouping("group items by", "Job");
		
		schedulesTasks.setGrouping("secondary grouping", "Location");
		
		schedulesTasks.setSecurityRole("Foreman");
		
		schedulesTasks.setFilter("Business Unit", "Northern Division");
		
		schedulesTasks.setUser("Deborah Dean");
		schedulesTasks.setUser("Darrin Bailey");
		schedulesTasks.setUser("Jody Thornton");
		schedulesTasks.setUser("Build Service");
		
		schedulesTasks.saveSchedule();
		
		schedulesTasks.clickUpdateScheduleViewDialog();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Open Schedule to Edit", timer.getTotalTime());
		
		schedulesTasks.setFilter("Place Category", "Office");
		
		schedulesTasks.setNotes("These are new, edited notes. 12345678910");
		
		schedulesTasks.setBU("Northern Division\\Paving");
		
		schedulesTasks.saveSchedule();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Save Schedule", timer.getTotalTime());
        
		schedulesTasks.deleteSchedule();
		timer.start();
	    timer.waitFullLoad(BrowserUtils.getDriver());
		timer.end();
        linkTable.put("Delete Schedule", timer.getTotalTime());
        
        Set<String> keys = linkTable.keySet();
        for (String key: keys){
               System.out.println(key + " " + linkTable.get(key));
        }
	}
	
}