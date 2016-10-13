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
    
    public void mgrwritedata() {
	WriteXML SaveXML = new WriteXML();
	SaveXML.writedata();
    }
    
    public void mgrreaddata() {
	ReadXML GetData = new ReadXML();
	GetData.getXMLData();
    }
    
    public void mgrreset() {
	Reset ResetGuiInterface = new Reset();
	ResetGuiInterface.resetgui();
    }
    
    public void mgrsetlayout() {
	SetLayout centerlayout = new SetLayout();
	centerlayout.createlayout();
    }
    
    public void mgrautolayout(){
	AutoLayout newlayout = new AutoLayout();
	newlayout.automaticlayout();
    }
    
}
