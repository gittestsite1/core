package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글턴 변수 함께 사용되는 문제")
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        service1.order("족발1", 10000);
        service2.order("피자2", 20000);

        int service1Price = service1.getPrice();
        System.out.println("service1Price = " + service1Price);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}