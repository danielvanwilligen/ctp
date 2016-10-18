package edu.avans.library.domain;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetVariables {
    static JFrame frame;
    static JPanel bottompanel, subbottompanel, toppanel, leftpanel, centerpanel, subcenterpanel, rightpanel, subrightpanel, rightbuttonpanel, custom;    
    static JLabel img, specnrres, ordernrres, customerres, widthres, heightres, itemsxres, itemsyres, mfgres, singleres, dieshaperes, bleedres, specbuttonlocked, savebuttonlocked;
    static JButton specbutton, savebutton, resetbutton, autobutton;
    static ImageIcon placeimage;
    static Image draggedimage;
    static String[] imagesequencearray, cleanfirstimage;
    static String itemsxresvalue, itemsyresvalue, pathnameimage, xmloutput, imagesequence, draggedimagename, name, datestamp;

    static double itemsover, totalgridfieldsint, itemstoplaceint;
    static int gridplacecounter, childcounter, newimagewidth, newimageheight, x, y, navpanel, navsidepanel, screenwidth, screenheight, currentimagewidth, currentimageheight, newimageheigth, centerpanelwidth, centerpanelheight, itemsxresvalueint, itemsyresvalueint, setgridx, setgridy, newpanelwidth, newpanelheight, currentblancoimagewidth, currentblancoimageheight, newblancoimagewidth, newblancoimageheigth, savecounter, dragdropplacecounter;
    static boolean menustatus;
}
