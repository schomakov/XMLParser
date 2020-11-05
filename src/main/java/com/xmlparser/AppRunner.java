package com.xmlparser;

import com.xmlparser.SAXParser.DemoSAXParser;
import com.xmlparser.factory.XMLFactory;
import com.xmlparser.model.Book;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AppRunner {

    public static void main(String[] args) {
       /* String xmlFilename = "/books.xml";
        Map<String, DemoXmlParser> parsers = new LinkedHashMap<>();

        parsers.put("SAXParser", new DemoSAXParser(xmlFilename));

        for (Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
            System.out.println("Parsing books.xml using " + entry.getKey() + ":");
            List<Book> result = entry.getValue().getAllBooks();
            for (Book book : result) {
                System.out.println(book);
            }*/


        XMLFactory xmlFactory = new XMLFactory();
        DemoXmlParser demoXmlParser = xmlFactory.getXmlParser("SAXParser");
        demoXmlParser.getAllBooks();
    }
}
