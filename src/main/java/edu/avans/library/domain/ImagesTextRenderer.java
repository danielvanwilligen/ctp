package edu.avans.library.domain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ImagesTextRenderer extends JLabel implements ListCellRenderer {

    public static final int SIXTY = 60;
    public static final int TWOHUNDRED = 200;
    /**
    * getListCellRendererComponent
    * getListCellRendererComponent sets the image icon and the text of the combobox 
    * @param val
    * @param selected
    * @param focused
    */
    @Override
    public Component getListCellRendererComponent(JList list, Object val, int index, boolean selected, boolean focused){
        
        //GET VALUES
        ImagesNText it=(ImagesNText) val;
        
        //SET VALUES
        setIcon(it.getImg());
        setText(it.getName());

        if(selected){
            setBackground(list.getSelectionBackground());
            setForeground(Color.BLUE);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        setPreferredSize(new Dimension(TWOHUNDRED,SIXTY));
        
        
        return this;
    }
}
