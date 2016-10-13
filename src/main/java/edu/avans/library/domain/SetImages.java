package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.centerpanelheight;
import static edu.avans.library.presentation.JavaGUI.centerpanelwidth;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.currentimageheight;
import static edu.avans.library.presentation.JavaGUI.current_image_width;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.items_xres_value;
import static edu.avans.library.presentation.JavaGUI.itemsxresvalueint;
import static edu.avans.library.presentation.JavaGUI.items_yres_value;
import static edu.avans.library.presentation.JavaGUI.itemsyresvalueint;
import static edu.avans.library.presentation.JavaGUI.name;
import static edu.avans.library.presentation.JavaGUI.newimageheigth;
import static edu.avans.library.presentation.JavaGUI.new_image_width;
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
    
    public void SetImagesRightPanel (){
	File imagelocation = new File(SetPath.stepdataresource+name);
	String[] filenamelist = imagelocation.list();
	for (int i = 0; i < filenamelist.length; i++) {
	    if (filenamelist[i].indexOf(".png")>0){
				
		// SCALE IMAGE
		placeimage = new ImageIcon(SetPath.stepdataresource+name+"/"+filenamelist[i]);
		Image image = placeimage.getImage();
		current_image_width = placeimage.getIconWidth();
		currentimageheight = placeimage.getIconHeight();
		new_image_width = 290;
		newimageheigth = Math.round(((currentimageheight * new_image_width)/current_image_width));
		Image newimg = image.getScaledInstance(new_image_width, newimageheigth,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
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
		itemsxresvalueint = Math.round(Integer.parseInt(items_xres_value));
		itemsyresvalueint = Math.round(Integer.parseInt(items_yres_value));
		setgridx = 5;
		setgridy = 5;
		newpanelwidth = ((centerpanelwidth-((itemsxresvalueint+1)*5))/itemsxresvalueint);
		newpanelheight = ((centerpanelheight-((itemsyresvalueint+1)*5))/itemsyresvalueint);
		centerpanel.removeAll();
	    }
	}
    }
}
