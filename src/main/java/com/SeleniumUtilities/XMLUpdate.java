/**
 * @(#)XMLUpdate.java
 * Copyright (c) 2022-2023
 
 * Description: To Update existing testNG xml based on the config.json details
 * author shakira 
 * @version 00:00:01
 * @see <com.SeleniumUtilities.XMLUpdate>
 * usage : <  >;
*/

package com.SeleniumUtilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUpdate {
	/**
	 * Class used for updating XML file.
	 */
	
	public void updateTestNGXMLData(String TestNGXMLDataFile, List<String> dataSet) throws IOException, XPathExpressionException, TransformerFactoryConfigurationError, TransformerException{
		/**
		 * Method used for updating TestNG xml file.
		 * @param String TestNGXMLDataFile - Full path of the testNG xml file to be update
		 * @param List<String> dataSet - This is the string data list array to update in the xml file.
		 * Order of the element is - executionSuite, executionBrowser, executionTestCase, executionTestClass
		 */
        try {
            // Get the xml document
            Document xmlDoc = getDocument(TestNGXMLDataFile);
            //String XMLDataFileNew = "./src/main/resources/TestNGXmlSingleNew.xml";
            
            //Get the suite tag and update the suite name
            Node suite = xmlDoc.getElementsByTagName("suite").item(0);
		    NamedNodeMap suiteAttr = suite.getAttributes();
		    Node suiteNodeAttr = suiteAttr.getNamedItem("name");
		    suiteNodeAttr.setTextContent(dataSet.get(0));

		    //Get the parameter tag and update the browser name
            Node parameter = xmlDoc.getElementsByTagName("parameter").item(0);
		    NamedNodeMap parameterAttr = parameter.getAttributes();
		    Node parameterNodeAttr	 = parameterAttr.getNamedItem("value");
		    parameterNodeAttr.setTextContent(dataSet.get(1));
		    
		    //Get the test case tag and update the test case name
            Node test = xmlDoc.getElementsByTagName("test").item(0);
		    NamedNodeMap testAttr = test.getAttributes();
		    Node testNodeAttr	 = testAttr.getNamedItem("name");
		    testNodeAttr.setTextContent(dataSet.get(2));
		    
		    //Get the test case tag and update the test case name
            Node testClass = xmlDoc.getElementsByTagName("class").item(0);
		    NamedNodeMap testClassAttr = testClass.getAttributes();
		    Node testClassNodeAttr	 = testClassAttr.getNamedItem("name");
		    testClassNodeAttr.setTextContent(dataSet.get(3));
		    
            // Update the xml file
            saveToXml(xmlDoc, TestNGXMLDataFile);

        } 
        catch (Exception ex) { // For simplicity Exception is used instead of handling specific one
            ex.printStackTrace();
        }
	}
        
        public void updateEnvironmentXMLData(String EnvironmentXMLDataFile, List<String> dataSet) throws IOException, XPathExpressionException, TransformerFactoryConfigurationError, TransformerException{
    		/**
    		 * Method used for updating xml file.
    		 * @param String xmlFile - Full path of the xml file to be update
    		 * @param List<String> dataSet - This is the string data list array to update in the xml file.
    		 * Order of the element is - executionSuite, executionBrowser, executionTestCase, executionTestClass
    		 */
            try {
                // Get the xml document
                Document xmlDoc = getDocument(EnvironmentXMLDataFile);  
                //Get the 
                Node parameter = xmlDoc.getElementsByTagName("test").item(0);
                
        
             
                
    		    
                
                //Get the suite tag and update the suite name
              
               
                // Update the xml file
                saveToXml(xmlDoc, EnvironmentXMLDataFile);

            } 
            catch (Exception ex) { // For simplicity Exception is used instead of handling specific one
                ex.printStackTrace();
            }
        
    }

	    /**
	     * To get DOM Document from the xml file.
	     *
	     * @param filePath
	     * @return DOM Document
	     * @throws ParserConfigurationException
	     * @throws SAXException
	     * @throws IOException
	     */
	    public static Document getDocument(String filePath) throws ParserConfigurationException, SAXException, IOException {
	    	//String filepath = "./src/main/resources/TestNGXmlSingle.xml";
		    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder;
		    docBuilder = docFactory.newDocumentBuilder();
		    Document xmlDoc = docBuilder.parse(filePath);

	        return xmlDoc;
	    }

	    /**
	     * To save the Document in xml file
	     *
	     * @param xmlDoc
	     * @param filePath
	     * @throws TransformerException
	     */
	    public static void saveToXml(Document xmlDoc, String filePath) throws TransformerException {
	        DOMSource source = new DOMSource(xmlDoc);
	        StreamResult result = new StreamResult(new File(filePath));

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();	        
	        transformer.transform(source, result);
	    }
}
