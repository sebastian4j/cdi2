package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 *
 * @author Sebastián Ávila A.
 */
public interface OtroServicio {

  @PostConstruct
  private void post() {
    System.out.println("otro: post");
  }

  @PreDestroy
  private void pre() {
    System.out.println("otro: pre");
  }

  String saludar();
}
