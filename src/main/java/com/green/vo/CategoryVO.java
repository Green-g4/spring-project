package com.green.vo;

import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CategoryVO {
    /* 카테고리 등급 */
    private int tier;

    /* 카테고리 이름 */
    private String cateName;

    /* 카테고리 넘버 */
    private String cateCode;

    /* 상위 카테고리 */
    private String cateParent;
}


