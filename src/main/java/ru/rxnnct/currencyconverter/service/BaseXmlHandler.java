package ru.rxnnct.currencyconverter.service;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public abstract class BaseXmlHandler {
    protected String lastDownloadDate;

    public abstract void saveXmlToDatabase() throws IOException, SAXException, ParserConfigurationException;

    public Document getXmlFromUrl(String url) throws ParserConfigurationException, IOException, SAXException {
        //todo: the same for a controller
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new URL(url).openStream());
        return document;
    }
}
