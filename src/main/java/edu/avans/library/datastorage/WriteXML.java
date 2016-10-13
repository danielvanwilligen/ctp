package edu.avans.library.datastorage;

import edu.avans.library.businesslogic.ProgramMgr;
import edu.avans.library.domain.SetDate;
import edu.avans.library.presentation.JavaGUI;
import static edu.avans.library.presentation.JavaGUI.datestamp;
import static edu.avans.library.presentation.JavaGUI.imagesequence;
import static edu.avans.library.presentation.JavaGUI.savecounter;
import static edu.avans.library.presentation.JavaGUI.specnrres;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import edu.avans.library.domain.SetPath;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class WriteXML {
    
    public void writedata() {
	try {
	    JavaGUI.xmloutput = "<JOBS>" + JavaGUI.enter;
            JavaGUI.imagesequencearray = imagesequence.split("#");
	    if (savecounter<1){
		JavaGUI.cleanfirstimage = JavaGUI.imagesequencearray[0].split("null");
	    }
            JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + "<JOB>" + JavaGUI.enter;
            for (int i = 0; i < JavaGUI.total_grid_fields_int; i++) {
                if (i==0){
		    if (savecounter<1){
			JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<FileName>"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.cleanfirstimage[1]+".pdfsta</FileName>" + JavaGUI.enter; 
		    } else {
			JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<FileName>"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.imagesequencearray[0]+".pdfsta</FileName>" + JavaGUI.enter; 
		    }
                } else {
                    JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<FileName>"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.imagesequencearray[i]+".pdfsta</FileName>" + JavaGUI.enter;
                }
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<Quantity>1</Quantity>" + JavaGUI.enter;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<DieShape>"+JavaGUI.dieshaperes.getText()+"</DieShape>" + JavaGUI.enter;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<Bleed>"+JavaGUI.bleedres.getText()+"</Bleed>" + JavaGUI.enter;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + JavaGUI.tab + "<SingleDie>"+JavaGUI.singleres.getText()+"</SingleDie>" + JavaGUI.enter;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.tab + "</JOB>" + JavaGUI.enter;
            }
            JavaGUI.xmloutput = JavaGUI.xmloutput + "</JOBS>" + JavaGUI.enter;
		
            //SAVE FUNCTION
	    datestamp = "";
	    SetDate calldate = new SetDate("timestamp");
	    datestamp = calldate.toString();
		
            File newXMLFile = new File(SetPath.stepdataoutput+datestamp+"_"+specnrres.getText()+".xml");
            try (FileWriter fw = new FileWriter(newXMLFile)) {
                fw.write(JavaGUI.xmloutput);
                //ADD COMMENT
                JOptionPane.showMessageDialog(null,"Saved succesfully"); 
            } catch (IOException ex) {
                Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                //ADD COMMENT
                JOptionPane.showMessageDialog(null,"Could not save the document."); 
            }
            try {
                Files.move(new File(SetPath.stepdataresource+JavaGUI.specnrres.getText()).toPath(), new File(SetPath.stepdataoutput+"temp/"+JavaGUI.specnrres.getText()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Could not move the document."); 
            }
                
		// RESET THE INTERFACE
		ProgramMgr MgrResetGuiInterface = new ProgramMgr();
		MgrResetGuiInterface.MgrReset();
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null,e); 
	}
	savecounter = savecounter+1;
    }
    
}
