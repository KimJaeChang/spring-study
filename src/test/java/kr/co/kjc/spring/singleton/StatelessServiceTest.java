package kr.co.kjc.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatelessServiceTest {

    @Test
    void statelessServiceSingleton() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // ThreadA : A 사용자 10000원 주문
        int userAPrice = statelessService1.order("userA", 10000);

        // ThreadB : B 사용자 20000원 주문
        int userBPrice = statelessService2.order("userB", 20000);

        // ThreadA : A 사용자 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        Assertions.assertThat(userAPrice).isNotEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }

    }

}