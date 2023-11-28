package kr.co.kjc.spring.dip.order;

import kr.co.kjc.spring.dip.discount.DiscountPolicy;
import kr.co.kjc.spring.dip.member.Member;
import kr.co.kjc.spring.dip.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // spring bean 생성자 주입(Dependency Injection)
    // MemoryMemberRepository 및 FixDiscountPolicy를 의존하지 않는다!
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
