package tasks.dialogs;

public class B2WAddEquipmentTag extends B2WKendoDialog {
	
	
	public boolean selectEquipmentTag(String sTag){
		return selectFromDialog(sTag,1);
		
	}
	
	public boolean clickSaveEquipmentTag() {
		return clickSave();
	}

}
