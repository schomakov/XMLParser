package com.xmlparser;

public abstract class DemoAbstractParser implements DemoXmlParser {

    protected String filename;

    public DemoAbstractParser(String filename) {
        this.filename = filename;
    }

    public String getFilename(){
        return filename;
    }
}
