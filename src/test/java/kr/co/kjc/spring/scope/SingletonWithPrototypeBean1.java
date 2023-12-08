package kr.co.kjc.spring.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeBean1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Prototypebean.class);
        Prototypebean prototypebean1 = ac.getBean(Prototypebean.class);
        prototypebean1.addCount();
        assertThat(prototypebean1.getCount()).isEqualTo(1);

        Prototypebean prototypebean2 = ac.getBean(Prototypebean.class);
        prototypebean1.addCount();
        assertThat(prototypebean1.getCount()).isEqualTo(1);
    }

    @Scope("prototype")
    static class Prototypebean {

        private int count = 0;

        public void addCount() {
            count++;
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
