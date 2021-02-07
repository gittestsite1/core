package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP할인율이 적용되어야 함")
    void vip_0(){

        Long memberId = 1L;
        Member member = new Member(memberId, "VIP-Name", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP할인이 적용되면 안됩니다.")
    void vip_x(){
        Long memberId = 2L;
        Member member = new Member(memberId, "BASIC-Name", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }
}