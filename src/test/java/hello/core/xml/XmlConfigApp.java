package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlConfigApp {

    @Test
    void xmlAppTest(){

        ApplicationContext ac = new GenericXmlApplicationContext("appConf.xml");

        MemberService bean = ac.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }

}
