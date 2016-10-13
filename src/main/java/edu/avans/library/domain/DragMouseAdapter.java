package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.dragdrop_placecounter;
import static edu.avans.library.presentation.JavaGUI.draggedimagename;
import static edu.avans.library.presentation.JavaGUI.new_image_height;
import static edu.avans.library.presentation.JavaGUI.new_image_width;
import static edu.avans.library.presentation.JavaGUI.savebutton;
import static edu.avans.library.presentation.JavaGUI.savebuttonlocked;
import static edu.avans.library.presentation.JavaGUI.total_grid_fields_int;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class DragMouseAdapter extends MouseAdapter {	
    @Override
    public void mousePressed(MouseEvent e) {
	JComponent c = (JComponent) e.getSource();
	 //SET draggedimagename;
	draggedimagename = c.getName();
	String nameshort = draggedimagename.substring(0,9);
	ImageIcon newdraggedimage = new ImageIcon(SetPath.stepdataresource+nameshort+"/"+draggedimagename);
	Image image = newdraggedimage.getImage();
	    
	Component[] total_grid_fields = centerpanel.getComponents();
	total_grid_fields_int = total_grid_fields.length-1;
	JPanel gridField = ((JPanel)total_grid_fields[0]);
	new_image_width = gridField.getWidth()-10;
	new_image_height = gridField.getHeight()-10;
	    
	Image newimg = image.getScaledInstance(new_image_width, new_image_height,  java.awt.Image.SCALE_SMOOTH); 
	ImageIcon placeimage = new ImageIcon(newimg);
	JLabel componentreplace = new JLabel(placeimage);
	    
	//JOptionPane.showMessageDialog(null,placeimage);
	//JOptionPane.showMessageDialog(null,c.getName());
	//JOptionPane.showMessageDialog(null,componentreplace);
	   
	TransferHandler handler = c.getTransferHandler();
	handler.exportAsDrag(c, e, TransferHandler.COPY);
	    
	Component[] newtotal_grid_fields = centerpanel.getComponents();
	total_grid_fields_int = newtotal_grid_fields.length-1;
	//for (int i = 0; i < newtotal_grid_fields.length-1; i++) {
	if(newtotal_grid_fields[0] instanceof JPanel){
	    JPanel newgridField = ((JPanel)newtotal_grid_fields[0]);
	    Component[] newgridlabel = newgridField.getComponents();
	    if(newgridlabel[0] instanceof JLabel){
		JLabel placeitem = ((JLabel)newgridlabel[0]);
		//if ("blanco".equals(placeitem.getName())){
		//    JOptionPane.showMessageDialog(null,placeitem.getName());
		//}
	    }
	}

	// SET COUNTER
	dragdrop_placecounter = dragdrop_placecounter+1;
	if (dragdrop_placecounter>=total_grid_fields_int){
	    savebutton.setVisible(true);
	    savebuttonlocked.setVisible(false);
	}
    }
}