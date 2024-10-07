package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import entities.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
    public static List<Product> setProduct() {

        File file = new File("D:\\диск\\СИТаирис\\lab 6\\lab6\\src\\main\\resources\\products.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            List<Product> productList = getProductsData(document);
            return productList;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static List<Product> getProductsData(Document document) {

        NodeList list = document.getElementsByTagName("Product");
        int length = list.getLength();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Product emp = getProduct(element);
                productList.add(emp);
            }
        }

        return productList;
    }

    private static Product getProduct(Element element) {


        String name = getProductDetails(element, "name");
        String type = getProductDetails(element, "type");
        int count = Integer.parseInt(getProductDetails(element, "count"));
        int price = Integer.parseInt(getProductDetails(element, "price"));
        Product product = new Product();
        product.setName(name);
        product.setType(type);
        product.setCount(count);
        product.setPrice(price);
        return product;
    }

    private static String getProductDetails(Element element, String property) {
        String value = element.getElementsByTagName(property).item(0).getTextContent();
        return value;
    }

}
