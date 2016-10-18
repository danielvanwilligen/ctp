package edu.avans.library.domain;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class SetPath {
    
    public static String imageresource;
    public static String stepdataresource;
    public static String stepdataoutput;
    
    public SetPath(){
    
    }
    
    /**
    * getImageresource
    * getImageresource sets the path to the GUI images 
    * @return 
    */
    public String getImageresource(){
        imageresource = "/Users/danielvanwilligenmbp/NetBeansProjects/ctp/src/main/resources/images/";
        return imageresource;
    }

    /**
    * getStepdataresource
    * getStepdataresource sets the path to the order images  
    * @return 
    */
    public String getStepdataresource(){
        stepdataresource = "/Users/danielvanwilligenmbp/Documents/stepdata/";
        return stepdataresource;
    }

    /**
    * getStepdataoutput
    * getStepdataoutput sets the output path of the xml  
    * @return 
    */
    public String getStepdataoutput(){
        stepdataoutput = "/Users/danielvanwilligenmbp/Documents/stepdataoutput/";
        return stepdataoutput;
    }
    
    public void setImageresource(String setImageresource) {
        imageresource = setImageresource;
    }
    
    public void setStepdataresource(String setStepdataresource) {
        stepdataresource = setStepdataresource;
    }
    
    public void setStepdataoutput(String setStepdataoutput) {
        stepdataoutput = setStepdataoutput;
    } 
}
