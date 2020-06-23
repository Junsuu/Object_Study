package com.object.chapter1;

//티켓 클래스
//티켓 클래스는 티켓의 가격정보를 인스턴스 변수로 가지고 있음.
//getFee()메소드를 통해서 가격정보를 제공한다.
public class Ticket {
    private Long fee;

    public Long getFee(){
        return fee;
    }
}
