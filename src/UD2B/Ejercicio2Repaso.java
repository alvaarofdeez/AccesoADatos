package UD2B;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio2Repaso {

    public static void main(String[] args) {
        try {
            String XPath1 = "/colegio/modulos/modulo/nombre/text()";
            String XPath2 = "/colegio/modulos/modulo[ciclo = 'DAM']/nombre";
            String XPath3 = "/colegio/modulos/modulo[curso = '1']/nombre";
            String XPath4 = "/colegio/modulos/modulo[horasSemanales < '5']/nombre";
            String XPath5 = "/colegio/modulos/modulo[ciclo = 'DAM' and curso = '2']/nombre";
            String XPath6 = "/colegio/modulos/modulo[horasSemanales > 3]/horasSemanales/text()";

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document documento = db.parse(new File("asignaturas.xml"));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            NodeList nodo = (NodeList) xpath.evaluate(XPath1, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 1:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getNodeValue());
            }
            
            nodo = (NodeList) xpath.evaluate(XPath2, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 2:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getChildNodes().item(0).getNodeValue());
            }
            
            nodo = (NodeList) xpath.evaluate(XPath3, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 3:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getChildNodes().item(0).getNodeValue());
            }
            
            nodo = (NodeList) xpath.evaluate(XPath4, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 4:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getChildNodes().item(0).getNodeValue());
            }
            
            nodo = (NodeList) xpath.evaluate(XPath5, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 5:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getChildNodes().item(0).getNodeValue());
            }
            
            nodo = (NodeList) xpath.evaluate(XPath6, documento, XPathConstants.NODESET);
            System.out.println("***********************************************************");
            System.out.println("Ejercicio 6:");
            System.out.println("***********************************************************");
            for(int i = 0; i < nodo.getLength(); i++){
                System.out.println(nodo.item(i).getNodeValue());
            }
            System.out.println("***********************************************************");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
