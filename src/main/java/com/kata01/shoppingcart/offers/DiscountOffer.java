package com.kata01.shoppingcart.offers;

import com.kata01.shoppingcart.core.Item;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author lokesh.chechani
 *
 * Promotional Discount such as 50% off on a item total
 */
@Data
@RequiredArgsConstructor
public class DiscountOffer implements Offer {

    @NonNull // Primitive yet nonNull - This is a lombok caveat to generate required args constructor
    private float percentPromotion; //Having float to yield percentage result in decimal


    @Override
    public Item applyOffer(Item item) {

        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }

        item.setCalculatedPrice(item.getCalculatedPrice()*percentPromotion/100);

        return item;

    }
}
