package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.centerpanelheight;
import static edu.avans.library.presentation.JavaGUI.centerpanelwidth;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.currentimageheight;
import static edu.avans.library.presentation.JavaGUI.currentimagewidth;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.itemsxresvalue;
import static edu.avans.library.presentation.JavaGUI.itemsxresvalueint;
import static edu.avans.library.presentation.JavaGUI.itemsyresvalue;
import static edu.avans.library.presentation.JavaGUI.itemsyresvalueint;
import static edu.avans.library.presentation.JavaGUI.name;
import static edu.avans.library.presentation.JavaGUI.newimageheigth;
import static edu.avans.library.presentation.JavaGUI.newimagewidth;
import static edu.avans.library.presentation.JavaGUI.newpanelheight;
import static edu.avans.library.presentation.JavaGUI.newpanelwidth;
import static edu.avans.library.presentation.JavaGUI.placeimage;
import static edu.avans.library.presentation.JavaGUI.setgridx;
import static edu.avans.library.presentation.JavaGUI.setgridy;
import static edu.avans.library.presentation.JavaGUI.subrightpanel;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class SetImages {

    public static final int FIVE = 5;
    public static final int TWOHUNDREDNINETY = 290;
    
    /**
    * setimagesrightpanel
    * setimagesrightpanel add images to the right panel 
    */
    public void setimagesrightpanel (){
        File imagelocation = new File(SetPath.STEPDATARESOURCE+name);
        String[] filenamelist = imagelocation.list();
        for (int i = 0; i < filenamelist.length; i++) {
            if (filenamelist[i].indexOf(".png")>0){
                
                // SCALE IMAGE
                placeimage = new ImageIcon(SetPath.STEPDATARESOURCE+name+"/"+filenamelist[i]);
                Image image = placeimage.getImage();
                currentimagewidth = placeimage.getIconWidth();
                currentimageheight = placeimage.getIconHeight();
                newimagewidth = TWOHUNDREDNINETY;
                newimageheigth = Math.round((currentimageheight * newimagewidth)/currentimagewidth);
                Image newimg = image.getScaledInstance(newimagewidth, newimageheigth,  java.awt.Image.SCALE_SMOOTH);
                placeimage = new ImageIcon(newimg);
                img = new JLabel(placeimage);
                img.setName(filenamelist[i]);
                // SET DRAG AND DROP
                MouseListener listener = new DragMouseAdapter();
                img.addMouseListener(listener);
                img.setTransferHandler(new TransferHandler("icon"));
                
                subrightpanel.add(img);
                
                centerpanelwidth = centerpanel.getWidth();
                centerpanelheight = centerpanel.getHeight();
                itemsxresvalueint = Math.round(Integer.parseInt(itemsxresvalue));
                itemsyresvalueint = Math.round(Integer.parseInt(itemsyresvalue));
                setgridx = FIVE;
                setgridy = FIVE;
                newpanelwidth = (centerpanelwidth-((itemsxresvalueint+1)*FIVE))/itemsxresvalueint;
                newpanelheight = (centerpanelheight-((itemsyresvalueint+1)*FIVE))/itemsyresvalueint;
                centerpanel.removeAll();
            }
        }
    }
}
