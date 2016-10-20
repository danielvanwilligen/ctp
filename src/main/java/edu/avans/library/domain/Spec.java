package edu.avans.library.domain;

import edu.avans.library.businesslogic.ProgramMgr;
import edu.avans.library.presentation.JavaGUI;
import static edu.avans.library.presentation.JavaGUI.ONEHUNDRED;
import static edu.avans.library.presentation.JavaGUI.ONEHUNDREDTEN;
import static edu.avans.library.presentation.JavaGUI.TWENTY;
import static edu.avans.library.presentation.JavaGUI.TWOHUNDRED;
import static edu.avans.library.presentation.JavaGUI.bottompanel;
import static edu.avans.library.presentation.JavaGUI.frame;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.menustatus;
import static edu.avans.library.presentation.JavaGUI.name;
import static edu.avans.library.presentation.JavaGUI.navpanel;
import static edu.avans.library.presentation.JavaGUI.screenheight;
import static edu.avans.library.presentation.JavaGUI.screenwidth;
import static edu.avans.library.presentation.JavaGUI.specbutton;
import static edu.avans.library.presentation.JavaGUI.specbuttonlocked;
import static edu.avans.library.presentation.JavaGUI.subbottompanel;
import static edu.avans.library.presentation.JavaGUI.x;
import static edu.avans.library.presentation.JavaGUI.y;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */
public class Spec {
    public static final int TWOHUNDREDTEN = 210;
    public static final int TWOHUNDREDELEVEN = 211;
    public static final int TWOHUNDREDTWELVE = 212;
    /**
    * Spec
    * Spec builds specbutton(combo) in the gui 
    */
    public void Spec(){
	String state = "false";
        menustatus = state;
	
	// black 20%
        int bgcrSideMenu = TWOHUNDREDTEN;
        int bgcgSideMenu = TWOHUNDREDELEVEN;
        int bgcbSideMenu = TWOHUNDREDTWELVE;
	specbutton.setVisible(false);
        specbuttonlocked.setVisible(true);
        frame.repaint();
        if (menustatus.equals(state)){
            bottompanel.setBounds(x, y+screenheight-navpanel-ONEHUNDREDTEN,screenwidth, navpanel);
            bottompanel.revalidate();
            bottompanel.repaint();

            subbottompanel = new JPanel(null);
            subbottompanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
            subbottompanel.setBounds(x, y+screenheight-navpanel-TWENTY,screenwidth, navpanel);
            frame.add(subbottompanel);
            subbottompanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            ImageIcon bottomspacer = new ImageIcon(SetPath.IMAGERESOURCE+"spacer_gray.png");
            img = new JLabel(bottomspacer);
            subbottompanel.add(img);
                    
            final JComboBox combo = new JComboBox();

            // SIZE HEIGTH DOES NOT WORK
            Dimension preferredSize = combo.getPreferredSize();
            preferredSize.height = ONEHUNDRED;
            preferredSize.width = TWOHUNDRED;
            combo.setPreferredSize(preferredSize);

            combo.setModel(populate());
            combo.setRenderer(new ImagesTextRenderer());

            //EVENTS
            combo.addActionListener((ActionEvent arg0) -> {
                Preset presetlayout = new Preset();
                presetlayout.preset();
                name=((ImagesNText)combo.getSelectedItem()).getName();
                ProgramMgr getdata = new ProgramMgr();
                try {
                    getdata.mgrreaddata();
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                SetImages setimagespanel = new SetImages();
                setimagespanel.setimagesrightpanel();
                ProgramMgr mgrcenterlayout = new ProgramMgr();
                mgrcenterlayout.mgrsetlayout();
            });
            subbottompanel.add(combo);
            frame.repaint();
            menustatus = "true";
        } else {
            bottompanel.setBounds(x, y+screenheight-navpanel+TWENTY,screenwidth, navpanel);
            bottompanel.revalidate();
            bottompanel.repaint();
            subbottompanel.setVisible(false);
            frame.repaint();
            menustatus = state;
        }
    }
    
    private DefaultComboBoxModel populate(){
        // Fill the combobox dynamicly
        // Data folder
        // Read folder structure
        File file = new File(SetPath.STEPDATARESOURCE);
        String[] specnumber = file.list();
        DefaultComboBoxModel dm = new DefaultComboBoxModel();
        for (int i = 1; i < specnumber.length; i++) {
            dm.addElement(new ImagesNText(new ImageIcon(SetPath.STEPDATARESOURCE+"/"+specnumber[i]+"/xml/"+specnumber[i]+"_preview.png"), specnumber[i]));
        }
        return dm;
    }
}
