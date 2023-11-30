package kr.co.kjc.spring.singleton;

import kr.co.kjc.spring.dip.config.AppConfig;
import kr.co.kjc.spring.dip.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너 - 싱글톤 패턴 X")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때 마다 객채를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때 마다 객채를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용 - 싱글톤 패턴 O")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

}