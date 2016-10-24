package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.scheduler.B2WSchedulerTasks;

public class ScheduleAssignments extends B2WTestCase {

    /*
     * 1. Create an Employee Assignment
     * 2. Create an Equipment Assignment
     * 3. Create an Employee Need
     * 4. Create an Equipment Need
     * 5. Create a Crew Assignment
     * 6. Create a Crew Need
     * 7. Create a Move Assignment
     * 8. Create a Move Order
     * 9. Create an Employee Event
     * 10. Create an Equipment Event
     * 11. Create a Location Event
     */

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WSchedulerTasks b2wScheduler = new B2WSchedulerTasks();

    // Property
    String sEmployeeView;
    String sEquipmentView;
    String sCrewView;
    String sLocationView;
    String sEmployeeName;
    String sEquipmentName;
    String sEmployeeNeedName;
    String sEquipmentNeedName;
    String sJobSiteName;
    String sCrewName;
    String sCrewNeedName;
    String sPickupJobSiteName;
    String sDropoffJobSiteName;
    String sTransportationCrewName;


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

    @Override
    public void testSetUp() throws Throwable {
        // TODO Auto-generated method stub
        super.testSetUp();
        int  n = getRandomNumber();

        sEmployeeView = getProperty("sEmployeeView");
        sEquipmentView = getProperty("sEquipmentView");
        sCrewView = getProperty("sCrewView");
        sLocationView = getProperty("sLocationView");

        sJobSiteName = getProperty("sJobSiteName");
        sEmployeeName = getProperty("sEmployeeName");
        sEmployeeNeedName = getProperty("sEmployeeNeedName");
        sEquipmentName = getProperty("sEquipmentName");
        sEquipmentNeedName = getProperty("sEquipmentNeedName");
        sCrewName = getProperty("sCrewName");
        sCrewNeedName = getProperty("sCrewNeedName");
        sPickupJobSiteName = getProperty("sPickupJobSiteName");
        sDropoffJobSiteName = getProperty("sDropoffJobSiteName");
        sTransportationCrewName = getProperty("sTransportationCrewName");

    }

    public void testMain() throws Throwable {
        /*
        createEmployeeAssignment();
        createEquipmentAssignment();
        createEmployeeNeed();
        createEquipmentNeed();
        createCrewAssignment();
        createCrewNeed();
        createMoveAssignment();
        createMoveOrder();
        */
        createEmployeeEvent();
        /*
        createEquipmentEvent();
        createLocationEvent();
        */
    }

    @Override
    public void testTearDown() throws Throwable {
        // TODO Auto-generated method stub
        super.testTearDown();
    }

    public void createEmployeeAssignment() {
        //ToDo createEmployeeAssignment
        // Open Schedule View with Employee Schedule
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.createNewEmployeeAssignment(), "Open Create Employee Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployee(sEmployeeName), "Set Employee");
        logCompare(true, b2wScheduler.saveEmployeeAssignment(), "Save New Employee Assignment");
    }

    public void createEquipmentAssignment() {
        //ToDo createEquipmentAssignment
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.createNewEquipmentAssignment(), "Open Create Equipment Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.saveEquipmentAssignment(), "Save New Equipment Assignment");

    }

    public void createEmployeeNeed() {
        //ToDo createEmployeeNeed
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.createNewEmployeeNeed(), "Open Create Employee Need Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEmployeeNeed(sEmployeeNeedName), "Set Employee Need");
        logCompare(true, b2wScheduler.saveEmployeeNeedAssignment(), "Save New Employee Need Assignment");
    }

    public void createEquipmentNeed() {
        //ToDo createEquipmentNeed
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.createNewEquipmentNeed(), "Open Create Equipment Need Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setEquipmentNeed(sEquipmentNeedName), "Set Equipment Need");
        logCompare(true, b2wScheduler.saveEquipmentNeedAssignment(), "Save New Equipment Need Assignment");
    }

    public void createCrewAssignment() {
        //ToDo createCrewAssignment
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.createNewCrewAssignment(), "Open Create Crew Assignment Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrew(sCrewName), "Set Crew");
        logCompare(true, b2wScheduler.saveCrewAssignment(), "Save New Crew Assignment");
    }

    public void createCrewNeed() {
        //ToDo createCrewNeed
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sCrewView, sCrewView), "Open Crew Schedule View");
        logCompare(true, b2wScheduler.createNewCrewNeed(), "Open Create New Crew Need Dialog");
        logCompare(true, b2wScheduler.setJobSite(sJobSiteName), "Set JobSite/Place");
        logCompare(true, b2wScheduler.setCrewNeed(sCrewNeedName), "Set Crew Need");
        logCompare(true, b2wScheduler.saveCrewNeedAssignment(), "Save New Crew Assignment");
    }

    public void createMoveAssignment() {
        //ToDo createMoveAssignment
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.createNewMoveAssignment(), "Open Create Move Assignment Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.selectCrew(sCrewName), "Open Select Crew Dialog");
        logCompare(true, b2wScheduler.setCrew(sTransportationCrewName), "Set Crew");
        logCompare(true, b2wScheduler.saveMoveAssignment(), "Save New Move Assignment");
    }

    public void createMoveOrder() {
        //ToDo createMoveOrder
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.createNewMoveOrder(), "Open Create Move Order Dialog");
        logCompare(true, b2wScheduler.setEquipment(sEquipmentName), "Set Equipment");
        logCompare(true, b2wScheduler.setPickupLocation("Job Site/Place", sPickupJobSiteName), "Set Pickup Location");
        logCompare(true, b2wScheduler.setDropoffLocation("Job Site/Place", sDropoffJobSiteName), "Set Drop-off Location");
        logCompare(true, b2wScheduler.saveMoveOrder(), "Save New Move Order");
    }

    public void createEmployeeEvent() {
        //ToDo createEmployeeEvent
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEmployeeView, sEmployeeView), "Open Employee Schedule View");
        logCompare(true, b2wScheduler.createNewEmployeeEvent(), "Open Create Employee Event Dialog");

    }

    public void createEquipmentEvent() {
        //ToDo createEquipmentEvent
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sEquipmentView, sEquipmentView), "Open Equipment Schedule View");
        logCompare(true, b2wScheduler.createNewEquipmentEvent(), "Create Equipment Event");
    }

    public void createLocationEvent() {
        //ToDo createLocationEvent
        logCompare(true, b2wNav.openSchedule(), "Open Schedule View");
        logCompare(true, b2wScheduler.navigateToScheduleView(sLocationView, sLocationView), "Open Places Schedule View");
        logCompare(true, b2wScheduler.createNewLocationEvent(), "Create Location Event");
    }
}
