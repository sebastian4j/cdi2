package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import java.util.concurrent.TimeUnit;

/**
 * @author Sebastián Ávila A.
 */
@Dependent
@SomeQualifierTwo(value = TimeUnit.DAYS, key = "hola")
// @Any
// @Default
// @Default is removed whenever you add explicit qualifiers
// solo usando @Named no se remueve el default
// every bean always has the @Any qualifier in its set of qualifiers.
// Following the normal CDI conventions, this qualifier is never removed.
public class ParaOtroServicioDos implements OtroServicio {

  @PostConstruct
  private void post() {
    System.out.println("otro-dos-dias: post");
  }
  
  @PreDestroy
  private void pre() {
    System.out.println("otro-dos-dias: pre");
  }
  
  @Override
  public String saludar() {
    return "otro-dos: hola desde";
  }
  
}
