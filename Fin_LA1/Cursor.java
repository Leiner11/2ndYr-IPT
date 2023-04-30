package fin_LA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class Cursor {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        File file = new File("testsubject.xml");

        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        // All read subjects objects will be added to this list
        List<XMLClass> subjectList = new ArrayList<>();

        // Create subject object. It will get all the data using setter methods.
        // And at last, it will be stored in above 'subjectList'
        XMLClass Subject_Info = null;

        // Checking the availability of the next tag
        while (eventReader.hasNext()) {
            XMLEvent xmlEvent = eventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();

                // As soon as subject tag is opened, create new Subject object
                if ("Subcode".equalsIgnoreCase(startElement.getName().getLocalPart())) {
                	Subject_Info = new XMLClass(null, null, null, null, null);
                }

                // Read all attributes when start tag is being read
                @SuppressWarnings("unchecked")
                Iterator<Attribute> iterator = startElement.getAttributes();

                while (iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    if ("Number".equalsIgnoreCase(name.getLocalPart())) {             
                    	Subject_Info.setNumber(Integer.valueOf(attribute.getValue()));
                    }
                }

                // Now every time content tags are found;
                // Move the iterator and read data
                switch (startElement.getName().getLocalPart()) {
                case "Subcode":
                    Characters subcodeDataEvent = (Characters) eventReader.nextEvent();
                    Subject_Info.setSubcode(subcodeDataEvent.getData().toString());
                    break;

                case "Description":
                    Characters descriptionDataEvent = (Characters) eventReader.nextEvent();
                    Subject_Info.setDescription(descriptionDataEvent.getData().toString());
                    break;

                case "Category":
                    Characters categoryDataEvent = (Characters) eventReader.nextEvent();
                    Subject_Info.setCategory(categoryDataEvent.getData().toString());
                    break;
                    
                case "Units":
                    Characters unitsDataEvent = (Characters) eventReader.nextEvent();
                    Subject_Info.setUnits(unitsDataEvent.getData().toString());
                    break;
                }
            }

            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();

                // If subject tag is closed then add the subject object to list;
                // and be ready to read next subject data
                if ("Subject_Info".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    subjectList.add(Subject_Info);
                }
            }
        }

        System.out.println(subjectList); // Verify read data

    }
}
