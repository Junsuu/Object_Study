package com.object.chapter1;

// Audience 클래스
// 인스턴스 변수로는 관람객이 가질수 있는 Bag
// 생성자로는 가방이라는 객체를 받아 필드에 저장하고
// getBag()을 통해서 리턴
public class Audience {
    private Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    // 캡슐화를 통해 객체를 자율적인 존재로 만든다.
    // Audience를 통해서만 Bag에 접근 가능하게 만든다.
//    public Bag getBag(){
//        return bag;
//    }

    public Long buy(Ticket ticket){
        return bag.hold(ticket);
        // 아래의 코드들의 역할을 Bag로 이동하여 Bag에게 책임을 할당하고 자율적인 객체로 형성
        // bag 내부를 알필요없이 인터페이스에만 의존하도록 수정
//        if(bag.hasInvitation()){
//            bag.setTicket(ticket);
//            return 0L;
//        }else{
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
    }
}
