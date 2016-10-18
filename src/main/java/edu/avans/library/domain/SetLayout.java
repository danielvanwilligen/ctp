package edu.avans.library.domain;

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
import static edu.avans.library.presentation.JavaGUI.totalgridfieldsint;
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

    public static final int TWO = 2;
    public static final int FIVE = 5;
    public static final int TEN = 10;
    public static final int FIFTEEN = 15;
    public static final int TWENTY = 20;
    public static final int TWOHUNDREDTHIRTYSIX = 236;
    
    /**
    * createlayout
    * createlayout creates a grid layout in the centerpanel 
    */
    public void createlayout(){
        for (int k = 0; k < itemsyresvalueint; k++) {
            for (int j = 0; j < itemsxresvalueint; j++) {
                // Set sub center panel
                subcenterpanel = new JPanel();
    
                // black 10%
                int black10r = TWOHUNDREDTHIRTYSIX;
                int black10g = TWOHUNDREDTHIRTYSIX;
                int black10b = TWOHUNDREDTHIRTYSIX;
                    
                subcenterpanel.setBackground(new Color(black10r,black10g,black10b));
                subcenterpanel.setBounds(setgridx, setgridy,newpanelwidth,newpanelheight);
                subcenterpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                centerpanel.add(subcenterpanel);
                    
                Component[] totalgridfields = centerpanel.getComponents();
                totalgridfieldsint = totalgridfields.length-1;
                    
                if(totalgridfields[0] instanceof JPanel){
                    JPanel gridField = (JPanel)totalgridfields[0];
                    gridField.getWidth();
                    gridField.getHeight();

                    ImageIcon placeblancoimage = new ImageIcon(SetPath.imageresource+"blanco.png");
                    Image blancoimage = placeblancoimage.getImage();
                    currentblancoimagewidth = placeblancoimage.getIconWidth();
                    currentblancoimageheight = placeblancoimage.getIconHeight();
                    newblancoimagewidth = gridField.getWidth()-TEN;
                    newblancoimageheigth = gridField.getHeight()-TEN;
                    Image newblancoimg = blancoimage.getScaledInstance(newblancoimagewidth, newblancoimageheigth,  java.awt.Image.SCALE_SMOOTH);
                    placeimage = new ImageIcon(newblancoimg);
                    img = new JLabel(placeimage);
                    img.setTransferHandler(new TransferHandler("icon"));
                    img.setName("blanco");
            
                    subcenterpanel.add(img);
                }
                    
                frame.revalidate();
                frame.repaint();
                setgridx = setgridx + newpanelwidth + FIVE;
            }
            setgridx = FIVE;
            setgridy = setgridy + newpanelheight + FIVE;
        }
        // Set subcenter panel        
        subcenterpanel = new JPanel();
        subcenterpanel.setBounds(x, y,screenwidth-TWO*navsidepanel, screenheight-TWO*navpanel-TWENTY);
        subcenterpanel.setLayout(null);
        centerpanel.add(subcenterpanel);
                
        ImageIcon icon1 = new ImageIcon(SetPath.imageresource+"fuji_bg_scale.png");
        img = new JLabel(icon1);
        img.setBounds(x, y,screenwidth-TWO*navsidepanel, screenheight-TWO*navpanel-FIFTEEN);
        subcenterpanel.add(img);
        frame.repaint();
    }
}