package kr.co.kjc.spring.first.discount;

import kr.co.kjc.spring.first.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
