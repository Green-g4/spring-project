package com.green.vo;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPageDTO {
    private int reviewCnt;
    private List<ReviewVO> list;

}
