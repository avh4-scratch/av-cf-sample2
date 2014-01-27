package com.pivotallabs.scratch;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

  private Model subject;

  @Before
  public void setUp() {
    subject = new Model();
  }

  @Test
  public void testValue() {
    assertThat(subject.getValue()).isEqualTo(7);
  }
}
