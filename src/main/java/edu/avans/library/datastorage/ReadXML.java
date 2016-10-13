package edu.avans.library.datastorage;
import static edu.avans.library.presentation.JavaGUI.bleedres;
import static edu.avans.library.presentation.JavaGUI.customerres;
import static edu.avans.library.presentation.JavaGUI.dieshaperes;
import static edu.avans.library.presentation.JavaGUI.heightres;
import static edu.avans.library.presentation.JavaGUI.itemsxres;
import static edu.avans.library.presentation.JavaGUI.itemsxresvalue;
import static edu.avans.library.presentation.JavaGUI.itemsyres;
import static edu.avans.library.presentation.JavaGUI.itemsyresvalue;
import static edu.avans.library.presentation.JavaGUI.mfgres;
import static edu.avans.library.presentation.JavaGUI.name;
import static edu.avans.library.presentation.JavaGUI.ordernrres;
import static edu.avans.library.presentation.JavaGUI.singleres;
import static edu.avans.library.presentation.JavaGUI.specnrres;
import static edu.avans.library.presentation.JavaGUI.widthres;
import edu.avans.library.domain.SetPath;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Avans Java Proftaak
 * @author Daniel van Willigen
 * @version 1.0
 */

public class ReadXML {
    public void getXMLData() throws ParserConfigurationException, SAXException {
	// read xml
	try {
	    File fXmlFile = new File(SetPath.stepdataresource+name+"/xml/"+name+".xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName("xml");

	    for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		    Element eElement = (Element) nNode;
		    specnrres.setText(eElement.getElementsByTagName("spec").item(0).getTextContent());
		    ordernrres.setText(eElement.getElementsByTagName("ordernumber").item(0).getTextContent());
		    customerres.setText(eElement.getElementsByTagName("customer").item(0).getTextContent());
		    widthres.setText(eElement.getElementsByTagName("cylinderwidth").item(0).getTextContent());
		    heightres.setText(eElement.getElementsByTagName("cylinderheight").item(0).getTextContent());
		    itemsxres.setText(eElement.getElementsByTagName("items_on_cylinder_x").item(0).getTextContent());
		    itemsyres.setText(eElement.getElementsByTagName("items_on_cylinder_y").item(0).getTextContent());
		    mfgres.setText(eElement.getElementsByTagName("mfg").item(0).getTextContent());
		    singleres.setText(eElement.getElementsByTagName("single").item(0).getTextContent());
		    dieshaperes.setText(eElement.getElementsByTagName("bleed").item(0).getTextContent());
		    bleedres.setText(eElement.getElementsByTagName("dieshape").item(0).getTextContent());
		    itemsxresvalue = eElement.getElementsByTagName("items_on_cylinder_x").item(0).getTextContent();
		    itemsyresvalue = eElement.getElementsByTagName("items_on_cylinder_y").item(0).getTextContent();
		}
	    }
	} catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
	    System.err.println("Caught IOException: " + e.getMessage());
	}
    }
}