package org.hakanmetin._02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    public static void main(String[] args) {

        List<Product> productsList1 = new ArrayList<>();

        Product product1 = new Product(); //Normal Object

        //teker teker nesne olusturmak yerine böyle de yapabiliriz.
        productsList1.add(new Product(1,"Ekmek", "Beyaz" , 5.6f)); //Anonym Object
        productsList1.add(new Product(2,"Süt", "Yagli" , 4.5f));
        productsList1.add(new Product(3,"Su", "Mineralli" , 6f));
        productsList1.add(new Product(4,"Elma", "Yesil" , 2.1f));
        productsList1.add(new Product(5,"Cikolata", "Sütlü" , 3f));


        
        double d = productsList1.stream()
                .filter(product -> product.getPrice() > 2 && product.getPrice() < 5)
                .limit(3)
                .mapToDouble(Product::getPrice)
                .sum();
               // .toList(); //bununla da listeye cevirebiliyoruz.

        System.out.println(d);






    }
}
