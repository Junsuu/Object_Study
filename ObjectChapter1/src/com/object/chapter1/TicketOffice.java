package com.object.chapter1;

import java.util.ArrayList;
import java.util.List;

// TicketOffice 클래스
// 판매할 티켓, 돈이라는 정보를 가지고 있음
public class TicketOffice {
    private List<Ticket> tickets = new ArrayList<>();
    private Long amount;

    // getTicket()메소드는 사용자가 티켓 구매시 ticekts의 0번 인덱스 티켓을 제거
    private Ticket getTicket(){
        return tickets.remove(0);
    }

    //티켓 구매, 취소, 환불 등이 있을때 amount 값 증가 혹은 감소
    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }

    public void sellTicketTO(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }
}
