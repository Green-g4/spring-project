package com.green.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVo {
    private String notice_id;
    private String notice_title;
    private String notice_coments;
    private String use_yn;
    private String mod_date;
    private int startIndex;
    private int cntPerPage;
}
