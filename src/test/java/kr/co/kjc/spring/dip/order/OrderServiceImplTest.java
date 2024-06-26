package kr.co.kjc.spring.dip.order;

import kr.co.kjc.spring.dip.discount.FixDiscountPolicy;
import kr.co.kjc.spring.dip.member.Grade;
import kr.co.kjc.spring.dip.member.Member;
import kr.co.kjc.spring.dip.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


}