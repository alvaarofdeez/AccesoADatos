package UD3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1Repaso {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String INDENT_NIVEL = " "; // INDENTACIÓN

    public static void mostrarNodo(Node nodo, int nivel, PrintStream ps) {
        if (nodo.getNodeType() == Node.TEXT_NODE) { // ESPACIOS BLANCOS
            String text = nodo.getNodeValue();
            if (text.trim().length() == 0) {
                return;
            }
        }

        for (int i = 0; i < nivel; i++) { // INDENTACIÓN
            ps.print(INDENT_NIVEL);
        }

        switch (nodo.getNodeType()) { // MOSTRARÁ INFORMACIÓN SEGÚN EL TIPO DE NODO
            case Node.DOCUMENT_NODE: // DOCUMENTO
                Document doc = (Document) nodo;
                ps.println("Documento DOM, versión: " + doc.getXmlVersion()
                        + ", codificación: " + doc.getXmlEncoding());
                // MOSTRARÁ INFORMACIÓN DEL FICHERO XML
                break;
            case Node.ELEMENT_NODE: // ELEMENTO
                ps.print("<" + nodo.getNodeName()); // ELEMENTO
                NamedNodeMap listaAtr = nodo.getAttributes(); // LISTA ATRIBUTOS
                for (int i = 0; i < listaAtr.getLength(); i++) {
                    Node atr = listaAtr.item(i);
                    ps.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
                    // MUESTRA NOMBRE DE ATRIBUTO Y VALOR
                }
                ps.println(">");
                break;
            case Node.TEXT_NODE: // TEXTO
                ps.println(nodo.getNodeName() + "[" + nodo.getNodeValue() + "]"); 
                // MUESTRA EL VALOR DEL ELEMENTO
                break;
            default: // OTRO TIPO DE NODO
                ps.println("(Nodo de tipo: " + nodo.getNodeType() + ")");
        }

        NodeList nodosHijos = nodo.getChildNodes(); // MUESTRA NODOS HIJOS
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            mostrarNodo(nodosHijos.item(i), nivel + 1, ps);
        }
    }

    public static void anadirFutbolistas(Document doc) throws TransformerException, IOException {
        doc.getDocumentElement().normalize();
        Node nodo = doc.getDocumentElement();

        int contador = 5;
        String id = String.valueOf(contador);
        for (int i = 1; i <= 5; i++) {
            Element futbolista = doc.createElement("futbolista");
            futbolista.setAttribute("id", id);

            System.out.println("Introduce el nombre del futbolista " + i + ": ");
            String nombre = br.readLine();

            System.out.println("Introduce el equipo del futbolista " + i + ": ");
            String equipo = br.readLine();

            System.out.println("Introduce los goles del futbolista " + i + ": ");
            String goles = br.readLine();

            Element nombreFutbolista = doc.createElement("nombre");
            nombreFutbolista.appendChild(doc.createTextNode(nombre));
            futbolista.appendChild(nombreFutbolista);

            Element equipoFutbolista = doc.createElement("equipo");
            equipoFutbolista.appendChild(doc.createTextNode(equipo));
            futbolista.appendChild(equipoFutbolista);

            Element golesFutbolista = doc.createElement("goles");
            golesFutbolista.appendChild(doc.createTextNode(goles));
            futbolista.appendChild(golesFutbolista);

            nodo.appendChild(futbolista);
            contador++;
            id = String.valueOf(contador);
        }

        DOMSource dom = new DOMSource(doc);
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult sr = new StreamResult(new File("futbolistas_actualizado.xml"));
        trans.transform(dom, sr);
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(new File("futbolistas.xml"));
            mostrarNodo(documento, 0, System.out);
            anadirFutbolistas(documento);
            mostrarNodo(documento, 0, System.out);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
