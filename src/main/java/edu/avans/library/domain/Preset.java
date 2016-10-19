package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.TWENTY;
import static edu.avans.library.presentation.JavaGUI.autobutton;
import static edu.avans.library.presentation.JavaGUI.bottompanel;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.frame;
import static edu.avans.library.presentation.JavaGUI.menustatus;
import static edu.avans.library.presentation.JavaGUI.navpanel;
import static edu.avans.library.presentation.JavaGUI.resetbutton;
import static edu.avans.library.presentation.JavaGUI.savebutton;
import static edu.avans.library.presentation.JavaGUI.savebuttonlocked;
import static edu.avans.library.presentation.JavaGUI.screenheight;
import static edu.avans.library.presentation.JavaGUI.screenwidth;
import static edu.avans.library.presentation.JavaGUI.subbottompanel;
import static edu.avans.library.presentation.JavaGUI.subrightpanel;
import static edu.avans.library.presentation.JavaGUI.x;
import static edu.avans.library.presentation.JavaGUI.y;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class Preset {
    /**
    * preset
    * preset the gui 
    */
    public void preset(){
        bottompanel.setBounds(x, y+screenheight-navpanel-TWENTY,screenwidth, navpanel);
        bottompanel.revalidate();
        bottompanel.repaint();
        subbottompanel.setVisible(false);
        savebutton.setVisible(false);
        savebuttonlocked.setVisible(true);
        resetbutton.setVisible(true);
        autobutton.setVisible(true);
        menustatus = "false";
        subrightpanel.removeAll();
        centerpanel.removeAll();
        frame.repaint();
    }
}
