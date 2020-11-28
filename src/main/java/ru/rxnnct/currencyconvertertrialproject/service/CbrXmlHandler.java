package ru.rxnnct.currencyconvertertrialproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class CbrXmlHandler extends BaseXmlHandler {
    @Value("${currencyconvertertrialproject.CbrXmlHandler.url}")
    String url;

    @Override
    public void saveXmlToDatabase() throws IOException, SAXException, ParserConfigurationException {
        Document document = getXmlFromUrl(url);

        //todo: save data
        document.getDocumentElement().normalize();
        System.out.println("Root element :" + document.getDocumentElement().getNodeName());
        System.out.println(document.getDocumentElement().getAttribute("Date"));
        NodeList nodeList = document.getElementsByTagName("Valute");
        System.out.println("----------------------------");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\nCurrent Element :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Valute ID : " + element.getAttribute("ID"));
                System.out.println("NumCode : " + element.getElementsByTagName("NumCode").item(0).getTextContent());
                System.out.println("CharCode : " + element.getElementsByTagName("CharCode").item(0).getTextContent());
                System.out.println("Nominal : " + element.getElementsByTagName("Nominal").item(0).getTextContent());
                System.out.println("Name : " + element.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Value : " + element.getElementsByTagName("Value").item(0).getTextContent());
            }
        }
    }
}
