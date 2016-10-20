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

    }

    public void testMain() throws Throwable {
        createEmployeeAssignment();
        createEquipmentAssignment();
        createEmployeeNeed();
        createEquipmentNeed();
        createCrewAssignment();
        createCrewNeed();
        createMoveAssignment();
        createMoveOrder();
        createEmployeeEvent();
        createEquipmentEvent();
        createLocationEvent();
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
        logCompare(true, b2wScheduler.navigateToScheduleView("Employee Schedule", "Employee Schedule"), "Open Employee Schedule View");

    }

    public void createEquipmentAssignment() {
        //ToDo createEquipmentAssignment
    }

    public void createEmployeeNeed() {
        //ToDo createEmployeeNeed
    }

    public void createEquipmentNeed() {
        //ToDo createEquipmentNeed
    }

    public void createCrewAssignment() {
        //ToDo createCrewAssignment
    }

    public void createCrewNeed() {
        //ToDo createCrewNeed
    }

    public void createMoveAssignment() {
        //ToDo createMoveAssignment
    }

    public void createMoveOrder() {
        //ToDo createMoveOrder
    }

    public void createEmployeeEvent() {
        //ToDo createEmployeeEvent
    }

    public void createEquipmentEvent() {
        //ToDo createEquipmentEvent
    }

    public void createLocationEvent() {
        //ToDo createLocationEvent
    }
}
