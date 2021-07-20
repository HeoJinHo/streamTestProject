package com.streamproject.demo.testpk;

import com.streamproject.demo.model.Apple;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;




public class Testclass
{

    public static void main(String[] args) throws Exception {
        Order order = new Order();
        Member member = new Member();
        Address address = new Address();
        address.setCity(null);
        member.setAddress(address);
        order.setMember(member);
        getCityOfMemberFromOrder(order);
    }


    /* 주문을 한 회원이 살고 있는 도시를 반환한다 */
    private static void getCityOfMemberFromOrder(Order order) throws Exception {

        String order1 = Optional.ofNullable(order)
                .map(Order::getMember)
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("Null NEP");

        System.out.println(order1);


        Optional.ofNullable(order.getMember().getAddress().getCity())
                .orElse("Null 입니다.");



//        order.getMember().getAddress().getCity();
    }


}
