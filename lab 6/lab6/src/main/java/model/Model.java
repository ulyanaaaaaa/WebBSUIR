package model;

import JDBC.DataFromBd;
import entities.Product;
import xml.ReadXML;
import xml.ReadXML.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model
{
    private static Model instance = new Model();

    private List<Product> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
        // model = ReadXML.setProduct();
        model = DataFromBd.setProductFromBd();
    }

    public List<Product> getModel() {
        return model;
    }
}
