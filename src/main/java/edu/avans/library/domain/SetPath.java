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
    
    public String getImageresource(){
    imageresource = "/Users/danielvanwilligenmbp/NetBeansProjects/ctp/src/main/resources/images/";
    return imageresource;
    }
    
    public String getStepdataresource(){
    stepdataresource = "/Users/danielvanwilligenmbp/Documents/stepdata/";
    return stepdataresource;
    }
    
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
