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
    SetPath setallpaths = new SetPath();
    private final String stepdataoutput = setallpaths.getStepdataoutput();
    /**
    * writedata
    * writedata writes xml data to the harddrive
    */
    public static final String TAGNAME ="FileName";
    public static final String EXTENSION =".pdfsta";

    public void writedata() {

        try {
            JavaGUI.xmloutput = "<JOBS>" + JavaGUI.ENTER;
            JavaGUI.imagesequencearray = imagesequence.split("#");
            if (savecounter<1){
                JavaGUI.cleanfirstimage = JavaGUI.imagesequencearray[0].split("null");
            }
            JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + "<JOB>" + JavaGUI.ENTER;
            for (int i = 0; i < JavaGUI.totalgridfieldsint; i++) {
                if (i==0){
                    if (savecounter<1){
                        JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<"+TAGNAME+">"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.cleanfirstimage[1]+EXTENSION+"</"+TAGNAME+">" + JavaGUI.ENTER; 
                    } else {
                        JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<"+TAGNAME+">"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.imagesequencearray[0]+EXTENSION+"</"+TAGNAME+">" + JavaGUI.ENTER; 
                    }
                } else {
                    JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<"+TAGNAME+">"+SetPath.stepdataresource+JavaGUI.specnrres.getText()+"/"+JavaGUI.imagesequencearray[i]+EXTENSION+"</"+TAGNAME+">" + JavaGUI.ENTER;
                }
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<Quantity>1</Quantity>" + JavaGUI.ENTER;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<DieShape>"+JavaGUI.dieshaperes.getText()+"</DieShape>" + JavaGUI.ENTER;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<Bleed>"+JavaGUI.bleedres.getText()+"</Bleed>" + JavaGUI.ENTER;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + JavaGUI.TAB + "<SingleDie>"+JavaGUI.singleres.getText()+"</SingleDie>" + JavaGUI.ENTER;
                JavaGUI.xmloutput = JavaGUI.xmloutput + JavaGUI.TAB + "</JOB>" + JavaGUI.ENTER;
            }
            JavaGUI.xmloutput = JavaGUI.xmloutput + "</JOBS>" + JavaGUI.ENTER;
        
            //SAVE FUNCTION
            datestamp = "";
            SetDate calldate = new SetDate("timestamp");
            datestamp = calldate.toString();

            File newXMLFile = new File(stepdataoutput+datestamp+"_"+specnrres.getText()+".xml");
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
                Files.move(new File(SetPath.stepdataresource+JavaGUI.specnrres.getText()).toPath(), new File(stepdataoutput+"temp/"+JavaGUI.specnrres.getText()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
        Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Could not move the document."); 
            }
                
            // RESET THE INTERFACE
            ProgramMgr mgrresetGuiInterface = new ProgramMgr();
            mgrresetGuiInterface.mgrreset();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        savecounter = savecounter+1;
    }   
}