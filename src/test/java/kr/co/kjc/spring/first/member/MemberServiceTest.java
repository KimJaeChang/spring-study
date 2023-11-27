package kr.co.kjc.spring.first.member;

import kr.co.kjc.spring.first.member.Grade;
import kr.co.kjc.spring.first.member.Member;
import kr.co.kjc.spring.first.member.MemberService;
import kr.co.kjc.spring.first.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}