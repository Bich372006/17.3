import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XMLMerger {
    public static void mergeXMLFiles(String file1, String file2, String outputFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File f1 = new File(file1);
            File f2 = new File(file2);
            if (!f1.exists() || !f2.exists()) {
                System.out.println("Một trong hai file không tồn tại.");
                return;
            }

            Document doc1 = builder.parse(f1);
            Document doc2 = builder.parse(f2);

            Element root1 = doc1.getDocumentElement();
            NodeList nodes = doc2.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Node importedNode = doc1.importNode(node, true);
                root1.appendChild(importedNode);
            }

            XMLStorage.saveXML(doc1, outputFile);
            System.out.println("Ghép XML thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
