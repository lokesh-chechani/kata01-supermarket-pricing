package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
import com.kata01.shoppingcart.offers.BuyXforYOffer;
import com.kata01.shoppingcart.offers.DiscountOffer;
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

    double expectedTotalForSingleItem = 30.0;
    Assert.assertEquals(expectedTotalForSingleItem,basket.getTotal(),0.001);

  }

  @Test
  public void testAddMoreDifferentItemToBasket() {
    Basket basket = new Basket();

    Item shoppingItemA = new Item("itemA",3,10.0);
    basket.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    basket.addItemToBasket(shoppingItemB);

    int expectedCount = 2;
    Assert.assertEquals(expectedCount,basket.getItemCount());

    double expectedTotalForSingleItem = 90;
    Assert.assertEquals(expectedTotalForSingleItem,basket.getTotal(),0.001);

  }

  @Test
  public void testAddSameItemMoreThanOneToBasket() {
    Basket basket = new Basket();

    Item shoppingItemA = new Item("itemA",3,10.0);
    basket.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    basket.addItemToBasket(shoppingItemB);

    Item shoppingItemAa =  new Item("itemA",5,10.0);
    basket.addItemToBasket(shoppingItemAa);

    int expectedCount = 2;
    Assert.assertEquals(expectedCount,basket.getItemCount());

    double expectedTotalForSingleItem = 140;
    Assert.assertEquals(expectedTotalForSingleItem,basket.getTotal(),0.001);
  }

  @Test
  public void testBuyXforYOffer() {
    Basket basket = new Basket();

    Item shoppingItemA = new Item("itemA",3,10.0);
    basket.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    basket.addItemToBasket(shoppingItemB);

    Item shoppingItemAa =  new Item("itemA",5,10.0);
    basket.addItemToBasket(shoppingItemAa);

    BuyXforYOffer xforYOffer = new BuyXforYOffer(3,2);
    basket.applyOfferToBasket(xforYOffer,"itemA");

    double expectedTotalForSingleItem = 120;
    Assert.assertEquals(expectedTotalForSingleItem,basket.getTotal(),0.001);
  }


  @Test
  public void testGetFiftyPercentDiscountOffer() {
    Basket basket = new Basket();

    Item shoppingItemA = new Item("itemA",3,10.0);
    basket.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    basket.addItemToBasket(shoppingItemB);


    DiscountOffer discountOffer = new DiscountOffer(50);
    basket.applyOfferToBasket(discountOffer,"itemA");

    double expectedTotalForSingleItem = 75;
    Assert.assertEquals(expectedTotalForSingleItem,basket.getTotal(),0.001);
  }



}
