package kr.co.kjc.spring.non_scope_proxy.web;

import kr.co.kjc.spring.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final ObjectProvider<MyLogger> myLoggerObjectProvider;

  public void logic(String id) {
    MyLogger myLogger = myLoggerObjectProvider.getObject();
    myLogger.log(id);
    System.out.println("service id : " + id);
  }

}
