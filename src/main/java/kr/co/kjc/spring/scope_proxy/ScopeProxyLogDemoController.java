package kr.co.kjc.spring.scope_proxy;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kjc.spring.scope_proxy.common.ScopeProxyMyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ScopeProxyLogDemoController {

  private final ScopeProxyLogDemoService scopeProxyLogDemoService;
  private final ScopeProxyMyLogger scopeProxyMyLogger;  // logger를 그대로 DI를 해버리면 scope가 request로 되어있어서 request 요청이 들어온게 없는데 DI를 하다보니 스프링 부트 시작이 안된다.
                                   // SCope에서 프록시 모드가 필요.

  @RequestMapping("xscope-proxy-log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();
    scopeProxyMyLogger.setRequestURL(requestURL);
    scopeProxyMyLogger.log("controller test");
    scopeProxyLogDemoService.logic("testId");
    return "OK";
  }

}
