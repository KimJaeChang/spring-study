package kr.co.kjc.spring.scope;

import ch.qos.logback.core.net.server.Client;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import kr.co.kjc.spring.scope.PrototypeBeanTest.PrototypeBean;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeBean1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean PrototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean1.addCount();
        assertThat(PrototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean PrototypeBean2 = ac.getBean(PrototypeBean.class);
        PrototypeBean1.addCount();
        assertThat(PrototypeBean1.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototypeBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }

    // 싱글톤과 프로토 타입 빈을 같이 쓰면 문제 발생
//    @Scope("singleton")
//    @RequiredArgsConstructor
//    static class ClientBean {
//        private final PrototypeBean prototypeBean;
//
//        public int logic() {
//
//            prototypeBean.addCount();
//            return prototypeBean.getCount();
//        }
//
//    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientBean {

//        private final ObjectProvider<PrototypeBean> prototypeBeanProvider;  // 1안
        private final Provider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();  // 1안
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public int addCount() {
            return count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init = " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }

}
