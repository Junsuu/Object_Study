package com.object.chapter1;
// Theater 클래스
// 극장은 티켓판매원의 정보를 가지고 있다
// 인스턴스 생성 시점에 티켓판매원의 정보를 받아 필드에 저장
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    // enter()메소드는 청중을 매개변수로 받아 청중 가방을 뒤져서
    // 초대장이 있으면 TicketOffice에서 가지고 있는 티켓을 없애고
    // 가방에 티켓을 넣어준다.
    public void enter(Audience audience){

        // Theater가 의존하는 객체가 너무 많아 변경의 용이성이 떨어진다.
        // 해결법 : 커플링을 낮추기 위해서 theater에서 직접 ticketSeller의 매표소, Audience의 가방에 접근 허용을 금지하고
        //        각 객체가 직접 자율성을 가지고 처리하도록 만든다.

//        if(audience.getBag().hasInvitation()){
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().setTicket(ticket);
//
//            //초대장이 없을 경우 TicketOffice에서 가지고 있는 티켓을 없애고
//            //청중 가방에서 돈을 빼고 TicketOffice에서 돈을 추가하고 티켓을 청중 가방에 넣어준다.
//        }else{
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }
        ticketSeller.sellTo(audience);
    }
}
