package com.object.chapter1;

// TickectSeller 클래스
// 티켓 판매원은 자신이 일하는 매표소를 알아야하기 때문에 티켓 오피스에 대한 정보를 포함하고 있다.
public class TicketSeller {
    //getTicketOffice 메소드를 제거함으로서 외부에서 ticketOffice에 접근하는 것을 막는다.
    // 따라서 접근은 오직 TicketSeller 내부에서 이루어 진다.
    // 캡슐화
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    //리펙토링 1. enter()클래스에서 TicektSeller에서 TicketOffice에 접근하는 것을 막는다.
//    public TicketOffice getTicketOffice(){
//        return ticketOffice;
//    }

    public void sellTo(Audience audience){
        // Audience 캡슐화를 통해서 Audience가 Bag객체를 자체적으로 관리
//        if(audience.getBag().hasInvitation()){
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        }else{
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }

        //ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        ticketOffice.sellTicketTO(audience);
    }
}
