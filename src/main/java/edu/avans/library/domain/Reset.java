package edu.avans.library.domain;

import edu.avans.library.presentation.JavaGUI;
import edu.avans.library.domain.SetPath;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class Reset {

    public void resetgui()
    {
	JavaGUI.savebutton.setVisible(false);
        JavaGUI.savebuttonlocked.setVisible(false);
        JavaGUI.resetbutton.setVisible(false);
        JavaGUI.autobutton.setVisible(false);
        JavaGUI.specbutton.setVisible(true);
        JavaGUI.specbuttonlocked.setVisible(false);
	JavaGUI.specnrres.setText("-");
	JavaGUI.ordernrres.setText("-");
	JavaGUI.customerres.setText("-");
	JavaGUI.widthres.setText("-");
	JavaGUI.heightres.setText("-");
	JavaGUI.items_xres.setText("-");
	JavaGUI.items_yres.setText("-");
	JavaGUI.mfgres.setText("-");
	JavaGUI.singleres.setText("-");
	JavaGUI.dieshaperes.setText("-");
	JavaGUI.bleedres.setText("-");
	JavaGUI.subrightpanel.removeAll();
        JavaGUI.centerpanel.removeAll();
	JavaGUI.centerpanel.repaint();
                
        // Set subcenter panel
	JavaGUI.centerpanel.removeAll();
	JavaGUI.centerpanel.repaint();

        JavaGUI.subcenterpanel = new JPanel();
        JavaGUI.subcenterpanel.setBounds(JavaGUI.x, JavaGUI.y,(JavaGUI.screenwidth-(2*JavaGUI.navsidepanel)), ((JavaGUI.screenheight-(2*JavaGUI.navpanel))-20));
        JavaGUI.subcenterpanel.setLayout(null);
        JavaGUI.centerpanel.add(JavaGUI.subcenterpanel);
        ImageIcon icon1 = new ImageIcon(SetPath.imageresource+"fuji_bg_scale.png");
        JavaGUI.img = new JLabel(icon1);
        JavaGUI.img.setBounds(JavaGUI.x, JavaGUI.y,(JavaGUI.screenwidth-(2*JavaGUI.navsidepanel)), ((JavaGUI.screenheight-(2*JavaGUI.navpanel))-15));
        JavaGUI.subcenterpanel.add(JavaGUI.img);
        JavaGUI.frame.repaint();
	JavaGUI.imagesequence = "";
	
    }
    
}
