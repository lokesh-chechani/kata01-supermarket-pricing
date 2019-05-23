package com.kata01.shoppingcart.offers;

import com.kata01.shoppingcart.core.Item;

/**
 * @author lokesh.chechani
 *
 * Concise contract for all the offers to be applied while checkout
 */
public interface Offer {

    Item applyOffer(Item item);

}
