# Spring 입문
+ ## MVC와 템플릿 엔진
  + 웹 브라우저 -> 톰캣 서버 -> 스프링 컨테이너안에 있는 Controller가 받아서 viewResolver로 웹 브라우저로 return
+ ## API
  + @ResponseBody 이용
    + 웹 브라우저 -> 톰캣 서버 -> 스프링 컨테이너안에 있는 Controller가 받아서 HttpMessateConverter로 웹 브라우저로 return
      + 기본 문자처리 : StringHttpMessageConverter
      + 기본 객체처리 : MappingJackson2HttpMessageConverter(JsonConverter)
+  ## 컴포넌트 스캔과 자동 의존관계 설정
  + @Autowired
    + 생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
    + 이렇게 객체의존 관계를 외부에서 넣어주는 것을 DI(Dependency Injection), 의존성 주입이라 한다.
    + 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 '싱글톤'으로 등록한다(유일하게 하나만 등록해서 공유한다.)
    + 따라서 같은 스프링 빈이면 모두 같은 인스턴스다.
    + 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용한다.
  + @Component
    + 해당 애노테이션을 쓰면 스프링 빈으로 자동 등록된다.
  + @Controller
    + 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.
+ ## 주의 
  + Spring Boot 기준 
    + 컴포넌트 스캔시 main 메소드가 포함된 디렉토리에서만 컴포넌트 스캔이 적용된다.
    + 다른 디렉토리에서도 적용되게 하려면 @ComponentScan이 필요하다.
+ ## 순수 JDBC
  + 순서 
    1. Connection 연결 - Connection conn = getConnection();
    2. PrepareStatement 생성 - PrepareStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
    3. 파라미터 세팅 - pstmt.setString(1, 데이터 값);
    4. ResultSet 세팅 - ResultSet rs = pstmt.getGeneratedKeys()
+ ## 주의
  + 꼭 connection을 close 해야한다.
+ ## Spring Data JPA
  + 인터페이스를 통한 기본적인 CRUD
  + 페이징 기능 자동 제공
+ ## Spring AOP
  + ProceedingJoinPoint = joinPoint.proceed()로 비즈니스 로직 실행시간 측정 가능


+ # 스프링 기본
+ ## Spring FrameWork
  + 핵심 기술 : 스프링 DI 컨테이너, AOP, 이벤트, 기타
  + 웹 기술 : 스프링 MVC, 스프링 WebFlux
  + 데이터 접근 기술 : 트랜잭션, JDBC, ORM지원, XML 지원
  + 기술 통합 : 캐시, 이메일, 원격접근, 스케줄링
  + 테스트 : 스프링 기반 테스트 지원
  + 언어 : 코틀린, 그루비
+ ## Spring Boot
  + 스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용
  + 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
  + Tomcat 같은 웹 서버를 내장해서 별도의 우베 서버를 설치하지 않아도 됨
  + 손쉬운 빌드 구성을 위한 starter 종속성 제공
  + 스프링과 3rd parth(외부) 라이브러리 자동 구성
  + 메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공
  + 관례에 의한 간결한 설정
  
+ # 객체지향 프로그래밍
  + 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어사 여러개의 독립된 단위, 
    즉 "객체"들의 모임으로 파악하고자 하는 것이다.
    각각의 객체는 메시지를 주고받고, 데이터를 처리할 수 있다.
  + 프로그램을 유연하고 변경이 용이하게 만들기 때문에 대규모 스프링 소프트웨어 개발에 많이 사용된다.
  + ## 역활과 구현을 분리
    + 역활과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해딘다
    + 장점
      + 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
      + 클리이언트는 구현 대상의 내부 구조를 몰라도 된다.
      + 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
        + 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
    + 자바 언어의 다형성을 활용
      + ### 역할 : 인터페이스
      + ### 구현 : 인터페이스를 구현한 클래스 구현 객체
    + 객체를 설계할 때 역할과 구현을 명확히 분리
    + 객체 설계시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기
  + ## 다형성의 본질
    + 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
    + 다형성의 본질을 이해하려면 협력이라는 객체사이의 관계에서 시작해야함
    + 클라이언트를 변경하지 않고, 서버의 ㄱ현 기능을 유연하게 변경할 수 있다.