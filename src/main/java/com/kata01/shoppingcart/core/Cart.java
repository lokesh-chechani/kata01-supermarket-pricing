package com.kata01.shoppingcart.core;

import com.kata01.shoppingcart.offers.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lokesh.chechani
 *
 * The class represent the Cart/Shopping Cart and its interfaces for checkout process.
 *
 */

public class Cart {

  private List<Item> basket = new ArrayList<>();

  public double getTotal(){
    return basket.stream().mapToDouble(i -> (i.getCalculatedPrice())).sum();
  }

  public int getBasketSize(){
    return basket.size();
  }

  public void addItemToBasket(Item item){

    assert item != null : "Item can not be null while adding to basket";

    // Check if the item already exist in basket - Clubbing it
    if (clubbedWithDuplicateItem(item)){
      return;
    }
    item.setCalculatedPrice(item.getQuantity()*item.getUnitPrice());
    basket.add(item);

  }

  //NoteOnly caveat with this approach is all the Offers needs to be applied at the end billing when all items added.
  public void applyOfferToBasket(Offer offer, String itemName){

    assert offer != null : "Applied offer should not be null";
    assert itemName!=null : "itemName must have valid name, should not be null";

    Item offerToApplyItem = findItemByItemName(itemName);

    if(offerToApplyItem == null){
        System.out.println(String.format("Offer item %s does not exist in basket, ignoring it", itemName));
        return;
    }

    Item offerAppliedItem = offer.applyOffer(offerToApplyItem);
    basket.set(basket.indexOf(offerToApplyItem),offerAppliedItem);

  }

  private boolean clubbedWithDuplicateItem(Item itemToAdd) {

    int indexOfSameItem = basket.indexOf(itemToAdd);

    if (indexOfSameItem != -1) { // Means item is exist and time to club this item with the one exist.
      Item duplicateItem = basket.get(indexOfSameItem);

      duplicateItem.setQuantity(duplicateItem.getQuantity() + itemToAdd.getQuantity());
      duplicateItem.setCalculatedPrice(duplicateItem.getQuantity()*duplicateItem.getUnitPrice());

      basket.set(indexOfSameItem, duplicateItem);

      return true;
    }

    return false;
  }


  private Item findItemByItemName(String itemName) {

    Item found = basket.stream()
            .filter(item -> itemName.equals(item.getName()))
            .findAny()
            .orElse(null);

    return found;
  }




}
