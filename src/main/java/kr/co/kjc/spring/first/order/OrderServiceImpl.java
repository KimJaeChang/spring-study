package kr.co.kjc.spring.first.order;

import kr.co.kjc.spring.first.discount.DiscountPolicy;
import kr.co.kjc.spring.first.discount.FixDiscountPolicy;
import kr.co.kjc.spring.first.member.Member;
import kr.co.kjc.spring.first.member.MemberRepository;
import kr.co.kjc.spring.first.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
