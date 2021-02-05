package hello.core.member;

public interface MemberService {

    // 회원가입
    void save(Member member);

    // 조회
    Member findByid (Long memberId);
}
