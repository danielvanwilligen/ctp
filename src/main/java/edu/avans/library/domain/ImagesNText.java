package edu.avans.library.domain;

import javax.swing.Icon;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ImagesNText
{
    public Icon img;
    public String name;
    
    public ImagesNText(Icon img, String name)
    {
        this.img = img;
        this.name = name;
    }
    
    public Icon getImg() {
        return img;
    }
    
    public void setImg(Icon img)
    {
        this.img=img;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}