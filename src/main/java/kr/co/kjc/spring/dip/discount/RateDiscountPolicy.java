package kr.co.kjc.spring.dip.discount;

import kr.co.kjc.spring.dip.member.Grade;
import kr.co.kjc.spring.dip.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountFixAMount = 1000; // 1000원 할이

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAMount;
        } else {
            return 0;
        }
    }
}
