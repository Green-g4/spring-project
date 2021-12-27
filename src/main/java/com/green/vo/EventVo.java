package com.green.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EventVo {
    private String event_id;
    private String event_title;
    private String event_coments;
    private String use_yn;
    private String mod_date;
    private int startIndex;
    private int cntPerPage;
}

