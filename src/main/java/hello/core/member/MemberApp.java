package hello.core.member;

public class MemberApp {

    // 회원가입 해보고 뽑아서 비교해보자

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.save(member);

        Member findMember = memberService.findByid(1L);

        System.out.println("member new ="+member.getName());
        System.out.println("repository new="+findMember.getName());
    }
}
