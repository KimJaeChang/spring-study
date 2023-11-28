package kr.co.kjc.spring.dip.config;

import kr.co.kjc.spring.dip.discount.DiscountPolicy;
import kr.co.kjc.spring.dip.discount.FixDiscountPolicy;
import kr.co.kjc.spring.dip.member.MemberService;
import kr.co.kjc.spring.dip.member.MemberServiceImpl;
import kr.co.kjc.spring.dip.member.MemoryMemberRepository;
import kr.co.kjc.spring.dip.order.OrderService;
import kr.co.kjc.spring.dip.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
