package com.pivotallabs.scratch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ModelTest {

  private Model subject;

  @Before
  public void setUp() {
    subject = new Model();
  }

  @Test
  public void testValue() {
    assertThat(subject.getValue(), is(7));
  }
}
