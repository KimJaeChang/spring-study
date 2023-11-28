package kr.co.kjc.spring.dip.config;

import kr.co.kjc.spring.dip.discount.DiscountPolicy;
import kr.co.kjc.spring.dip.discount.FixDiscountPolicy;
import kr.co.kjc.spring.dip.discount.RateDiscountPolicy;
import kr.co.kjc.spring.dip.member.MemberService;
import kr.co.kjc.spring.dip.member.MemberServiceImpl;
import kr.co.kjc.spring.dip.member.MemoryMemberRepository;
import kr.co.kjc.spring.dip.order.OrderService;
import kr.co.kjc.spring.dip.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
