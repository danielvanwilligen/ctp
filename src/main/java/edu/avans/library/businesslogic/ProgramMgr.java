package edu.avans.library.businesslogic;

import edu.avans.library.datastorage.ReadXML;
import edu.avans.library.datastorage.WriteXML;
import edu.avans.library.domain.AutoLayout;
import edu.avans.library.domain.Reset;
import edu.avans.library.domain.SetLayout;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ProgramMgr {
    
    public void MgrWriteData() {
	WriteXML SaveXML = new WriteXML();
	SaveXML.writedata();
    }
    
    public void MgrReadData() {
	ReadXML GetData = new ReadXML();
	GetData.getXMLData();
    }
    
    public void MgrReset() {
	Reset ResetGuiInterface = new Reset();
	ResetGuiInterface.resetgui();
    }
    
    public void MgrSetLayout() {
	SetLayout centerlayout = new SetLayout();
	centerlayout.createlayout();
    }
    
    public void MgrAutoLayout(){
	AutoLayout newlayout = new AutoLayout();
	newlayout.automaticlayout();
    }
    
}
