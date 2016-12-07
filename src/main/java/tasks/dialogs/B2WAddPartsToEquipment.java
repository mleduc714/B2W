package tasks.dialogs;

public class B2WAddPartsToEquipment extends B2WKendoDialog {

	public boolean selectPartToAddToEquipmentByDescription(String sPart){
		return selectFromDialog(sPart,1);
		
	}
	
	public boolean clickSaveAddPart() {
		return clickSave();
	}
	
	

	
}
