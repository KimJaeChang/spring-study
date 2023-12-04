package kr.co.kjc.spring.dip.discount;

import kr.co.kjc.spring.dip.annotation.MainDiscountPolicy;
import kr.co.kjc.spring.dip.member.Grade;
import kr.co.kjc.spring.dip.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy // @Qualifier 대신 보기좋게 사용
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
