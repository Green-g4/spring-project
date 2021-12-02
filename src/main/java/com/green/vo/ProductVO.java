package com.green.vo;

import lombok.*;
import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {

    private int id;
    private String product_name;
    private int product_price;
    private int product_discount;
    private int product_totalprice;
    private int product_stock;
    private String product_img;
    private Date product_date;
    private String category_name;
}




