package kr.co.kjc.spring.dip.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "kr.co.kjc.spring.*"     // default는 @ComponentScan이 붙은 경로인 kr.co.kjc.spring.config 내부에서 찾기 때문에 custom 설정 필요
)
public class AutoAppConfig {
}
