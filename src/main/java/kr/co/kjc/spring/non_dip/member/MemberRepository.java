package kr.co.kjc.spring.non_dip.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
