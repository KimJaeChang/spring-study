package kr.co.kjc.spring.dip.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dip_memberService")
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // spring bean 생성자 주입(Dependency Injection)
    // 설계 변경으로 MemoryMemberRepository를 의존하지 않는다.
    // 단지 MemberREpository 인터페이스만 의존한다.
    @Autowired // ==  ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
