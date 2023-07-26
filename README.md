# Spring 1강
+ ## MVC와 템플릿 엔진
  + 웹 브라우저 -> 톰캣 서버 -> 스프링 컨테이너안에 있는 Controller가 받아서 viewResolver로 웹 브라우저로 return
+ ## API
  + @ResponseBody 이용
    + 웹 브라우저 -> 톰캣 서버 -> 스프링 컨테이너안에 있는 Controller가 받아서 HttpMessateConverter로 웹 브라우저로 return
      + 기본 문자처리 : StringHttpMessageConverter
      + 기본 객체처리 : MappingJackson2HttpMessageConverter(JsonConverter)
+  ## 컴포넌트 스캔과 자동 의존관계 설정
+ ## JPA
  + ### 구동 방식
    1. Build 파일을 통해서 JPA 인터페이스를 구현할 구현체 클래스인 Persistence를 생성
    2. 생성한 Persistence로 META-INF/Persistence.xml라는 설정파일 정보를 읽은 후 EntityManagerFactory를 생성
    3. 
  + ### 영속성 컨텍스트
    + 뜻 : "Entity를 영구 저장하는 환경" 
    + 예) : EntityManager.persist(entity);
    + -> DB에 바로 저장하는게 아닌 EntityManager를 통해서 영속성 컨텍스트에 저장해놓는다.
  + ### Entity
    + EntityManagerFactory : 
    + EntityManager 
      + EntityManagerFactory를 통해서 요청이 올 때마다 생성
      + EntityManager를 통해서 DB에 접근 및 CRUD 실행