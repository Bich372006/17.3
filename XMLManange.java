import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

    class XMLManager {
        private String filePath;

        public XMLManager(String filePath) {
            this.filePath = filePath;
        }

        public void createElement(String tagName) {
            try {
                File file = new File(filePath);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc;

                if (file.exists()) {
                    doc = builder.parse(file);
                } else {
                    doc = builder.newDocument();
                    Element root = doc.createElement("root");
                    doc.appendChild(root);
                }

                Element newElement = doc.createElement(tagName);
                String content = "";
                newElement.appendChild(doc.createTextNode(content));
                doc.getDocumentElement().appendChild(newElement);

                XMLStorage.saveXML(doc, filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void readXML() {
            try {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("File XML không tồn tại.");
                    return;
                }
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(file);
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getDocumentElement().getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(node.getNodeName() + ": " + node.getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void updateElement(String student, String nguyenVanA, String leVanC) {
        }
    }


