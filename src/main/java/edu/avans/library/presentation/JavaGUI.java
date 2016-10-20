package edu.avans.library.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import edu.avans.library.domain.SetPath;
import edu.avans.library.businesslogic.ProgramMgr;
import edu.avans.library.domain.Spec;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public final class JavaGUI {
    
    /**
    * Global variables
    * Creates global variables which can be called in all classes 
    */
    SetPath setallpaths = new SetPath();
    /**
    * IMAGERESOURCE
    * Path to GUI resource images 
    */
    private final String imageresource = setallpaths.getImageresource();
    /**
    * STEPDATARESOURCE
    * Path to order input folder 
    */
    private final String stepdataresource = setallpaths.getStepdataresource();
    public static final String ENTER = "\n";
    public static final String TAB = "\t";
    
    public static JFrame frame;
    public static JPanel bottompanel, subbottompanel, toppanel, leftpanel, centerpanel, subcenterpanel, rightpanel, subrightpanel, rightbuttonpanel, custom;    
    public static JLabel img, specnrres, ordernrres, customerres, widthres, heightres, itemsxres, itemsyres, mfgres, singleres, dieshaperes, bleedres, specbuttonlocked, savebuttonlocked;
    public static JButton specbutton, savebutton, resetbutton, autobutton;
    public static ImageIcon placeimage;
    protected static Image draggedimage;
    public static String[] imagesequencearray, cleanfirstimage;
    public static String itemsxresvalue, itemsyresvalue, pathnameimage, xmloutput, imagesequence, draggedimagename, name, datestamp, menustatus;

    public static double itemsover, totalgridfieldsint, itemstoplaceint;
    public static int gridplacecounter, childcounter, newimagewidth, newimageheight, x, y, navpanel, navsidepanel, screenwidth, screenheight, currentimagewidth, currentimageheight, newimageheigth, centerpanelwidth, centerpanelheight, itemsxresvalueint, itemsyresvalueint, setgridx, setgridy, newpanelwidth, newpanelheight, currentblancoimagewidth, currentblancoimageheight, newblancoimagewidth, newblancoimageheigth, savecounter, dragdropplacecounter;

    public static final int TWO = 2;
    public static final int ELEVEN = 11;
    public static final int FIFTEEN = 15;
    public static final int TWENTY = 20;
    public static final int THIRTY = 30;
    public static final int SEVENTY = 70;
    public static final int NINETY = 90;
    public static final int ONEHUNDRED = 100;
    public static final int ONEHUNDREDTEN = 110;
    public static final int ONEHUNDREDTWENTY = 120;
    public static final int TWOHUNDRED = 200;
    public static final int TWOHUNDREDTEN = 210;
    public static final int TWOHUNDREDELEVEN = 211;
    public static final int TWOHUNDREDTWELVE = 212;
    public static final int TWOHUNDREDTHIRTYSIX = 236;
    public static final int THREEHUNDRED = 300;

    public JavaGUI(){
       gui();
    }
    
    /**
    * Build gui
    */
    public void gui(){
        String state = "false";
        menustatus = state;

        // black 20%
        int bgcrSideMenu = TWOHUNDREDTEN;
        int bgcgSideMenu = TWOHUNDREDELEVEN;
        int bgcbSideMenu = TWOHUNDREDTWELVE;
        
        navpanel = NINETY;
        navsidepanel = THREEHUNDRED;
        x = 0;
        y = 0;
        screenwidth = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        screenheight = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    
        // Set Main frame
        frame = new JFrame("Step and Repeat");
        frame.setVisible(true);
        frame.setSize(screenwidth,screenheight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Create Buttons
        specbutton = new JButton();
        savebutton = new JButton();
        resetbutton = new JButton();
        autobutton = new JButton();

        // Set bottom panel
        bottompanel = new JPanel();
        bottompanel.setBackground(Color.WHITE);
        bottompanel.setBounds(x, y+screenheight-navpanel-TWENTY,screenwidth, navpanel);
        frame.add(bottompanel);
        bottompanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        ImageIcon bottomspacer = new ImageIcon(imageresource+"spacer.png");
        img = new JLabel(bottomspacer);
        bottompanel.add(img);

        // Set right panel
        rightpanel = new JPanel();
        rightpanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
        rightpanel.setBounds(x+screenwidth-navsidepanel, y+navpanel,navsidepanel, screenheight-TWO*navpanel-TWENTY);
        rightpanel.setLayout(null);

        ImageIcon rigthinfoheader = new ImageIcon(imageresource+"images.png");
        JLabel  imgimages = new JLabel(rigthinfoheader);
        imgimages.setSize(THREEHUNDRED, NINETY);
        imgimages.setLocation(0, 0);
        rightpanel.add(imgimages);
        rightpanel.revalidate();
        frame.repaint();
        frame.add(rightpanel);

        // Set sub right panel
        subrightpanel = new JPanel();
        subrightpanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
        subrightpanel.setBounds(x, y+NINETY,navsidepanel, screenheight-TWO*navpanel-ONEHUNDREDTEN);
        subrightpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightpanel.add(subrightpanel);

        /**
        * Specbutton
        * Orderbutton will show the submenu 
        */
        specbutton.setIcon(new ImageIcon(imageresource+"spec.png"));
        specbutton.setMargin(new Insets(0, 0, 0, 0));
        specbutton.setBorder(null);
        specbutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                specbutton.setIcon(new ImageIcon(imageresource+"spec_hover.png"));
                specbutton.setMargin(new Insets(0, 0, 0, 0));
                specbutton.setBorder(null);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                specbutton.setIcon(new ImageIcon(imageresource+"spec.png"));
                specbutton.setMargin(new Insets(0, 0, 0, 0));
                specbutton.setBorder(null);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                Spec spec = new Spec();
                spec.createspec();
            }
        });
        bottompanel.add(specbutton);

        //SET SPECBUTTON LOCKED
        ImageIcon speclocked = new ImageIcon(imageresource+"speclocked.png");
        specbuttonlocked = new JLabel(speclocked);
        bottompanel.add(specbuttonlocked);
        specbuttonlocked.setVisible(false);

        /**
        * Savebutton
        * Savebutton will be created 
        */
        savebutton.setIcon(new ImageIcon(imageresource+"save.png"));
        savebutton.setMargin(new Insets(0, 0, 0, 0));
        savebutton.setBorder(null);
        savebutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                savebutton.setIcon(new ImageIcon(imageresource+"save_hover.png"));
                savebutton.setMargin(new Insets(0, 0, 0, 0));
                savebutton.setBorder(null);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                savebutton.setIcon(new ImageIcon(imageresource+"save.png"));
                savebutton.setMargin(new Insets(0, 0, 0, 0));
                savebutton.setBorder(null);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                ProgramMgr mgrsavexml = new ProgramMgr();
                mgrsavexml.mgrwritedata();
            }
        });
        bottompanel.add(savebutton);
        savebutton.setVisible(false);

        //SET SPECBUTTON LOCKED
        ImageIcon savelocked = new ImageIcon(imageresource+"savelocked.png");
        savebuttonlocked = new JLabel(savelocked);
        bottompanel.add(savebuttonlocked);
        savebuttonlocked.setVisible(false);

        /**
        * Resetbutton
        * Resetbutton will be created 
        */
        resetbutton.setIcon(new ImageIcon(imageresource+"reset.png"));
        resetbutton.setMargin(new Insets(0, 0, 0, 0));
        resetbutton.setBorder(null);
        resetbutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                resetbutton.setIcon(new ImageIcon(imageresource+"reset_hover.png"));
                resetbutton.setMargin(new Insets(0, 0, 0, 0));
                resetbutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                resetbutton.setIcon(new ImageIcon(imageresource+"reset.png"));
                resetbutton.setMargin(new Insets(0, 0, 0, 0));
                resetbutton.setBorder(null);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                ProgramMgr mgrresetGuiInterface = new ProgramMgr();
                mgrresetGuiInterface.mgrreset();
            }
        });
        bottompanel.add(resetbutton);
        resetbutton.setVisible(false);

        /**
        * Autobutton
        * Autobutton will be created creates an automatic layout. 
        */
        autobutton.setIcon(new ImageIcon(imageresource+"auto.png"));
        autobutton.setMargin(new Insets(0, 0, 0, 0));
        autobutton.setBorder(null);
        autobutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                autobutton.setIcon(new ImageIcon(imageresource+"auto_hover.png"));
                autobutton.setMargin(new Insets(0, 0, 0, 0));
                autobutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                autobutton.setIcon(new ImageIcon(imageresource+"auto.png"));
                autobutton.setMargin(new Insets(0, 0, 0, 0));
                autobutton.setBorder(null);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                ProgramMgr mgrnewlayout = new ProgramMgr();
                mgrnewlayout.mgrautolayout();
            }
        });
        bottompanel.add(autobutton);
        autobutton.setVisible(false);

        // Set left panel
        leftpanel = new JPanel();
        leftpanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
        leftpanel.setBounds(x, y+navpanel,navsidepanel, screenheight-TWO*navpanel-TWENTY);
        leftpanel.setLayout(null);

        ImageIcon leftinfoheader = new ImageIcon(imageresource+"info.png");
        JLabel  imginfo = new JLabel(leftinfoheader);
        imginfo.setSize(THREEHUNDRED, NINETY);
        imginfo.setLocation(0, 0);
        leftpanel.add(imginfo);
        leftpanel.revalidate();
        leftpanel.repaint();

        int sizex = ONEHUNDRED;
        int sizey = THIRTY;
        int positionx = THIRTY;
        int positiony = ONEHUNDREDTWENTY;
        String [] labels = {"SPECNR", "ORDERNR", "CUSTOMER", "WIDTH", "HEIGHT", "ITEMS X", "ITEMS Y", "MFG", "SINGLE", "DIESHAPE", "BLEED"};
    
        for (int i = 0; i < ELEVEN; i++) {
            JLabel leftpanellabel = new JLabel(labels[i], JLabel.LEFT);
            leftpanellabel.setSize(sizex ,sizey);
            leftpanellabel.setLocation(positionx, positiony);
            leftpanel.add(leftpanellabel);
        
            JLabel doubledot = new JLabel(":", JLabel.LEFT);
            sizex = sizex-SEVENTY;
            positionx = positionx+ONEHUNDRED;
            doubledot.setSize(sizex ,sizey);
            doubledot.setLocation(positionx, positiony);
            leftpanel.add(doubledot);
            sizex = sizex+SEVENTY;
            positionx = positionx-ONEHUNDRED;
        
            positiony = positiony +THIRTY;
        }
    
        positionx = positionx+ONEHUNDREDTEN;
        positiony = ONEHUNDREDTWENTY;
        specnrres = new JLabel("-", JLabel.LEFT);
        specnrres.setSize(sizex ,sizey); 
        specnrres.setLocation(positionx, positiony);
        leftpanel.add(specnrres);
        positiony = positiony +THIRTY;
        ordernrres = new JLabel("-", JLabel.LEFT);
        ordernrres.setSize(sizex ,sizey);
        ordernrres.setLocation(positionx, positiony);
        leftpanel.add(ordernrres);
        positiony = positiony +THIRTY;
        customerres = new JLabel("-", JLabel.LEFT);
        customerres.setSize(sizex ,sizey); 
        customerres.setLocation(positionx, positiony);
        leftpanel.add(customerres);
        positiony = positiony +THIRTY;
        widthres = new JLabel("-", JLabel.LEFT);
        widthres.setSize(sizex ,sizey);
        widthres.setLocation(positionx, positiony);
        leftpanel.add(widthres);
        positiony = positiony +THIRTY;
        heightres = new JLabel("-", JLabel.LEFT);
        heightres.setSize(sizex ,sizey);
        heightres.setLocation(positionx, positiony);
        leftpanel.add(heightres);
        positiony = positiony +THIRTY;
        itemsxres = new JLabel("-", JLabel.LEFT);
        itemsxres.setSize(sizex ,sizey);
        itemsxres.setLocation(positionx, positiony);
        leftpanel.add(itemsxres);
        positiony = positiony +THIRTY;
        itemsyres = new JLabel("-", JLabel.LEFT);
        itemsyres.setSize(sizex ,sizey);
        itemsyres.setLocation(positionx, positiony);
        leftpanel.add(itemsyres);
        positiony = positiony +THIRTY;
        mfgres = new JLabel("-", JLabel.LEFT);
        mfgres.setSize(sizex ,sizey); 
        mfgres.setLocation(positionx, positiony);
        leftpanel.add(mfgres);
        positiony = positiony +THIRTY;
        singleres = new JLabel("-", JLabel.LEFT);
        singleres.setSize(sizex ,sizey);
        singleres.setLocation(positionx, positiony);
        leftpanel.add(singleres);
        positiony = positiony +THIRTY;
        dieshaperes = new JLabel("-", JLabel.LEFT);
        dieshaperes.setSize(sizex ,sizey);
        dieshaperes.setLocation(positionx, positiony);
        leftpanel.add(dieshaperes);
        positiony = positiony +THIRTY;
        bleedres = new JLabel("-", JLabel.LEFT);
        bleedres.setSize(sizex ,sizey);
        bleedres.setLocation(positionx, positiony);
        leftpanel.add(bleedres);

        frame.repaint();
        frame.add(leftpanel);

        // Set center panel
        centerpanel = new JPanel();
        centerpanel.setBackground(Color.GRAY);
        centerpanel.setBounds(x+navsidepanel, y+navpanel,screenwidth-TWO*navsidepanel, screenheight-TWO*navpanel-TWENTY);
        centerpanel.setLayout(null);
        frame.add(centerpanel);

        // Set subcenter panel
        subcenterpanel = new JPanel();
        subcenterpanel.setBounds(x, y,screenwidth-TWO*navsidepanel, screenheight-TWO*navpanel-TWENTY);
        subcenterpanel.setLayout(null);
        centerpanel.add(subcenterpanel);
        ImageIcon icon1 = new ImageIcon(imageresource+"fuji_bg_scale.png");
        img = new JLabel(icon1);
        img.setBounds(x, y,screenwidth-TWO*navsidepanel, screenheight-TWO*navpanel-FIFTEEN);
        subcenterpanel.add(img);
        frame.repaint();

        // Set top panel
        toppanel = new JPanel();
        toppanel.setBackground(Color.WHITE);
        toppanel.setBounds(x, y,screenwidth, navpanel);
        frame.add(toppanel);
        
        ImageIcon topspacer = new ImageIcon(imageresource+"spacer.png");
        img = new JLabel(topspacer);
        toppanel.add(img);
        
        ImageIcon icon2 = new ImageIcon(imageresource+"avans.png");
        img = new JLabel(icon2);
        toppanel.add(img);
        ImageIcon icon3 = new ImageIcon(imageresource+"stepandrepeat.png");
        img = new JLabel(icon3);
        toppanel.add(img);
        toppanel.revalidate();
        toppanel.repaint();
        toppanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}