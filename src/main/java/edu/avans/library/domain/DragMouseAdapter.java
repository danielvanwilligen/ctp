package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.dragdropplacecounter;
import static edu.avans.library.presentation.JavaGUI.draggedimagename;
import static edu.avans.library.presentation.JavaGUI.newimageheight;
import static edu.avans.library.presentation.JavaGUI.newimagewidth;
import static edu.avans.library.presentation.JavaGUI.savebutton;
import static edu.avans.library.presentation.JavaGUI.savebuttonlocked;
import static edu.avans.library.presentation.JavaGUI.totalgridfieldsint;

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

	draggedimagename = c.getName();
	String nameshort = draggedimagename.substring(0,9);
	ImageIcon newdraggedimage = new ImageIcon(SetPath.stepdataresource+nameshort+"/"+draggedimagename);
	Image image = newdraggedimage.getImage();
        
	Component[] totalgridfields = centerpanel.getComponents();
	totalgridfieldsint = totalgridfields.length-1;
	JPanel gridField = (JPanel)totalgridfields[0];
	newimagewidth = gridField.getWidth()-10;
	newimageheight = gridField.getHeight()-10;
        
	Image newimg = image.getScaledInstance(newimagewidth, newimageheight,  java.awt.Image.SCALE_SMOOTH); 
	ImageIcon placeimage = new ImageIcon(newimg);
	JLabel gridFieldv1 = new JLabel(placeimage);
       
	TransferHandler handler = c.getTransferHandler();
	handler.exportAsDrag(c, e, TransferHandler.COPY);
        
	Component[] newtotalgridfields = centerpanel.getComponents();
	totalgridfieldsint = newtotalgridfields.length-1;
	if(newtotalgridfields[0] instanceof JPanel){
	    JPanel newgridField = (JPanel)newtotalgridfields[0];
	    Component[] newgridlabel = newgridField.getComponents();
	    if(newgridlabel[0] instanceof JLabel){
		JLabel gridFieldv2 = (JLabel)newgridlabel[0];
	    }   
	}

	// SET COUNTER
	dragdropplacecounter = dragdropplacecounter+1;
	if (dragdropplacecounter>=totalgridfieldsint){
	    savebutton.setVisible(true);
	    savebuttonlocked.setVisible(false);
	}
    }
}