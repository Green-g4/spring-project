package com.green.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorVO {
    /* 작가 아이디 */
    private int authorId;

    /* 작가 이름 */
    private String authorName;

}
