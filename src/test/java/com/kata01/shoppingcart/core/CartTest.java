package com.kata01.shoppingcart.core;

import com.kata01.shoppingcart.offers.BuyXforYOffer;
import com.kata01.shoppingcart.offers.DiscountOffer;
import com.kata01.shoppingcart.offers.FixedPriceOffer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lokesh.chechani
 *
 * JUnit test for Cart Test : Following TDD approach
 *
 */
public class CartTest {

  @Test
  public void testWhenCheckoutWithNoItemThenTotalZero() {

    double expected =0;
    Cart cart = new Cart();
    Assert.assertEquals(expected, cart.getTotal(),0.001);

  }

  @Test
  public void testAddOneItemToBasket(){
    Cart cart = new Cart();

    Item shoppingItem = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItem);

    Assert.assertEquals(1, cart.getBasketSize());

    double expectedTotalForSingleItem = 30.0;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);

  }

  @Test
  public void testAddMoreDifferentItemToBasket() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    cart.addItemToBasket(shoppingItemB);

    int expectedCount = 2;
    Assert.assertEquals(expectedCount, cart.getBasketSize());

    double expectedTotalForSingleItem = 90;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);

  }

  @Test
  public void testAddSameItemMoreThanOneToBasket() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    cart.addItemToBasket(shoppingItemB);

    Item shoppingItemAa =  new Item("itemA",5,10.0);
    cart.addItemToBasket(shoppingItemAa);

    int expectedCount = 2;
    Assert.assertEquals(expectedCount, cart.getBasketSize());

    double expectedTotalForSingleItem = 140;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);
  }

  @Test
  public void testBuyXforYOffer() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    cart.addItemToBasket(shoppingItemB);

    Item shoppingItemAa =  new Item("itemA",5,10.0);
    cart.addItemToBasket(shoppingItemAa);

    BuyXforYOffer xforYOffer = new BuyXforYOffer(3,2);
    cart.applyOfferToBasket(xforYOffer,"itemA");

    double expectedTotalForSingleItem = 120;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);
  }


  @Test
  public void testGetFiftyPercentDiscountOffer() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    Item shoppingItemB = new Item("itemB",2,30.0);
    cart.addItemToBasket(shoppingItemB);


    DiscountOffer discountOffer = new DiscountOffer(50);
    cart.applyOfferToBasket(discountOffer,"itemA");

    double expectedTotalForSingleItem = 75;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);
  }

  @Test
  public void testGetTwoItemsForOnePountOffer() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    FixedPriceOffer fixedPriceOffer = new FixedPriceOffer(1,2);
    cart.applyOfferToBasket(fixedPriceOffer,"itemA");

    double expectedTotalForSingleItem = 11;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);
  }

  @Test
  public void testOfferOnItemNotPresntInBasket() {
    Cart cart = new Cart();

    Item shoppingItemA = new Item("itemA",3,10.0);
    cart.addItemToBasket(shoppingItemA);

    FixedPriceOffer fixedPriceOffer = new FixedPriceOffer(1,2);
    cart.applyOfferToBasket(fixedPriceOffer,"itemX");

    double expectedTotalForSingleItem = 30;
    Assert.assertEquals(expectedTotalForSingleItem, cart.getTotal(),0.001);
  }



}
