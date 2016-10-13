package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.black10b;
import static edu.avans.library.presentation.JavaGUI.black10g;
import static edu.avans.library.presentation.JavaGUI.black10r;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.currentblancoimageheight;
import static edu.avans.library.presentation.JavaGUI.currentblancoimagewidth;
import static edu.avans.library.presentation.JavaGUI.frame;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.itemsxresvalueint;
import static edu.avans.library.presentation.JavaGUI.itemsyresvalueint;
import static edu.avans.library.presentation.JavaGUI.navpanel;
import static edu.avans.library.presentation.JavaGUI.navsidepanel;
import static edu.avans.library.presentation.JavaGUI.newblancoimageheigth;
import static edu.avans.library.presentation.JavaGUI.newblancoimagewidth;
import static edu.avans.library.presentation.JavaGUI.newpanelheight;
import static edu.avans.library.presentation.JavaGUI.newpanelwidth;
import static edu.avans.library.presentation.JavaGUI.placeimage;
import static edu.avans.library.presentation.JavaGUI.screenheight;
import static edu.avans.library.presentation.JavaGUI.screenwidth;
import static edu.avans.library.presentation.JavaGUI.setgridx;
import static edu.avans.library.presentation.JavaGUI.setgridy;
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
	for (int k = 0; k < itemsyresvalueint; k++) {
	    for (int j = 0; j < itemsxresvalueint; j++) {
		// Set sub center panel
		subcenterpanel = new JPanel();
					
		subcenterpanel.setBackground(new Color(black10r,black10g,black10b));
		subcenterpanel.setBounds(setgridx, setgridy,newpanelwidth,newpanelheight);
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
		    currentblancoimagewidth = placeblancoimage.getIconWidth();
		    currentblancoimageheight = placeblancoimage.getIconHeight();
		    newblancoimagewidth = gridField.getWidth()-10;
		     newblancoimageheigth = gridField.getHeight()-10;
		    Image newblancoimg = blancoimage.getScaledInstance(newblancoimagewidth, newblancoimageheigth,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		    placeimage = new ImageIcon(newblancoimg);
		    img = new JLabel(placeimage);
		    img.setTransferHandler(new TransferHandler("icon"));
		    img.setName("blanco");
		    
		    subcenterpanel.add(img);
		}
					
		frame.revalidate();
		frame.repaint();
		setgridx = setgridx + newpanelwidth + 5;
	    }
	    setgridx = 5;
	    setgridy = setgridy + newpanelheight + 5;
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