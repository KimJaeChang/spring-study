package kr.co.kjc.spring.non_dip.discount;

import kr.co.kjc.spring.non_dip.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
