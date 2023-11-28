package kr.co.kjc.spring.dip.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
