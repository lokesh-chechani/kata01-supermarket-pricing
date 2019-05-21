package com.kata01.shoppingcart.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lokeshchechani
 *
 */
public class CheckoutTest {

  @Test
  public void testWhenCheckoutWithNoItemThenTotalZero() {

    int expected =0;

    Checkout co = new Checkout();
    Assert.assertEquals(expected,co.getTotal());
  }

}
