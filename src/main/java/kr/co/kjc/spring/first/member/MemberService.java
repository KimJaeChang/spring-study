package kr.co.kjc.spring.first.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
