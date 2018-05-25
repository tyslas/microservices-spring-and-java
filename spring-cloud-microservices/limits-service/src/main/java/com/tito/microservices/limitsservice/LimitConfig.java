package com.tito.microservices.limitsservice;

public class LimitConfig {
  private int max;
  private int min;

  protected LimitConfig() {
  }

  public LimitConfig(int max, int min) {
    this.max = max;
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public int getMin() {
    return min;
  }
}
