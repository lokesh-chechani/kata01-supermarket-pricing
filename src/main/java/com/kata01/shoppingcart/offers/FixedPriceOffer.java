package com.kata01.shoppingcart.offers;

import com.kata01.shoppingcart.core.Item;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author lokesh.chechani
 *
 * Fixed Price Offer such as buy 2 Coke for £1
 */
@Data
@RequiredArgsConstructor
public class FixedPriceOffer implements Offer {

    @NonNull // Primitive yet nonNull - This is a lombok caveat to generate required args constructor
    private double fixedPrice;

    @NonNull
    private int offerQuantity;


    @Override
    public Item applyOffer(Item item) {


        if (fixedPrice < 0 ) {
            throw new IllegalArgumentException("Discount Prices must be positive");
        }

        int totalItemInBakset = item.getQuantity();

        int noOfBundles = totalItemInBakset/offerQuantity;
        int remainingItems = totalItemInBakset%offerQuantity;

        double totalPriceAfterOffer = (noOfBundles * fixedPrice) + (remainingItems * item.getUnitPrice());

        // This can be converted in logging.
        System.out.println(String.format("Buy %d for price of %f Offer applied on item %s. Final unitPrice = %f against total quantities = %d",offerQuantity,fixedPrice,item.getName(),totalPriceAfterOffer,totalItemInBakset));

        item.setCalculatedPrice(totalPriceAfterOffer);

        return item;

    }
}
