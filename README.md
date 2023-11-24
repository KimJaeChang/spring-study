# Spring 1강
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