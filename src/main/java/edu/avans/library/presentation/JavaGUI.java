package edu.avans.library.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import edu.avans.library.domain.SetPath;
import edu.avans.library.domain.ImagesNText;
import edu.avans.library.domain.ImagesTextRenderer;
import edu.avans.library.domain.SetImages;
import edu.avans.library.businesslogic.ProgramMgr;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

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
    private final String IMAGERESOURCE = setallpaths.getImageresource();
    /**
    * STEPDATARESOURCE
    * Path to order input folder 
    */
    private final String STEPDATARESOURCE = setallpaths.getStepdataresource();
    /**
    * STEPDATAOUTPUT
    * Path to xml output folder 
    */
    private final String STEPDATAOUTPUT = setallpaths.getStepdataoutput();
    public static final String ENTER = "\n";
    public static final String TAB = "\t";
    
    public static JFrame frame;
    public static JPanel bottompanel, subbottompanel, toppanel, leftpanel, centerpanel, subcenterpanel, rightpanel, subrightpanel, rightbuttonpanel, custom;    
    public static JLabel img, specnrres, ordernrres, customerres, widthres, heightres, itemsxres, itemsyres, mfgres, singleres, dieshaperes, bleedres, specbuttonlocked, savebuttonlocked;
    public static JButton specbutton, savebutton, resetbutton, autobutton;
    public static ImageIcon placeimage;
    public static Image draggedimage;
    public static String[] imagesequencearray, cleanfirstimage;
    public static String itemsxresvalue, itemsyresvalue, pathnameimage, xmloutput, imagesequence, draggedimagename, name, datestamp;
    //public static String[] imagesequencearray, cleanfirstimage;

    public static double itemsover, totalgridfieldsint, itemstoplaceint;
    public static int gridplacecounter, childcounter, newimagewidth, newimageheight, x, y, navpanel, navsidepanel, screenwidth, screenheight, currentimagewidth, currentimageheight, newimageheigth, centerpanelwidth, centerpanelheight, itemsxresvalueint, itemsyresvalueint, setgridx, setgridy, newpanelwidth, newpanelheight, currentblancoimagewidth, currentblancoimageheight, newblancoimagewidth, newblancoimageheigth, savecounter, dragdropplacecounter;
    public static boolean menustatus;

    public JavaGUI(){
       gui();
    }
    
    /**
    * Build gui
    */
    public void gui(){
        menustatus = false;

        // black 20%
        int bgcrSideMenu = 210;
        int bgcgSideMenu = 211;
        int bgcbSideMenu = 212;

        // black 10%
        int black10r = 236;
        int black10g = 236;
        int black10b = 236;

        navpanel = 90;
        navsidepanel = 300;
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
        bottompanel.setBounds(x, y+screenheight-navpanel-20,screenwidth, navpanel);
        frame.add(bottompanel);
        bottompanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        ImageIcon bottomspacer = new ImageIcon(IMAGERESOURCE+"spacer.png");
        img = new JLabel(bottomspacer);
        bottompanel.add(img);

        // Set right panel
        rightpanel = new JPanel();
        rightpanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
        rightpanel.setBounds(x+screenwidth-navsidepanel, y+navpanel,navsidepanel, screenheight-2*navpanel-20);
        rightpanel.setLayout(null);

        ImageIcon rigthinfoheader = new ImageIcon(IMAGERESOURCE+"images.png");
        JLabel  imgimages = new JLabel(rigthinfoheader);
        imgimages.setSize(300, 90);
        imgimages.setLocation(0, 0);
        rightpanel.add(imgimages);
        rightpanel.revalidate();
        frame.repaint();
        frame.add(rightpanel);

        // Set sub right panel
        subrightpanel = new JPanel();
        subrightpanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
        subrightpanel.setBounds(x, y+90,navsidepanel, screenheight-2*navpanel-110);
        subrightpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightpanel.add(subrightpanel);

        /**
        * Specbutton
        * Orderbutton will show the submenu 
        */
        specbutton.setIcon(new ImageIcon(IMAGERESOURCE+"spec.png"));
        specbutton.setMargin(new Insets(0, 0, 0, 0));
        specbutton.setBorder(null);
        specbutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                specbutton.setIcon(new ImageIcon(IMAGERESOURCE+"spec_hover.png"));
                specbutton.setMargin(new Insets(0, 0, 0, 0));
                specbutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                specbutton.setIcon(new ImageIcon(IMAGERESOURCE+"spec.png"));
                specbutton.setMargin(new Insets(0, 0, 0, 0));
                specbutton.setBorder(null);
            }

            /**
            * Specbutton mousereleased
            * Create the submenu 
            */
            @Override
            public void mouseReleased(MouseEvent evt){
                specbutton.setVisible(false);
                specbuttonlocked.setVisible(true);
                frame.repaint();
                if (menustatus==false){
                    bottompanel.setBounds(x, y+screenheight-navpanel-110,screenwidth, navpanel);
                    bottompanel.revalidate();
                    bottompanel.repaint();

                    subbottompanel = new JPanel(null);
                    subbottompanel.setBackground(new Color(bgcrSideMenu,bgcgSideMenu,bgcbSideMenu));
                    subbottompanel.setBounds(x, y+screenheight-navpanel-20,screenwidth, navpanel);
                    frame.add(subbottompanel);
                    subbottompanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    ImageIcon bottomspacer = new ImageIcon(IMAGERESOURCE+"spacer_gray.png");
                    img = new JLabel(bottomspacer);
                    subbottompanel.add(img);
                    
                    final JComboBox combo = new JComboBox();

                    // SIZE HEIGTH DOES NOT WORK
                    Dimension preferredSize = combo.getPreferredSize();
                    preferredSize.height = 100;
                    preferredSize.width = 200;
                    combo.setPreferredSize(preferredSize);

                    combo.setModel(populate());
                    combo.setRenderer(new ImagesTextRenderer());

                    //EVENTS
                    combo.addActionListener((ActionEvent arg0) -> {
                    bottompanel.setBounds(x, y+screenheight-navpanel-20,screenwidth, navpanel);
                    bottompanel.revalidate();
                    bottompanel.repaint();
                    subbottompanel.setVisible(false);
                    savebutton.setVisible(false);
                    savebuttonlocked.setVisible(true);
                    resetbutton.setVisible(true);
                    autobutton.setVisible(true);
                    menustatus = false;
                    name=((ImagesNText)combo.getSelectedItem()).getName();
                    subrightpanel.removeAll();
                    centerpanel.removeAll();
                    frame.repaint();
            
                    ProgramMgr getdata = new ProgramMgr();
                    try {
                        getdata.mgrreaddata();
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    SetImages setimagespanel = new SetImages();
                    setimagespanel.setimagesrightpanel();

                        ProgramMgr mgrcenterlayout = new ProgramMgr();
                        mgrcenterlayout.mgrsetlayout();

                    });
                    subbottompanel.add(combo);
                    frame.repaint();
                    menustatus = true;
                } else {
                    bottompanel.setBounds(x, y+screenheight-navpanel+20,screenwidth, navpanel);
                    bottompanel.revalidate();
                    bottompanel.repaint();
                    subbottompanel.setVisible(false);
                    frame.repaint();
                    menustatus = false;
                }
        
            }
        });
        bottompanel.add(specbutton);

        //SET SPECBUTTON LOCKED
        ImageIcon speclocked = new ImageIcon(IMAGERESOURCE+"speclocked.png");
        specbuttonlocked = new JLabel(speclocked);
        bottompanel.add(specbuttonlocked);
        specbuttonlocked.setVisible(false);

        /**
        * Savebutton
        * Savebutton will be created 
        */
        savebutton.setIcon(new ImageIcon(IMAGERESOURCE+"save.png"));
        savebutton.setMargin(new Insets(0, 0, 0, 0));
        savebutton.setBorder(null);
        savebutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                savebutton.setIcon(new ImageIcon(IMAGERESOURCE+"save_hover.png"));
                savebutton.setMargin(new Insets(0, 0, 0, 0));
                savebutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                savebutton.setIcon(new ImageIcon(IMAGERESOURCE+"save.png"));
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
        ImageIcon savelocked = new ImageIcon(IMAGERESOURCE+"savelocked.png");
        savebuttonlocked = new JLabel(savelocked);
        bottompanel.add(savebuttonlocked);
        savebuttonlocked.setVisible(false);

        /**
        * Resetbutton
        * Resetbutton will be created 
        */
        resetbutton.setIcon(new ImageIcon(IMAGERESOURCE+"reset.png"));
        resetbutton.setMargin(new Insets(0, 0, 0, 0));
        resetbutton.setBorder(null);
        resetbutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                resetbutton.setIcon(new ImageIcon(IMAGERESOURCE+"reset_hover.png"));
                resetbutton.setMargin(new Insets(0, 0, 0, 0));
                resetbutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                resetbutton.setIcon(new ImageIcon(IMAGERESOURCE+"reset.png"));
                resetbutton.setMargin(new Insets(0, 0, 0, 0));
                resetbutton.setBorder(null);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                // RESET THE INTERFACE
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
        autobutton.setIcon(new ImageIcon(IMAGERESOURCE+"auto.png"));
        autobutton.setMargin(new Insets(0, 0, 0, 0));
        autobutton.setBorder(null);
        autobutton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                autobutton.setIcon(new ImageIcon(IMAGERESOURCE+"auto_hover.png"));
                autobutton.setMargin(new Insets(0, 0, 0, 0));
                autobutton.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent evt){
                autobutton.setIcon(new ImageIcon(IMAGERESOURCE+"auto.png"));
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
        leftpanel.setBounds(x, y+navpanel,navsidepanel, screenheight-2*navpanel-20);
        leftpanel.setLayout(null);

        ImageIcon leftinfoheader = new ImageIcon(IMAGERESOURCE+"info.png");
        JLabel  imginfo = new JLabel(leftinfoheader);
        imginfo.setSize(300, 90);
        imginfo.setLocation(0, 0);
        leftpanel.add(imginfo);
        leftpanel.revalidate();
        leftpanel.repaint();

        int sizex = 100;
        int sizey = 30;
        int positionx = 30;
        int positiony = 120;
        String [] labels = {"SPECNR", "ORDERNR", "CUSTOMER", "WIDTH", "HEIGHT", "ITEMS X", "ITEMS Y", "MFG", "SINGLE", "DIESHAPE", "BLEED"};
    
        for (int i = 0; i < 11; i++) {
            JLabel leftpanellabel = new JLabel(labels[i], JLabel.LEFT);
            leftpanellabel.setSize(sizex ,sizey);
            leftpanellabel.setLocation(positionx, positiony);
            leftpanel.add(leftpanellabel);
        
            JLabel doubledot = new JLabel(":", JLabel.LEFT);
            sizex = sizex-70;
            positionx = positionx+100;
            doubledot.setSize(sizex ,sizey);
            doubledot.setLocation(positionx, positiony);
            leftpanel.add(doubledot);
            sizex = sizex+70;
            positionx = positionx-100;
        
            positiony = positiony +30;
        }
    
        positionx = positionx+110;
        positiony = 120;
        specnrres = new JLabel("-", JLabel.LEFT);
        specnrres.setSize(sizex ,sizey); 
        specnrres.setLocation(positionx, positiony);
        leftpanel.add(specnrres);
        positiony = positiony +30;
        ordernrres = new JLabel("-", JLabel.LEFT);
        ordernrres.setSize(sizex ,sizey);
        ordernrres.setLocation(positionx, positiony);
        leftpanel.add(ordernrres);
        positiony = positiony +30;
        customerres = new JLabel("-", JLabel.LEFT);
        customerres.setSize(sizex ,sizey); 
        customerres.setLocation(positionx, positiony);
        leftpanel.add(customerres);
        positiony = positiony +30;
        widthres = new JLabel("-", JLabel.LEFT);
        widthres.setSize(sizex ,sizey);
        widthres.setLocation(positionx, positiony);
        leftpanel.add(widthres);
        positiony = positiony +30;
        heightres = new JLabel("-", JLabel.LEFT);
        heightres.setSize(sizex ,sizey);
        heightres.setLocation(positionx, positiony);
        leftpanel.add(heightres);
        positiony = positiony +30;
        itemsxres = new JLabel("-", JLabel.LEFT);
        itemsxres.setSize(sizex ,sizey);
        itemsxres.setLocation(positionx, positiony);
        leftpanel.add(itemsxres);
        positiony = positiony +30;
        itemsyres = new JLabel("-", JLabel.LEFT);
        itemsyres.setSize(sizex ,sizey);
        itemsyres.setLocation(positionx, positiony);
        leftpanel.add(itemsyres);
        positiony = positiony +30;
        mfgres = new JLabel("-", JLabel.LEFT);
        mfgres.setSize(sizex ,sizey); 
        mfgres.setLocation(positionx, positiony);
        leftpanel.add(mfgres);
        positiony = positiony +30;
        singleres = new JLabel("-", JLabel.LEFT);
        singleres.setSize(sizex ,sizey);
        singleres.setLocation(positionx, positiony);
        leftpanel.add(singleres);
        positiony = positiony +30;
        dieshaperes = new JLabel("-", JLabel.LEFT);
        dieshaperes.setSize(sizex ,sizey);
        dieshaperes.setLocation(positionx, positiony);
        leftpanel.add(dieshaperes);
        positiony = positiony +30;
        bleedres = new JLabel("-", JLabel.LEFT);
        bleedres.setSize(sizex ,sizey);
        bleedres.setLocation(positionx, positiony);
        leftpanel.add(bleedres);

        frame.repaint();
        frame.add(leftpanel);

        // Set center panel
        centerpanel = new JPanel();
        centerpanel.setBackground(Color.GRAY);
        centerpanel.setBounds(x+navsidepanel, y+navpanel,screenwidth-2*navsidepanel, screenheight-2*navpanel-20);
        centerpanel.setLayout(null);
        frame.add(centerpanel);

        // Set subcenter panel
        subcenterpanel = new JPanel();
        subcenterpanel.setBounds(x, y,screenwidth-2*navsidepanel, screenheight-2*navpanel-20);
        subcenterpanel.setLayout(null);
        centerpanel.add(subcenterpanel);
        ImageIcon icon1 = new ImageIcon(IMAGERESOURCE+"fuji_bg_scale.png");
        img = new JLabel(icon1);
        img.setBounds(x, y,screenwidth-2*navsidepanel, screenheight-2*navpanel-15);
        subcenterpanel.add(img);
        frame.repaint();

        // Set top panel
        toppanel = new JPanel();
        toppanel.setBackground(Color.WHITE);
        toppanel.setBounds(x, y,screenwidth, navpanel);
        frame.add(toppanel);
        
        ImageIcon topspacer = new ImageIcon(IMAGERESOURCE+"spacer.png");
        img = new JLabel(topspacer);
        toppanel.add(img);
        
        ImageIcon icon2 = new ImageIcon(IMAGERESOURCE+"avans.png");
        img = new JLabel(icon2);
        toppanel.add(img);
        ImageIcon icon3 = new ImageIcon(IMAGERESOURCE+"stepandrepeat.png");
        img = new JLabel(icon3);
        toppanel.add(img);
        toppanel.revalidate();
        toppanel.repaint();
        toppanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    
    /**
    * Populate
    * Populates the combobox in the submenu 
    */
    private DefaultComboBoxModel populate(){
        // Fill the combobox dynamicly
        // Data folder
        // Read folder structure
        File file = new File(STEPDATARESOURCE);
        String[] specnumber = file.list();
        DefaultComboBoxModel dm = new DefaultComboBoxModel();
        for (int i = 1; i < specnumber.length; i++) {
            dm.addElement(new ImagesNText(new ImageIcon(STEPDATARESOURCE+"/"+specnumber[i]+"/xml/"+specnumber[i]+"_preview.png"), specnumber[i]));
        }
        return dm;
    }

}