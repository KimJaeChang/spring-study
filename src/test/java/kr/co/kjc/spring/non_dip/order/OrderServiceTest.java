package kr.co.kjc.spring.non_dip.order;

import kr.co.kjc.spring.non_dip.member.Grade;
import kr.co.kjc.spring.non_dip.member.Member;
import kr.co.kjc.spring.non_dip.member.MemberService;
import kr.co.kjc.spring.non_dip.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}