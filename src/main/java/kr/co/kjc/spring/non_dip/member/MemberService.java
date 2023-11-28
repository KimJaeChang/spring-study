package kr.co.kjc.spring.non_dip.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
