package com.kata01.shoppingcart.offers;

import com.kata01.shoppingcart.core.Item;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author lokesh.chechani
 *
 * Offer Buy  2 for 3 use case
 */
@Data
@RequiredArgsConstructor
public class BuyXforYOffer implements Offer {

    @NonNull // Lombok annotation for making required args constructor
    private final int x;

    @NonNull
    private final int y;

    @Override
    public Item applyOffer(Item item){
        int totalItemInBakset = item.getQuantity();

        int noOfBundles = totalItemInBakset/x;
        int remainderItemToAddUp = totalItemInBakset%x;

        double totalPriceAfterOffer = (noOfBundles * y + remainderItemToAddUp) * item.getUnitPrice();

        // This can be converted in logging.
        System.out.println(String.format("Buy %dfor%d Offer applied on item %s. Final unitPrice = %f against total quantities = %d",x,y,item.getName(),totalPriceAfterOffer,totalItemInBakset));

        item.setCalculatedPrice(totalPriceAfterOffer);

        return item;

    }






}
