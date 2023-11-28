package kr.co.kjc.spring.dip.config;

import kr.co.kjc.spring.dip.discount.FixDiscountPolicy;
import kr.co.kjc.spring.dip.member.MemberService;
import kr.co.kjc.spring.dip.member.MemberServiceImpl;
import kr.co.kjc.spring.dip.member.MemoryMemberRepository;
import kr.co.kjc.spring.dip.order.OrderService;
import kr.co.kjc.spring.dip.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
