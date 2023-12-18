package model;

import entities.Book;
import xml.ReadXML;
import xml.ReadXML.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model
{
    private static Model instance = new Model();

    private List<Book> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
        model = ReadXML.setBook();
    }

    public List<Book> getModel() {
        return model;
    }
}
