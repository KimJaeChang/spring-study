package kr.co.kjc.spring.dip.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
