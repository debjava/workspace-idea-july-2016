package com.ddlab.rnd.core;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by PIKU on 8/1/2016.
 */
public class StatusHandler extends DefaultHandler {

    private Status status = new Status();
    private String parsedData = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes
            attributes) throws org.xml.sax.SAXException {
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax
            .SAXException {

        if (qName.equalsIgnoreCase("host.name")) {
            status.setHostName(parsedData);
        } else if (qName.equalsIgnoreCase("host.ip")) {
            status.setHostIp(parsedData);
        } else if (qName.equalsIgnoreCase("host.canonical.name")) {
            status.setHostCanonicalName(parsedData);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        parsedData = new String(ch, start, length);
    }

    public Status getStatus() {
        return status;
    }

}
