package testcases;

import com.b2w.test.B2WTestCase;
import tasks.B2WNavigationTasks;
import tasks.resources.B2WCrewTemplate;
import tasks.resources.B2WCrewTemplateTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class B2WCrewTemplateTest extends B2WTestCase {

    B2WNavigationTasks b2wNav = new B2WNavigationTasks();
    B2WCrewTemplateTasks crewTemplateTasks = new B2WCrewTemplateTasks();

    private B2WCrewTemplate productionCrewTemplate = new B2WCrewTemplate();
    private B2WCrewTemplate productionCrewTemplateUpdate = new B2WCrewTemplate();
    private B2WCrewTemplate copyProductionCrewTemplate = new B2WCrewTemplate();

    private B2WCrewTemplate transportCrewTemplate = new B2WCrewTemplate();
    private B2WCrewTemplate transportCrewTemplateUpdate = new B2WCrewTemplate();
    private B2WCrewTemplate copyTransportCrewTemplate = new B2WCrewTemplate();

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
        productionCrewTemplate.setName(getProperty("sProdCrewTemplateName"));
        productionCrewTemplate.setID(getProperty("sProdCrewTemplateID"));
        productionCrewTemplate.setWorkType(getProperty("sProdCrewTemplateWorkType"));
        productionCrewTemplate.setWorkSubType(getProperty("sProdCrewTemplateWorkSubtype"));
        productionCrewTemplate.setBusinessUnit(getProperty("sProdCrewTemplateBU"));
        productionCrewTemplate.setNotes(getProperty("sProdCrewTemplateNotes"));
        productionCrewTemplate.setInactive(getProperty("sProdCrewTemplateInactive").toLowerCase().equals("true"));
        productionCrewTemplate.setForeman(getProperty("sProdCrewTemplateForeman"));
        productionCrewTemplate.setEmployees(parseString(getProperty("employeesList")));
        productionCrewTemplate.setEquipments(parseString(getProperty("equipmentList")));
        productionCrewTemplate.setLaborTypes(parseString(getProperty("laborTypeList")));
        productionCrewTemplate.setEquipmentTypes(parseString(getProperty("equipmentTypeList")));

        productionCrewTemplateUpdate = productionCrewTemplate.clone();
        productionCrewTemplateUpdate.setType("Production Crew");
        productionCrewTemplateUpdate.setName(getProperty("sProdCrewTemplateNameUPD"));
        productionCrewTemplateUpdate.setID(getProperty("sProdCrewTemplateIDUPD"));
        productionCrewTemplateUpdate.setWorkType(getProperty("sProdCrewTemplateWorkTypeUPD"));
        productionCrewTemplateUpdate.setWorkSubType(getProperty("sProdCrewTemplateWorkSubtypeUPD"));
        productionCrewTemplateUpdate.setBusinessUnit(getProperty("sProdCrewTemplateBUUPD"));
        productionCrewTemplateUpdate.setNotes(getProperty("sProdCrewTemplateNotesUPD"));
        productionCrewTemplateUpdate.setInactive(getProperty("sProdCrewTemplateInactiveUPD").toLowerCase().equals("true"));
        productionCrewTemplateUpdate.setForeman(getProperty("sProdCrewTemplateForemanUPD"));
        productionCrewTemplateUpdate.setEmployees(parseString(getProperty("employeesListUPD")));
        productionCrewTemplateUpdate.setEquipments(parseString(getProperty("equipmentListUPD")));
        productionCrewTemplateUpdate.setLaborTypes(parseString(getProperty("laborTypeListUPD")));
        productionCrewTemplateUpdate.setEquipmentTypes(parseString(getProperty("equipmentTypeListUPD")));

        // === Setup Transport Crew Template
        transportCrewTemplate.setType("Transport Crew");
        transportCrewTemplate.setName(getProperty("sTransportCrewTemplateName"));
        transportCrewTemplate.setID(getProperty("sTransportCrewTemplateID"));
        transportCrewTemplate.setTransportType(getProperty("sTransportType"));
        transportCrewTemplate.setWorkType(getProperty("sTransportCrewTemplateWorkType"));
        transportCrewTemplate.setWorkSubType(getProperty("sTransportCrewTemplateWorkSubtype"));
        transportCrewTemplate.setBusinessUnit(getProperty("sTransportCrewTemplateBU"));
        transportCrewTemplate.setNotes(getProperty("sTransportCrewTemplateNotes"));
        transportCrewTemplate.setInactive(getProperty("sTransportCrewTemplateInactive").toLowerCase().equals("true"));
        transportCrewTemplate.setForeman(getProperty("sTransportCrewTemplateDriver"));
        transportCrewTemplate.setEmployees(parseString(getProperty("transportEmployeesList")));
        transportCrewTemplate.setEquipments(parseString(getProperty("transportEquipmentList")));
        transportCrewTemplate.setLaborTypes(parseString(getProperty("transportLaborTypeList")));
        transportCrewTemplate.setEquipmentTypes(parseString(getProperty("transportEquipmentTypeList")));
        transportCrewTemplate.setEquipmentThatMoves(parseString(getProperty("transportEquipmentThatMoves")));

        transportCrewTemplateUpdate = transportCrewTemplate.clone();
        transportCrewTemplateUpdate.setName(getProperty("sTransportCrewTemplateNameUPD"));
        transportCrewTemplateUpdate.setID(getProperty("sTransportCrewTemplateIDUPD"));
        transportCrewTemplateUpdate.setTransportType(getProperty("sTransportTypeUPD"));
        transportCrewTemplateUpdate.setWorkType(getProperty("sTransportCrewTemplateWorkTypeUPD"));
        transportCrewTemplateUpdate.setWorkSubType(getProperty("sTransportCrewTemplateWorkSubtypeUPD"));
        transportCrewTemplateUpdate.setBusinessUnit(getProperty("sTransportCrewTemplateBUUPD"));
        transportCrewTemplateUpdate.setNotes(getProperty("sTransportCrewTemplateNotesUPD"));
        transportCrewTemplateUpdate.setInactive(getProperty("sTransportCrewTemplateInactiveUPD").toLowerCase().equals("true"));
        transportCrewTemplateUpdate.setForeman(getProperty("sTransportCrewTemplateDriverUPD"));
        transportCrewTemplateUpdate.setEmployees(parseString(getProperty("transportEmployeesListUPD")));
        transportCrewTemplateUpdate.setEquipments(parseString(getProperty("transportEquipmentListUPD")));
        transportCrewTemplateUpdate.setLaborTypes(parseString(getProperty("transportLaborTypeListUPD")));
        transportCrewTemplateUpdate.setEquipmentTypes(parseString(getProperty("transportEquipmentTypeListUPD")));
        transportCrewTemplateUpdate.setEquipmentThatMoves(parseString(getProperty("transportEquipmentThatMovesUPD")));

    }

    @Override
    public void testMain() throws Throwable {
        super.testMain();

        logCompare(true, b2wNav.openCrewTemplates(), "Navigate to Resources -> Crew Templates");

        // Create Crew Templates
        createCrew(productionCrewTemplate);
        createCrew(transportCrewTemplate);

        // Update Crew Templates
        updateCrew(productionCrewTemplate, productionCrewTemplateUpdate);
        productionCrewTemplate = productionCrewTemplateUpdate;
        updateCrew(transportCrewTemplate, transportCrewTemplateUpdate);
        transportCrewTemplate = transportCrewTemplateUpdate;

        // Copy Crew Templates
        searchCrewTemplate(productionCrewTemplate);
        copyProductionCrewTemplate = copyCrew(productionCrewTemplate);
        searchCrewTemplate(transportCrewTemplate);
        copyTransportCrewTemplate = copyCrew(transportCrewTemplate);
        clearSearch();

        // Delete Crew Templates
        deleteCrew(productionCrewTemplate);
        if (copyProductionCrewTemplate != null) { deleteCrew(copyProductionCrewTemplate); }

        deleteCrew(transportCrewTemplate);
        if (copyTransportCrewTemplate != null) { deleteCrew(copyTransportCrewTemplate); }
    }

    // Private Test Methods
    private void createCrew(B2WCrewTemplate crewTemplate) {
        logCompare(true, true, "====== Start Creation Crew Template test: " + crewTemplate.getName());
        logCompare(true, crewTemplateTasks.selectAddCrewTemplate(crewTemplate.getType()), "Open Add Crew Template dialog.");
        logCompare(true, crewTemplateTasks.createCrewTemplate(crewTemplate), "Create " + crewTemplate.getType() + " Crew Template.");
        logCompare(true, true, "====== Stop Creation Crew Template test: " + crewTemplate.getName());

    }

    private void updateCrew(B2WCrewTemplate crewTemplate, B2WCrewTemplate crewTemplateUPD) {
        logCompare(true, true, "====== Start Update Crew Template test: " + crewTemplate.getName());
        logCompare(true, crewTemplateTasks.updateCrewTemplate(crewTemplate, crewTemplateUPD), "Update " + crewTemplate.getName() + " Crew Template.");
        logCompare(true, true, "====== Stop Update Crew Template test: " + crewTemplate.getName());
    }

    private B2WCrewTemplate copyCrew(B2WCrewTemplate crewTemplate) {
        B2WCrewTemplate oReturn = null;
        logCompare(true, true, "====== Start Copy Crew Template test: " + crewTemplate.getName());
        if (logCompare(true, crewTemplateTasks.copyCrewTemplate(crewTemplate), "Update Crew Template: " + crewTemplate.getName())) {
            oReturn = crewTemplate.clone();
            oReturn.setName("Copy of " + crewTemplate.getName());
        }
        logCompare(true, true, "====== Stop Copy Crew Template test: " + crewTemplate.getName());
        return oReturn;
    }

    private void searchCrewTemplate(B2WCrewTemplate crewTemplate) {
        logCompare(true, true, "====== Start Copy Crew Template test: " + crewTemplate.getName());
        logCompare(true, crewTemplateTasks.searchCrewTemplate(crewTemplate.getName()), "Search Crew Template '" + crewTemplate.getName() + "' in the list.");
        logCompare(true, true, "====== Stop Copy Crew Template test: " + crewTemplate.getName());
    }

    private void clearSearch() {
        logCompare(true, crewTemplateTasks.clearSearchCrewTemplate(), "Clear Search Field.");
    }

    private void deleteCrew(B2WCrewTemplate crewTemplate) {
        logCompare(true, true, "====== Start Delete Production Crew Template test: " + crewTemplate.getName());
        logCompare(true, crewTemplateTasks.deleteCrew(crewTemplate), "Delete Crew Template.");
        logCompare(true, true, "====== Stop Delete Production Crew Template test: " + crewTemplate.getName());
    }

    // Support functions
    private ArrayList<String> parseString(String sValue) {
        return new ArrayList<>(Arrays.asList(sValue.split(", ")));
    }
}
