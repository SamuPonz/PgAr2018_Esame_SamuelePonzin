package program;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * 
 * Classe che si occupa della lettura di files in formato XML, in particolare
 * dell'archiviazione dei dati.
 * 
 * @author Samuele Ponzin
 *
 */
public class Utility {
	
    /**
     * Metodo che legge i file in formato xml
  
     */
	
	public Utility() {}
	
    public static Library read(String[] files) {
        
    	Library library = new Library();
    	int countFiles = 0;
    	
//    	System.out.println("START READING");
    	
    	for(String fileName : files) {
    		
    		Story story = null;
    		String title = null;
    		int numberOfChapters = 0;
    		
	    	Paragraph paragraph = null;
	    	int id = 0;
	    	String type = null;
	    	String description = null;
	    	String message = null;
	    	int linkTo = 0;
	    	int cont = 0;
	  
			try {		
				XMLInputFactory xmlif = XMLInputFactory.newInstance();
				XMLStreamReader xmlr = xmlif.createXMLStreamReader(fileName, new FileInputStream(fileName));
				
				while(xmlr.hasNext()) {
					switch(xmlr.getEventType()) {
					case XMLStreamConstants.START_DOCUMENT:
//						System.out.println("I'm reading a file...");
						break;
					case XMLStreamConstants.START_ELEMENT:
						if(xmlr.getLocalName().equals("story")) {
							title = xmlr.getAttributeValue(0);
							numberOfChapters = Integer.parseInt(xmlr.getAttributeValue(1));
							story = new Story(title, numberOfChapters);
						}
						if(xmlr.getLocalName().equals("paragraph")) {
							id = Integer.parseInt(xmlr.getAttributeValue(0));
							type = xmlr.getAttributeValue(1);
							paragraph = new Paragraph(id, type);
						}
						if(xmlr.getLocalName().equals("description")) {
							cont = 1;
						}
						if(xmlr.getLocalName().equals("option")) {
							linkTo = Integer.parseInt(xmlr.getAttributeValue(0));
							paragraph.addPossibleChapter(linkTo);
							
							cont = 2;
						}
						break;
					case XMLStreamConstants.CHARACTERS:
						String character = xmlr.getText();
		            	if(character.trim().length()>0) {
		            		switch(cont) {
		            		case 1:
		            			paragraph.setDescription(character.trim());
		            			break;
		            		case 2:
		            			paragraph.addOption(new Option(id, linkTo, character.trim()));
		            			break;
		            		default: 
		            			break;
		            		}
		            	}
		            	break;
					case XMLStreamConstants.END_ELEMENT:
						if(xmlr.getLocalName().equals("paragraph")) {
							story.addChapter(paragraph);
						}
						if(xmlr.getLocalName().equals("storygame")) {
							library.addStory(story);
							countFiles++;
//							System.out.println("I've finished reading this file, so far i've read " + countFiles + " files.");
						}
						break;
					default: 
						break;
					}
					xmlr.next();
				}
			}
			
			catch(Exception e) {
		    	System.err.println("Error detected");
		    	System.err.println(e.getMessage());
		    }
    	}
    	
//    	System.out.println("END");
    	return library;
	}
}