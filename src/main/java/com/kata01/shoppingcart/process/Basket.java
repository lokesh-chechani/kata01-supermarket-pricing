package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
import com.kata01.shoppingcart.offers.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokeshchechani
 *
 * The class represent the Basket/Shopping Cart and its interfaces for checkout process.
 *
 */

public class Basket {

  private List<Item> itemList = new ArrayList<Item>();

  public double getTotal(){

    double total = itemList.stream().mapToDouble(i -> (i.getCalculatedPrice())).sum();
    return total;

  }

  public int getItemCount(){
    return itemList.size();
  }

  public void addItemToBasket(Item item){

    assert item != null : "Item can not be null while adding to basket";

    // Check if the item already exist in basket - Clubbing it
    if (clubbedWithDuplicateItem(item)){
      return;
    }
    item.setCalculatedPrice(item.getQuantity()*item.getUnitPrice());
    itemList.add(item);

  }

  //NoteOnly caveat with this approach is all the Offers needs to be applied at the end billing when all items added.
  public void applyOfferToBasket(Offer offer, String itemName){

    assert itemName!=null : "itemName must have valid name, should not be null";

    Item offerToApplyItem = findItemByItemName(itemName);

    if(offerToApplyItem == null){
        System.out.println(String.format("Offer item %s does not exist in basket, ignoring it", itemName));
        return;
    }

    Item offerAppliedItem = offer.applyOffer(offerToApplyItem);
    itemList.set(itemList.indexOf(offerToApplyItem),offerAppliedItem);

  }

  private boolean clubbedWithDuplicateItem(Item itemToAdd) {

    int indexOfSameItem = itemList.indexOf(itemToAdd);

    if (indexOfSameItem != -1) { // Means item is exist and time to club this item with the one exist.
      Item duplicateItem = itemList.get(indexOfSameItem);

      duplicateItem.setQuantity(duplicateItem.getQuantity() + itemToAdd.getQuantity());
      duplicateItem.setCalculatedPrice(duplicateItem.getQuantity()*duplicateItem.getUnitPrice());

      itemList.set(indexOfSameItem, duplicateItem);

      return true;
    }

    return false;
  }


  private Item findItemByItemName(String itemName) {

    Item found = itemList.stream()
            .filter(item -> itemName.equals(item.getName()))
            .findAny()
            .orElse(null);

    return found;
  }




}
