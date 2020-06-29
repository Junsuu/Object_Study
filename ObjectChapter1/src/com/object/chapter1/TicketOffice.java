package com.object.chapter1;

import java.util.ArrayList;
import java.util.List;

// TicketOffice 클래스
// 판매할 티켓, 돈이라는 정보를 가지고 있음
public class TicketOffice {
    private List<Ticket> tickets = new ArrayList<>();
    private Long amount;

    public TicketOffice(int total_Tickets, Long amount, Long ticket_Fee){
        this.amount = amount;
        for(int i = 0; i < total_Tickets; i++){
            Ticket ticket = new Ticket(ticket_Fee);
            tickets.add(ticket);
        }
    }

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

        //테스트용 디버그 코드
        System.out.println("=======================================");
        System.out.println("남은 티켓의 수량 : "+ tickets.size());
        System.out.println("TicketOffice의 현재 가진 금액 : " + amount);
        System.out.println("=======================================");
        System.out.println("");
    }
}
