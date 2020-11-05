package com.xmlparser.SAXParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.xmlparser.DemoAbstractParser;
import com.xmlparser.model.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import static com.xmlparser.util.Constants.*;

public class DemoSAXParser extends DemoAbstractParser {

    public DemoSAXParser(String filename) {
        super(filename);
    }

    @Override
    public List<Book> getAllBooks() {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(DemoSAXParser.class.getResourceAsStream(getFilename()), handler);
            return handler.getResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class SAXHandler extends DefaultHandler {

        List<Book> bookList = new ArrayList<>();
        Book book = null;
        String content = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (BOOK.equals(qName)) {
                book = new Book();
                book.setId(attributes.getValue(ID));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("book".equals(qName)) {
                bookList.add(book);
            } else if (AUTHOR.equals(qName)) {
                book.setAuthor(content);
            } else if (TITLE.equals(qName)) {
                book.setTitle(content);
            } else if (GENRE.equals(qName)) {
                book.setGenre(content);
            } else if (PRICE.equals(qName)) {
                book.setPrice(Double.parseDouble(content));
            } else if (PUBLISH_DATE.equals(qName)) {
                book.setPublishDate(LocalDate.parse(content));
            } else if (DESCRIPTON.equals(qName)) {
                book.setDescription(content);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }

        public List<Book> getResult() {
            return bookList;
        }
    }
}
