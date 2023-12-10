package kr.co.kjc.spring.scope_proxy;

import kr.co.kjc.spring.scope_proxy.common.ScopeProxyMyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScopeProxyLogDemoService {

  private final ScopeProxyMyLogger scopeProxyMyLogger;

  public void logic(String id) {
    scopeProxyMyLogger.log(id);
    System.out.println("service id : " + id);
  }

}
