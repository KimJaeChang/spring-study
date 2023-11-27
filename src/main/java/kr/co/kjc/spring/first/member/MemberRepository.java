package kr.co.kjc.spring.first.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
