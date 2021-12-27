package com.green.vo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CateFilterDTO {
    /* 카테고리 이름 */
    private String cateName;

    /* 카테고리 넘버 */
    private String cateCode;;

    /* 카테고리 상품 수 */
    private int cateCount;

    /* 카테 분류 */
    private String cateGroup;
}
