package kr.co.kjc.spring.non_scope_proxy.web;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kjc.spring.non_scope_proxy.web.common.NonScopeProxyMyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NonScopeProxyLogDemoController {

  private final NonScopeProxyLogDemoService nonScopeProxyLogDemoService;
  private final ObjectProvider<NonScopeProxyMyLogger> myLoggerObjectProvider;  // ObjectProvider를 사용함으로써 의존관계 주입 시 요청을 지연시켜 준다.

  @RequestMapping("non-scope-proxy-log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();
    NonScopeProxyMyLogger nonScopeProxyMyLogger = myLoggerObjectProvider.getObject(); // getObject를 하는 시점에 빈 스코프가 실행히 되기 떄문에 스프링 부트 실행시 에러가 나지 않는다.
    nonScopeProxyMyLogger.setRequestURL(requestURL);
    nonScopeProxyMyLogger.log("controller test");
    nonScopeProxyLogDemoService.logic("testId");
    return "OK";
  }

}
