package edu.avans.library.domain;

import javax.swing.Icon;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ImagesNText{
    public Icon img;
    public String name;
    /**
    * ImagesNText
    * ImagesNText sets the image icon and the text of the combobox 
    * @param img
    * @param name
    */
    public ImagesNText(Icon img, String name){
        this.img = img;
        this.name = name;
    }
    /**
    * getImg
    * getImg gets the image icon
     * @return 
    */
    public Icon getImg(){
        return img;
    }
    /**
    * setImg
    * setImg sets the image icon 
     * @param img
    */
    public void setImg(Icon img){
        this.img=img;
    }
    /**
    * getName
    * getName gets name 
     * @return 
    */
    public String getName(){
        return name;
    }
    /**
    * setName
    * setName sets name 
     * @param name
    */
    public void setName(String name){
        this.name = name;
    }
}