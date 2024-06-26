package kr.co.kjc.spring.non_scope_proxy.web.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class NonScopeProxyMyLogger {

  private String uuid;
  private String requestURL;

  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }

  public void log(String message) {
    System.out.println(" [ " + uuid + " ] " + " [ " + requestURL + " ] " + message);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println(" [ " + uuid + " ] request scope bean create : " + this);
  }

  @PreDestroy
  public void close() {
    System.out.println(" [ " + uuid + " ] request scope bean close : " + this);
  }

}
