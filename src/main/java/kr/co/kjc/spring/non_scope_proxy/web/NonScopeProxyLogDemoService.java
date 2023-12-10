package kr.co.kjc.spring.non_scope_proxy.web;

import kr.co.kjc.spring.non_scope_proxy.web.common.NonScopeProxyMyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NonScopeProxyLogDemoService {

  private final ObjectProvider<NonScopeProxyMyLogger> myLoggerObjectProvider;

  public void logic(String id) {
    NonScopeProxyMyLogger nonScopeProxyMyLogger = myLoggerObjectProvider.getObject();
    nonScopeProxyMyLogger.log(id);
    System.out.println("service id : " + id);
  }

}
