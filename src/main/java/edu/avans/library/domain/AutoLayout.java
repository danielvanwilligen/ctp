package edu.avans.library.domain;

import static edu.avans.library.presentation.JavaGUI.autobutton;
import static edu.avans.library.presentation.JavaGUI.centerpanel;
import static edu.avans.library.presentation.JavaGUI.childcounter;
import static edu.avans.library.presentation.JavaGUI.frame;
import static edu.avans.library.presentation.JavaGUI.gridplacecounter;
import static edu.avans.library.presentation.JavaGUI.imagesequence;
import static edu.avans.library.presentation.JavaGUI.img;
import static edu.avans.library.presentation.JavaGUI.itemstoplaceint;
import static edu.avans.library.presentation.JavaGUI.itemsover;
import static edu.avans.library.presentation.JavaGUI.pathnameimage;
import static edu.avans.library.presentation.JavaGUI.savebutton;
import static edu.avans.library.presentation.JavaGUI.savebuttonlocked;
import static edu.avans.library.presentation.JavaGUI.specnrres;
import static edu.avans.library.presentation.JavaGUI.subrightpanel;
import static edu.avans.library.presentation.JavaGUI.totalgridfieldsint;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class AutoLayout {
    
    public void automaticlayout() {
	savebutton.setVisible(true);
        savebuttonlocked.setVisible(false);
                
        // GET ITEM COUNT
        Component[] items_to_place = subrightpanel.getComponents();
        itemstoplaceint = items_to_place.length;
        // GET GRID COUNT
        Component[] total_grid_fields = centerpanel.getComponents();
        totalgridfieldsint = total_grid_fields.length-1;
        // CALCULATE HOW MANY TIMES TO PLACE ONE ITEM
        double place_count = Math.floor((totalgridfieldsint/itemstoplaceint));

        frame.repaint();
                
        gridplacecounter = 1;
        childcounter = 0;

        String name_of_item_to_place = specnrres.getText();

        for (int i = 0; i < items_to_place.length; i++) {
            // SCALE IMAGE
            for (int j = 0; j < place_count; j++) {
                if (items_to_place.length>1){
		    int imagecounter = 1000 + gridplacecounter;
		    pathnameimage = SetPath.stepdataresource+name_of_item_to_place+"/"+name_of_item_to_place+"_"+imagecounter+".png";
		    imagesequence = imagesequence +name_of_item_to_place+"_"+imagecounter+"#";
                } else {
		    pathnameimage = SetPath.stepdataresource+name_of_item_to_place+"/"+name_of_item_to_place+".png";
                    imagesequence = imagesequence +name_of_item_to_place+"#";
                }
                ImageIcon placeimage = new ImageIcon(pathnameimage);
                Image image = placeimage.getImage();
                int currentimagewidth = placeimage.getIconWidth();
                int currentimageheight = placeimage.getIconHeight();
                int newimagewidth = total_grid_fields[0].getWidth()-10;
                int newimageheight = total_grid_fields[0].getHeight()-10;
                // Check if it's a Jpanel
                Image newimg = image.getScaledInstance(newimagewidth, newimageheight,  java.awt.Image.SCALE_SMOOTH); 
                placeimage = new ImageIcon(newimg);
                img = new JLabel(placeimage);
                if(total_grid_fields[childcounter] instanceof JPanel){
                    JPanel gridField = ((JPanel)total_grid_fields[childcounter]);
                    gridField.removeAll();
                    gridField.add(img);
                    frame.repaint();
                }
                childcounter=childcounter+1;
            }
            gridplacecounter = gridplacecounter +1;
        }
        gridplacecounter = gridplacecounter -1;
        itemsover = (totalgridfieldsint-(itemstoplaceint*place_count));
        gridplacecounter = 1;
        for (int i = 0; i < itemsover; i++) {
            if (items_to_place.length>1){
		int imagecounter = 1000 + gridplacecounter;
                pathnameimage = SetPath.stepdataresource+name_of_item_to_place+"/"+name_of_item_to_place+"_"+imagecounter+".png";
                imagesequence = imagesequence +name_of_item_to_place+"_"+imagecounter+"#";
            } else {
                pathnameimage = SetPath.stepdataresource+name_of_item_to_place+"/"+name_of_item_to_place+".png";
                imagesequence = imagesequence +name_of_item_to_place+"#";
            }
            ImageIcon placeimage = new ImageIcon(pathnameimage);
            Image image = placeimage.getImage();
            int currentimagewidth = placeimage.getIconWidth();
            int currentimageheight = placeimage.getIconHeight();
            int newimagewidth = total_grid_fields[0].getWidth()-10;
            int newimageheight = total_grid_fields[0].getHeight()-10;
            // Check if it's a Jpanel
            Image newimg = image.getScaledInstance(newimagewidth, newimageheight,  java.awt.Image.SCALE_SMOOTH); 
            placeimage = new ImageIcon(newimg);
            img = new JLabel(placeimage);
            if(total_grid_fields[childcounter] instanceof JPanel){
                JPanel gridField = ((JPanel)total_grid_fields[childcounter]);
                gridField.removeAll();
                gridField.add(img);
                frame.repaint();
            }
            childcounter=childcounter+1;
            gridplacecounter=gridplacecounter+1;
        }
        autobutton.setVisible(false);
        subrightpanel.removeAll();
    }
}