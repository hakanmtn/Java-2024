package org.hakanmetin._02;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Product {
//Lombok da bu siralama önemli ---
// Lombok kullaniyorsak, degiskenlerin yerini oynatmamaliyiz.

    private int id;
    private String productName;
    private String productDescription;
    private float price;


}
