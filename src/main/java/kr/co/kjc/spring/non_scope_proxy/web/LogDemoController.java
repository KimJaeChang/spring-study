package kr.co.kjc.spring.non_scope_proxy.web;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kjc.spring.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final ObjectProvider<MyLogger> myLoggerObjectProvider;  // ObjectProvider를 사용함으로써 의존관계 주입 시 요청을 지연시켜 준다.
  private final MyLogger myLogger;  // logger를 그대로 DI를 해버리면 scope가 request로 되어있어서 request 요청이 들어온게 없는데 DI를 하다보니 스프링 부트 시작이 안된다.

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();
    MyLogger myLogger = myLoggerObjectProvider.getObject(); // getObject를 하는 시점에 빈 스코프가 실행히 되기 떄문에 스프링 부트 실행시 에러가 나지 않는다.
    myLogger.setRequestURL(requestURL);
    myLogger.log("controller test");
    logDemoService.logic("testId");
    return "OK";
  }

}
