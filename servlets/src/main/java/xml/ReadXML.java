package xml;


import entities.Book;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
    public static List<Book> setBook() {

        File file = new File("books.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            List<Book> bookList = getBookData(document);
            return bookList;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static List<Book> getBookData(Document document) {

        NodeList list = document.getElementsByTagName("book");
        int length = list.getLength();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Book emp = getBook(element);
                bookList.add(emp);
            }
        }

        return bookList;
    }

    public static Book getBook(Element element) {


        String title = getProductDetails(element, "title");
        String author = getProductDetails(element, "author");
        int date = Integer.parseInt(getProductDetails(element, "date"));
        String publisher = getProductDetails(element, "publisher");
        int cost = Integer.parseInt(getProductDetails(element, "cost"));
        int count = Integer.parseInt(getProductDetails(element, "count"));
        Book book = new Book(title, author, date, publisher, cost, count);
        return book;
    }

    private static String getProductDetails(Element element, String property) {
        String value = element.getElementsByTagName(property).item(0).getTextContent();
        return value;
    }

}
