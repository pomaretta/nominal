package util;

//import es.aeat.pret.c200.mc.ModuloCalculo;
import org.w3c.dom.Document;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class CalculationIRPF {

    private XMLReader xmlReader;

    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;

    private Document document;
    private String inputData;
    private String outputData;
    private float calculation;

    public CalculationIRPF(String inputData) {
        this.inputData = inputData;
    }

    public Document processDocument(String inputData){
        Document document = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(inputData);
            document.getDocumentElement().normalize();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return document;
    }

//    public Document processAEAT(Document input){
//        Document document = null;
//        try {
//            String output = ModuloCalculo.procesarFicheroXML(input.getXmlEncoding());
//            document = processDocument(output);
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return document;
//    }

    public float getCalculation() {
        return calculation;
    }

}
