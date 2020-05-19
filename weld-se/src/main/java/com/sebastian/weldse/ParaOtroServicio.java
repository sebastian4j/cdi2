package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import static java.util.concurrent.TimeUnit.HOURS;

/**
 * sin conflicto con otras implementaciones
 * @author Sebastián Ávila A.
 */
@Dependent
@SomeQualifierOne(HOURS)
public class ParaOtroServicio implements OtroServicio {

  @PostConstruct
  private void post() {
    System.out.println("otro-horas: post");
  }
  
  @PreDestroy
  private void pre() {
    System.out.println("otro-horas: pre");
  }
  
  @Override
  public String saludar() {
    return "otro: hola desde";
  }
  
}
