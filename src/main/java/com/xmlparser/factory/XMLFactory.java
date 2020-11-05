package com.xmlparser.factory;

import com.xmlparser.DOMParser.DOMParser;
import com.xmlparser.SAXParser.DemoSAXParser;
import com.xmlparser.DemoXmlParser;

import static com.xmlparser.util.Constants.XML_FILE;

public class XMLFactory {

    public DemoXmlParser getXmlParser(String xmlParser) {
        if (xmlParser == null || xmlParser.isEmpty()) {
            return null;
        }

        if (("DOMParser".equals(xmlParser))) {
            return new DOMParser(XML_FILE);
        } else if (("SAXParser".equals(xmlParser))) {
            return new DemoSAXParser(XML_FILE);
        }
        return null;
    }
}
