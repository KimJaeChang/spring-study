package kr.co.kjc.spring.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        LifeCycleConfig client = ac.getBean(LifeCycleConfig.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkBeanImpllient networkClient() {
            NetworkBeanImpllient networkClient = new NetworkBeanImpllient();
            networkClient.setUrl("http://hello--spring-dev");
            return networkClient;
        }

    }

}
