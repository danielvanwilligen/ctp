package edu.avans.library.businesslogic;

import edu.avans.library.datastorage.ReadXML;
import edu.avans.library.datastorage.WriteXML;
import edu.avans.library.domain.AutoLayout;
import edu.avans.library.domain.Reset;
import edu.avans.library.domain.SetLayout;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ProgramMgr {

    public void mgrwritedata() {
	WriteXML savexml = new WriteXML();
	savexml.writedata();
    }

    public void mgrreaddata() throws ParserConfigurationException, SAXException, IOException {
	ReadXML getdata = new ReadXML();
	getdata.getXMLData();
    }

    public void mgrreset() {
	Reset resetguiinterface = new Reset();
	resetguiinterface.resetgui();
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
