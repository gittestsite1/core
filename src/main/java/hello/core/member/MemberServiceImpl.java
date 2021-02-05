package hello.core.member;

public class MemberServiceImpl implements MemberService{


//    private static MemberRepository memberRepository = new MemoryMemberRepository();

    private static MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findByid(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
