package com.kata01.shoppingcart.offers;

import com.kata01.shoppingcart.core.Item;

/**
 * Created by lokeshchechani
 *
 * Concise contract for all the offers to be applied while checkout
 */
public interface Offer {

    Item applyOffer(Item item);

}
