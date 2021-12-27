package com.green.vo;

import lombok.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {


    /* 상품 id */
    private int id;

    /* 상품 이름 */
    private String product_name;

    /* 작가 id */
    private int authorId;

    /* 작가 이름 */
    private String authorName;

    /* 카테고리 코드 */
    private String cateCode;

    /* 카테고리 이름 */
    private String cateName;

    /* 상품 가격 */
    private int product_price;

    /* 상품 재고 */
    private int product_stock;

    /* 상품 할인률(백분율) */
    private double product_discount;

    /* 상품 소개 */
    private String product_intro;

    /* 등록 날짜 */
    private Date regDate;

    /* 수정 날짜 */
    private Date updateDate;

    /* 이미지 정보 */
    private List<AttachImageVO> imageList;
}




