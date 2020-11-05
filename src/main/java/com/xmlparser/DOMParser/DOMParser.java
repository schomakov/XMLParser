package com.xmlparser.DOMParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.xmlparser.DemoAbstractParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.xmlparser.model.Book;

import static com.xmlparser.util.Constants.*;

public class DOMParser extends DemoAbstractParser {

    public DOMParser(String filename) {
        super(filename);
    }

    public List<Book> getAllBooks() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(DOMParser.class.getResourceAsStream(XML_FILE));

            List<Book> booksList = new ArrayList<>();

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Book book = new Book();
                    book.setId(node.getAttributes().getNamedItem(ID).getNodeValue());

                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode instanceof Element) {
                            String content = childNode.getLastChild().getTextContent().trim();
                            String nodeName = childNode.getNodeName();

                            if (AUTHOR.equals(nodeName)) {
                                book.setAuthor(content);
                            } else if (TITLE.equals(nodeName)) {
                                book.setTitle(content);
                            } else if (GENRE.equals(nodeName)) {
                                book.setGenre(content);
                            } else if (PRICE.equals(nodeName)) {
                                book.setPrice(Double.parseDouble(content));
                            } else if (PUBLISH_DATE.equals(nodeName)) {
                                book.setPublishDate(LocalDate.parse(content));
                            } else if (DESCRIPTON.equals(nodeName)) {
                                book.setDescription(content);
                            }
                        }
                    }
                    booksList.add(book);
                }
            }
            return booksList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
