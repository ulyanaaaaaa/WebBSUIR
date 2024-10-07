package JDBC;

import JDBC.*;
import entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static JDBC.JDBC.connection;

public class DataFromBd
{
    public static void main(String[] args)
    {
        List<Product> productList= setProductFromBd();
    }
    public static List<Product> setProductFromBd() {
        try {
            JDBC.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList= new ArrayList<Product>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int count = resultSet.getInt("count");
                int price = resultSet.getInt("price");

                Product product = new Product();
                product.setName(name);
                product.setType(type);
                product.setCount(count);
                product.setPrice(price);
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }
}
