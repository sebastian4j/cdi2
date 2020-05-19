package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
public class ProductorService {
  private final Servicio ss;
  
  @PostConstruct
  private void post() {
    System.out.println("productor: post");
  }
  
  @Inject
  public ProductorService(SaludadorService ss) {
    System.out.println("productor: instanciado");
    this.ss = ss;
  }
  
  @Produces
  public Servicio produce(@SomeQualifierOne(TimeUnit.DAYS) OtroServicio os) {
    System.out.println("productor: invocado");
    return ss;
  }
}
