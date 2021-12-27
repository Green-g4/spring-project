package com.green.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
public class Criteria {
    private int pageNum; //현재 페이지 번호
    private int amount; //1페이지장 몇개를 표시할지
    private int skip; // 페이지 스킵
    private String type;// 추가 검색을 위한 , 타입은  title(T), content(C),writer(W), WC
    private String keyword;//검색어 추가
    private String[] authorArr; // 상품 리스트
    private String cateCode;

    public Criteria() {
        this(1,16);
    }// 1페이지 ,페이지당 10개씩 기본 설정 크리테리아 기본 생성자
    public Criteria(int pageNum, int amount) { //크리테리아 생성자
        this.pageNum=pageNum;
        this.amount=amount;
        this.skip=(pageNum - 1) * amount;
    }
    public void setPageNum(int pageNum){
        this.pageNum = pageNum;
        this.skip = (pageNum - 1) * this.amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
        this.skip = (this.pageNum - 1) * amount;
    }

    //검색 타입 데이터 배열 변환
    public String[] getTypeArr() { //mybatis에서  typeArr을 사용
        return type==null? new String[] {} : type.split("");
    } //문자열을 공백으로 분리 ex)"WC" => ["W","C"] ,"TWC" => ["T","W","C"]

    public String getListLink() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type",this.getType())
                .queryParam("keyword", this.getKeyword());
        String result = builder.toUriString();
        System.out.println("UriComponentBuilder : " +result);
        return result;
    }
}
