package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.resources.B2WCrewTemplate;
import tasks.resources.B2WCrewTemplateTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class B2WCrewTemplateTest extends B2WTestCase{

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WCrewTemplateTasks crewTemplateTasks = new B2WCrewTemplateTasks();

	private B2WCrewTemplate productionCrewTemplate = new B2WCrewTemplate();

    @Override
    public void testTearDown() throws Throwable {
        super.testTearDown();
    }

    @Override
    public String getAuthor() {
        return "atrostyanko";
    }

    @Override
    public String getDataPath() {
        return "data/test";
    }

    @Override
    public boolean isSupported() {
        return true;
    }

    @Override
    public String getCategory() {
        return null;
    }

	@Override
	public void testSetUp() throws Throwable {
		super.testSetUp();

		// === Setup Production Crew Template
        productionCrewTemplate.setType("Production Crew");
        productionCrewTemplate.setName(getProperty("sProdCrewTemplateName")); 				        //AUT Prod Crew
        productionCrewTemplate.setID(getProperty("sProdCrewTemplateID"));					            //AUT Prod Crew ID
        productionCrewTemplate.setWorkType(getProperty("sProdCrewTemplateWorkType")); 		        //Bridge
        productionCrewTemplate.setWorkSubType(getProperty("sProdCrewTemplateWorkSubtype"));	        //Support
		productionCrewTemplate.setBusinessUnit(getProperty("sProdCrewTemplateBU"));					//Organization
		productionCrewTemplate.setNotes(getProperty("sProdCrewTemplateNotes"));				        //AUT Production Crew Notes!!!
		productionCrewTemplate.setInactive(getProperty("sProdCrewTemplateInactive").toLowerCase().equals("true"));		//false
		productionCrewTemplate.setForeman(getProperty("sProdCrewTemplateForeman"));			        //Addison Miller
        productionCrewTemplate.setEmployees(parseString(getProperty("employeesList")));                    //Aaliyah Parker, Caroline Chan
        productionCrewTemplate.setEquipments(parseString(getProperty("equipmentList")));             //AUGTRK, BH002
        productionCrewTemplate.setLaborTypes(parseString(getProperty("laborTypeList")));				//Auger Operator, Carpenter
        productionCrewTemplate.setEquipmentTypes(parseString(getProperty("equipmentTypeList")));			//953 Loaders, 953 Loaders

		// === Setup Transport Crew Template
	}

	@Override
	public void testMain() throws Throwable {
		super.testMain();

        logCompare(true, b2wNav.openCrewTemplates(), "Navigate to Resources -> Crew Templates");
        createCrew(productionCrewTemplate);
	}

    private void createCrew(B2WCrewTemplate crewTemplate) {
        logCompare(true, true, "====== Start Production Crew Template creation test: " + crewTemplate.getName());
        logCompare(true, crewTemplateTasks.selectAddCrewTemplate(crewTemplate.getType()), "Open Add Crew Template dialog.");
        logCompare(true, crewTemplateTasks.createProductionCrewTemplate(crewTemplate), "Create Production Crew Template dialog.");

        logCompare(true, true, "====== Stop Production Crew Template creation test: " + crewTemplate.getName());
    }

	private ArrayList<String> parseString(String sValue) {
        return new ArrayList<>(Arrays.asList(sValue.split(", ")));
	}
}
