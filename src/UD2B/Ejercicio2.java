package UD2B;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            File archivo = new File("clientes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList nodo = documento.getElementsByTagName("cliente");
            
            if (nodo.getLength() != 1){
                
            }
            Node cliente = (Node) nodo.item(0);
            
            NamedNodeMap listaAtr = cliente.getAttributes();
            System.out.println("UD3.Ejercicio2.main()");
            for (int i = 0; i < listaAtr.getLength(); i++) {
                Node atr = listaAtr.item(i);
                System.out.println("UD3.Ejercicio2.main()");
                if (atr.getNodeName().equals("DNI")) {
                    System.out.println("Introduce un DNI: ");
                    String dni = br.readLine();
                    System.out.println("-----------------------------------------");
                    if (atr.getNodeValue().equalsIgnoreCase(dni)) {
                        NodeList lista = documento.getElementsByTagName("apellidos");
                        Node node = lista.item(i);
                        System.out.println("UD3.Ejercicio2.main()");
                        if (node.getNodeType() == Node.ELEMENT_NODE){
                            System.out.println("UD3.Ejercicio2.main()");
                            if (node.getNodeName().equalsIgnoreCase("apellidos")){
                                System.out.println("Introduce los apellidos: ");
                                String apellidos = br.readLine();
                                node.setNodeValue(apellidos);
                            }
                        }
                    } else {
                        System.out.println("El DNI introducido no existe en el documento.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
