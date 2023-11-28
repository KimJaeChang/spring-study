package kr.co.kjc.spring.non_dip.order;

import kr.co.kjc.spring.non_dip.discount.DiscountPolicy;
import kr.co.kjc.spring.non_dip.discount.FixDiscountPolicy;
import kr.co.kjc.spring.non_dip.member.Member;
import kr.co.kjc.spring.non_dip.member.MemberRepository;
import kr.co.kjc.spring.non_dip.member.MemoryMemberRepository;

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
