package UD2B;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjercicioRepaso1 {

    public static void main(String[] args) {
        try {
            File archivo = new File("futbolistas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();

            System.out.println("****************************");
            System.out.println("Elemento Raíz: " + documento.getDocumentElement().getNodeName());
            NodeList lista = documento.getElementsByTagName("futbolista");
            System.out.println("****************************");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("ID Futbolista: " + element.getAttribute("id"));
                    System.out.println("Nombre del Futbolista: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Equipo del Futbolista: " + element.getElementsByTagName("equipo").item(0).getTextContent());
                    System.out.println("Goles del Futbolista: " + element.getElementsByTagName("goles").item(0).getTextContent());
                    System.out.println("****************************");
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
