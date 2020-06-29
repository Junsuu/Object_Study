package com.object.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // setting[0] -> 청중의 수
        // setting[1]  -> 청중의 가방에 넣을 현금의량
        // setting[2]  -> 초대장의 갯수
        // setting[3]  -> ticketoffice total amount
        // setting[4]  -> ticket 가격
        // setting[5]  -> ticket 총수량
        int audience_set[] = {100,3000,10};
        int theater_set[] = {100000,1000,300};

        Map<Integer,Audience> audienceMap = new HashMap<>();
        audienceMap = Initialize_Audience(audience_set);
        Theater theater = Initialize_Theater(theater_set);

        for(int i = 1; i <= audienceMap.size(); i++){
            System.out.println("청중 " + i + " 번째 입장");
            theater.enter(audienceMap.get(i));
        }



    }


    // audience_set[0] -> 청중의 수
    // audience_set[1] -> 청중의 가방에 넣을 현금의량
    // audience_set[2] -> 초대장의 갯수
    public static Map<Integer,Audience> Initialize_Audience(int[] audience_set){
        int numberOfPeople = audience_set[0];
        int bagAmount = audience_set[1];
        int numberOfInvitation = audience_set[2];

        System.out.println("셋팅한 청중의 수 : " + numberOfPeople);
        System.out.println("청중의 가방에 넣을 현금량 : " + bagAmount);
        System.out.println("초대장의 수량 : " + numberOfInvitation);

        //청중을 생성하고 담을 Hashmap
        Map<Integer,Audience> audienceMap = new HashMap<>();

        // 초대장은 생성 시작부터 지급하며 초대장의 개수가 다 소진되면 초대장을 분배하지않는다.
        for(int i = 1; i <= numberOfInvitation; i++){
            Invitation invitation = new Invitation();
            Bag bag = new Bag(invitation, bagAmount);
            Audience audience = new Audience(bag);
            audienceMap.put((Integer)i, audience);
        }
        // 초대장이 없는 청중 생성
        for(int i = numberOfInvitation + 1; i <= numberOfPeople; i++){
            Bag bag = new Bag(bagAmount);
            Audience audience = new Audience(bag);
            audienceMap.put((Integer)i, audience);
        }

        // 디버그용 이터레이터
//        Set<Map.Entry<Integer,Audience>> entries = audienceMap.entrySet();
//        for(Map.Entry<Integer,Audience> entry : entries){
//            System.out.println("청중 고유번호 : " + entry.getKey());
//            System.out.println("청중 오브젝트 : " + entry.getValue());
//        }
        System.out.println("청중 셋팅 완료");
        System.out.println("");
        return audienceMap;
    }


    // theater_set[0] -> ticketoffice total amount
    // theater_set[1] -> ticket 가격
    // theater_set[2] -> ticket 총수량
    public static Theater Initialize_Theater(int[] theater_set){
        int ticketOffice_Amount = theater_set[0];
        int ticket_Fee = theater_set[1];
        int total_Tickets = theater_set[2];

        TicketOffice ticketOffice = new TicketOffice(total_Tickets, (long) ticketOffice_Amount, (long) ticket_Fee);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        System.out.println("영화관이 가진 총 amount : " + ticketOffice_Amount);
        System.out.println("티켓 가격 : " + ticket_Fee);
        System.out.println("총 티켓 수량 : " + total_Tickets);
        System.out.println("영화관 셋팅 완료");
        System.out.println("");
        return theater;
    }
}