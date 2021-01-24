package ru.rxnnct.currencyconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.rxnnct.currencyconverter.domain.ApplicationState;
import ru.rxnnct.currencyconverter.repo.ApplicationStateRepo;
import ru.rxnnct.currencyconverter.repo.ExchangeRateRepo;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class CbrXmlHandler extends BaseXmlHandler {
    private final ApplicationStateRepo applicationStateRepo;
    private final ExchangeRateRepo exchangeRateRepo;

    @Value("${currencyconverter.CbrXmlHandler.url}")
    String url;

    @Autowired
    public CbrXmlHandler (ApplicationStateRepo applicationStateRepo, ExchangeRateRepo exchangeRateRepo){
        this.applicationStateRepo = applicationStateRepo;
        this.exchangeRateRepo = exchangeRateRepo;

        List<ApplicationState> applicationStates = applicationStateRepo.findAll();
        this.lastDownloadDate = applicationStates.get(0).getLastDownloadDate();
    }

    @Override
    public void saveXmlToDatabase() throws IOException, SAXException, ParserConfigurationException {
        Document document = getXmlFromUrl(url);
        document.getDocumentElement().normalize();

        String dateFromResponse = document.getDocumentElement().getAttribute("Date");
        //todo: update dateFromResponse

//        System.out.println("Root element : " + document.getDocumentElement().getNodeName());
//        System.out.println(document.getDocumentElement().getAttribute("Date"));
        NodeList nodeList = document.getElementsByTagName("Valute");
//        System.out.println("----------------------------");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
//            System.out.println("\nCurrent Element :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
//                System.out.println("Valute ID : " + element.getAttribute("ID"));
//                System.out.println("NumCode : " + element.getElementsByTagName("NumCode").item(0).getTextContent());
//                System.out.println("CharCode : " + element.getElementsByTagName("CharCode").item(0).getTextContent());
//                System.out.println("Nominal : " + element.getElementsByTagName("Nominal").item(0).getTextContent());
//                System.out.println("Name : " + element.getElementsByTagName("Name").item(0).getTextContent());
//                System.out.println("Value : " + element.getElementsByTagName("Value").item(0).getTextContent());
            }
        }
    }

    public boolean checkDataRelevance(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        String stringDate = dateFormat.format(currentDate);
        return stringDate.equals(lastDownloadDate);
    }
}
