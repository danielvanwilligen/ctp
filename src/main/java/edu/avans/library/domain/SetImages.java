package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.center_panel_height;
import static edu.avans.library.presentation.JavaGUI.center_panel_width;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.current_image_height;
import static edu.avans.library.presentation.JavaGUI.current_image_width;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.items_xres_value;
import static edu.avans.library.presentation.JavaGUI.items_xres_value_int;
import static edu.avans.library.presentation.JavaGUI.items_yres_value;
import static edu.avans.library.presentation.JavaGUI.items_yres_value_int;
import static edu.avans.library.presentation.JavaGUI.name;
import static edu.avans.library.presentation.JavaGUI.new_image_heigth;
import static edu.avans.library.presentation.JavaGUI.new_image_width;
import static edu.avans.library.presentation.JavaGUI.new_panel_height;
import static edu.avans.library.presentation.JavaGUI.new_panel_width;
import static edu.avans.library.presentation.JavaGUI.placeimage;
import static edu.avans.library.presentation.JavaGUI.set_grid_x;
import static edu.avans.library.presentation.JavaGUI.set_grid_y;
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
		current_image_height = placeimage.getIconHeight();
		new_image_width = 290; //290
		new_image_heigth = Math.round(((current_image_height * new_image_width)/current_image_width));
		Image newimg = image.getScaledInstance(new_image_width, new_image_heigth,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		placeimage = new ImageIcon(newimg);
		img = new JLabel(placeimage);
		img.setName(filenamelist[i]);
		// SET DRAG AND DROP
		MouseListener listener = new DragMouseAdapter();
		img.addMouseListener(listener);
		img.setTransferHandler(new TransferHandler("icon"));
				
		subrightpanel.add(img);
				
		center_panel_width = centerpanel.getWidth();
		center_panel_height = centerpanel.getHeight();
		items_xres_value_int = Math.round(Integer.parseInt(items_xres_value));
		items_yres_value_int = Math.round(Integer.parseInt(items_yres_value));
		set_grid_x = 5;
		set_grid_y = 5;
		new_panel_width = ((center_panel_width-((items_xres_value_int+1)*5))/items_xres_value_int);
		new_panel_height = ((center_panel_height-((items_yres_value_int+1)*5))/items_yres_value_int);
		centerpanel.removeAll();
	    }
	}
    }
}
