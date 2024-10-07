package entities;

import java.util.List;

public class Product
{
    private String name;
    private String type;
    private int count;
    private int price;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product()
    {

    }

    public Product(String name, String type, int count, int price)
    {
        this.name=name;
        this.type=type;
        this.count=count;
        this.price=price;
    }

    public static int totalPrice(List<Product> productList)
    {
        int sum=0;
        for (Product l: productList )
        {
            sum+=l.price;
        }
        return sum;
    }
    public static int totalCount(List<Product> productList)
    {
        int count=0;
        for (Product l: productList )
        {
            count+=l.count;
        }
        return count;
    }

}
