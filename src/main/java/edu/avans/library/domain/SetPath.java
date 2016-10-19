package edu.avans.library.domain;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class SetPath {
    
    public static final String IMAGERESOURCE = "/Users/danielvanwilligenmbp/NetBeansProjects/ctp/src/main/resources/images/";
    public static final String STEPDATARESOURCE = "/Users/danielvanwilligenmbp/Documents/stepdata/";
    public static final String STEPDATAOUTPUT = "/Users/danielvanwilligenmbp/Documents/stepdataoutput/";
    
    public SetPath(){
    
    }
    
    /**
    * getImageresource
    * getImageresource sets the path to the GUI images 
    * @return 
    */
    public String getImageresource(){
        return IMAGERESOURCE;
    }

    /**
    * getStepdataresource
    * getStepdataresource sets the path to the order images  
    * @return 
    */
    public String getStepdataresource(){
        return STEPDATARESOURCE;
    }

    /**
    * getStepdataoutput
    * getStepdataoutput sets the output path of the xml  
    * @return 
    */
    public String getStepdataoutput(){
        return STEPDATAOUTPUT;
    }
}
