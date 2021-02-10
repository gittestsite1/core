package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test
    @DisplayName("싱글턴 객체를 사용하는 경우")
    public void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("Spring에서 싱클턴 객체 비교")
    void springSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService service1 = ac.getBean(MemberService.class);
        MemberService service2 = ac.getBean(MemberService.class);

        assertThat(service1).isSameAs(service2);
    }
}
