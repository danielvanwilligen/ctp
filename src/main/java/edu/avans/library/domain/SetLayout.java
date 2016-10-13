package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.black10b;
import static edu.avans.library.presentation.JavaGUI.black10g;
import static edu.avans.library.presentation.JavaGUI.black10r;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.current_blancoimage_height;
import static edu.avans.library.presentation.JavaGUI.current_blancoimage_width;
import static edu.avans.library.presentation.JavaGUI.frame;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.items_xres_value_int;
import static edu.avans.library.presentation.JavaGUI.items_yres_value_int;
import static edu.avans.library.presentation.JavaGUI.navpanel;
import static edu.avans.library.presentation.JavaGUI.navsidepanel;
import static edu.avans.library.presentation.JavaGUI.new_blancoimage_heigth;
import static edu.avans.library.presentation.JavaGUI.new_blancoimage_width;
import static edu.avans.library.presentation.JavaGUI.new_panel_height;
import static edu.avans.library.presentation.JavaGUI.new_panel_width;
import static edu.avans.library.presentation.JavaGUI.placeimage;
import static edu.avans.library.presentation.JavaGUI.screenheight;
import static edu.avans.library.presentation.JavaGUI.screenwidth;
import static edu.avans.library.presentation.JavaGUI.set_grid_x;
import static edu.avans.library.presentation.JavaGUI.set_grid_y;
import static edu.avans.library.presentation.JavaGUI.subcenterpanel;
import static edu.avans.library.presentation.JavaGUI.total_grid_fields_int;
import static edu.avans.library.presentation.JavaGUI.x;
import static edu.avans.library.presentation.JavaGUI.y;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class SetLayout {
    
    public void createlayout(){
	for (int k = 0; k < items_yres_value_int; k++) {
	    for (int j = 0; j < items_xres_value_int; j++) {
		// Set sub center panel
		subcenterpanel = new JPanel();
					
		subcenterpanel.setBackground(new Color(black10r,black10g,black10b));
		subcenterpanel.setBounds(set_grid_x, set_grid_y,new_panel_width,new_panel_height);
		subcenterpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerpanel.add(subcenterpanel);
					
		Component[] total_grid_fields = centerpanel.getComponents();
		total_grid_fields_int = total_grid_fields.length-1;
					
		if(total_grid_fields[0] instanceof JPanel){
		    JPanel gridField = ((JPanel)total_grid_fields[0]);
		    gridField.getWidth();
		    gridField.getHeight();

		    ImageIcon placeblancoimage = new ImageIcon(SetPath.imageresource+"blanco.png");
		    Image blancoimage = placeblancoimage.getImage();
		    current_blancoimage_width = placeblancoimage.getIconWidth();
		    current_blancoimage_height = placeblancoimage.getIconHeight();
		    new_blancoimage_width = gridField.getWidth()-10;
		     new_blancoimage_heigth = gridField.getHeight()-10;
		    Image newblancoimg = blancoimage.getScaledInstance(new_blancoimage_width, new_blancoimage_heigth,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		    placeimage = new ImageIcon(newblancoimg);
		    img = new JLabel(placeimage);
		    img.setTransferHandler(new TransferHandler("icon"));
		    img.setName("blanco");
		    
		    subcenterpanel.add(img);
		}
					
		frame.revalidate();
		frame.repaint();
		set_grid_x = set_grid_x + new_panel_width + 5;
	    }
	    set_grid_x = 5;
	    set_grid_y = set_grid_y + new_panel_height + 5;
	}
	// Set subcenter panel		
	subcenterpanel = new JPanel();
	subcenterpanel.setBounds(x, y,(screenwidth-(2*navsidepanel)), ((screenheight-(2*navpanel))-20));
	subcenterpanel.setLayout(null);
	centerpanel.add(subcenterpanel);
				
	ImageIcon icon1 = new ImageIcon(SetPath.imageresource+"fuji_bg_scale.png");
	img = new JLabel(icon1);
	img.setBounds(x, y,(screenwidth-(2*navsidepanel)), ((screenheight-(2*navpanel))-15));
	subcenterpanel.add(img);
	frame.repaint();
    }
}