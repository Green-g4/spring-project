package com.green.vo;

import lombok.*;
import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private int review_num;
    private int product_id;
    private String member_id;
    private String review_content;
    private Date review_date;

}



