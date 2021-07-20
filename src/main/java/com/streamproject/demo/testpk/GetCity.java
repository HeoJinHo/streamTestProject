package com.streamproject.demo.testpk;

public class GetCity
{

    /* 주문을 한 회원이 살고 있는 도시를 반환한다 */
    public String getCityOfMemberFromOrder(Order order) {
        return order.getMember().getAddress().getCity();
    }


}
