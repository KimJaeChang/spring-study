package kr.co.kjc.spring.dip.discount;

import kr.co.kjc.spring.dip.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
