package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import java.util.concurrent.TimeUnit;

/**
 * sin conflicto con otras implementaciones
 * @author Sebastián Ávila A.
 */
@Dependent
@SomeQualifierOne(TimeUnit.DAYS)
public class ParaOtroServicioDias implements OtroServicio {

  @PostConstruct
  private void post() {
    System.out.println("otro-dias: post");
  }
  
  @PreDestroy
  private void pre() {
    System.out.println("otro-dias: pre");
  }
  
  @Override
  public String saludar() {
    return "otro-dias: hola desde";
  }
  
}
