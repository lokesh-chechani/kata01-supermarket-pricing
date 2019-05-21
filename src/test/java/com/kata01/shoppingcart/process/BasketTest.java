package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lokeshchechani
 *
 * JUnit test for Basket Test : Following TDD approach
 *
 */
public class BasketTest {

  @Test
  public void testWhenCheckoutWithNoItemThenTotalZero() {

    double expected =0;
    Basket basket = new Basket();
    Assert.assertEquals(expected,basket.getTotal(),0.001);

  }

  @Test
  public void testAddOneItemToBasket(){
    Basket basket = new Basket();

    Item shoppingItem = new Item("itemA",3,10.0);
    basket.addItemToBasket(shoppingItem);

    Assert.assertEquals(1,basket.getItemCount());

  }

}
