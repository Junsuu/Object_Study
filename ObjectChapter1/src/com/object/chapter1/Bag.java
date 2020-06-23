package com.object.chapter1;

//Bag 클래스
// 인스턴스 변수로 관람객이 가방에 넣어 올수 있는 소지품 amount, invitation, ticket을 가지고 있다.

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // 인스턴스 생성 시점에서의 제약을 강제하는 생성자
    // 사용자의 가방에는 (1. 초대장 + 현금) OR (2. 현금)
    public Bag(long amount){
        this(null,amount);
    }

    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    // hasInvitation()메소드
    // invitation의 널값 여부를 판단하고 리턴
    private boolean hasInvitation(){
        return invitation != null;
    }

    // hasTicket()메소드
    // ticket의 널값 여부를 판한하고 리턴
    public boolean hasTicket(){
        return ticket != null;
    }

    // minus, plus Amount()메소드
    // amount값을 매개변수로 받아서 가진 현금을 늘리거나 줄인다.
    private void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }

    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    // hasInvitation(), minusAmount(), setTicket 메소드들은 전부 객체 자체에서 처리함으로 private을 통한
    // 캡슐화
    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
