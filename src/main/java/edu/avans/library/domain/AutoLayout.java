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
    /**
    * automaticlayout
    * automaticlayout creates an automatic image layout in the centerpanel
    */
    public void automaticlayout() {
        savebutton.setVisible(true);
        savebuttonlocked.setVisible(false);
                
        // GET ITEM COUNT
        Component[] itemstoplace = subrightpanel.getComponents();
        itemstoplaceint = itemstoplace.length;
        // GET GRID COUNT
        Component[] totalgridfields = centerpanel.getComponents();
        totalgridfieldsint = totalgridfields.length-1;
        // CALCULATE HOW MANY TIMES TO PLACE ONE ITEM
        double placecount = Math.floor(totalgridfieldsint/itemstoplaceint);

        frame.repaint();
                
        gridplacecounter = 1;
        childcounter = 0;

        String nameofitemtoplace = specnrres.getText();

        for (int i = 0; i < itemstoplace.length; i++) {
            // SCALE IMAGE
            for (int j = 0; j < placecount; j++) {
                if (itemstoplace.length>1){
                    int imagecounter = 1000 + gridplacecounter;
                    pathnameimage = SetPath.stepdataresource+nameofitemtoplace+"/"+nameofitemtoplace+"_"+imagecounter+".png";
                    imagesequence = imagesequence +nameofitemtoplace+"_"+imagecounter+"#";
                } else {
                    pathnameimage = SetPath.stepdataresource+nameofitemtoplace+"/"+nameofitemtoplace+".png";
                    imagesequence = imagesequence +nameofitemtoplace+"#";
                }
                ImageIcon placeimage = new ImageIcon(pathnameimage);
                Image image = placeimage.getImage();
                int newimagewidth = totalgridfields[0].getWidth()-10;
                int newimageheight = totalgridfields[0].getHeight()-10;
                // Check if it's a Jpanel
                Image newimg = image.getScaledInstance(newimagewidth, newimageheight,  java.awt.Image.SCALE_SMOOTH); 
                placeimage = new ImageIcon(newimg);
                img = new JLabel(placeimage);
                if(totalgridfields[childcounter] instanceof JPanel){
                    JPanel gridField = (JPanel)totalgridfields[childcounter];
                    gridField.removeAll();
                    gridField.add(img);
                    frame.repaint();
                }
                childcounter=childcounter+1;
            }
            gridplacecounter = gridplacecounter +1;
        }
        gridplacecounter = gridplacecounter -1;
        itemsover = totalgridfieldsint-(itemstoplaceint*placecount);
        gridplacecounter = 1;
        for (int i = 0; i < itemsover; i++) {
            if (itemstoplace.length>1){
                int imagecounter = 1000 + gridplacecounter;
                pathnameimage = SetPath.stepdataresource+nameofitemtoplace+"/"+nameofitemtoplace+"_"+imagecounter+".png";
                imagesequence = imagesequence +nameofitemtoplace+"_"+imagecounter+"#";
            } else {
                pathnameimage = SetPath.stepdataresource+nameofitemtoplace+"/"+nameofitemtoplace+".png";
                imagesequence = imagesequence +nameofitemtoplace+"#";
            }
            ImageIcon placeimage = new ImageIcon(pathnameimage);
            Image image = placeimage.getImage();
            int newimagewidth = totalgridfields[0].getWidth()-10;
            int newimageheight = totalgridfields[0].getHeight()-10;
            // Check if it's a Jpanel
            Image newimg = image.getScaledInstance(newimagewidth, newimageheight,  java.awt.Image.SCALE_SMOOTH); 
            placeimage = new ImageIcon(newimg);
            img = new JLabel(placeimage);
            if(totalgridfields[childcounter] instanceof JPanel){
                JPanel gridField = (JPanel)totalgridfields[childcounter];
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