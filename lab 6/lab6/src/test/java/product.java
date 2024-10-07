import static org.junit.Assert.*;

import entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

//mvn test -Dtest=product
public class product
{
    @Test
    public void testCounter() {
        // Тестируемый класс
        String name1 = "test1";
        String type1 ="test1";
        int count1=2;
        int price1 =3;
        String name2 = "test2";
        String type2 ="test2";
        int count2=4;
        int price2 =6;

        Product tester1 = new Product(name1,type1,count1,price1);
        Product tester2 = new Product(name2,type2,count2,price2);
        List<Product> productListTest= new ArrayList<>();
        productListTest.add(tester1);
        productListTest.add(tester2);

        // Проверяемый метод
        assertEquals(6, Product.totalCount(productListTest));
    }
}
