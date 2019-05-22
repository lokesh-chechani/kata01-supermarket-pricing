package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
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

    double total = itemList.stream().mapToDouble(i -> i.getPrice()).sum();
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
    itemList.add(item);

  }

  private boolean clubbedWithDuplicateItem(Item itemToAdd) {

    int indexOfSameItem = itemList.indexOf(itemToAdd);

    if (indexOfSameItem != -1) { // Means item is exist and time to club this item with the one exist.
      Item duplicateItem = itemList.get(indexOfSameItem);

      duplicateItem.setPrice(duplicateItem.getPrice() + itemToAdd.getPrice());
      duplicateItem.setUnit(duplicateItem.getUnit() + itemToAdd.getUnit());

      itemList.set(indexOfSameItem, duplicateItem);

      return true;
    }

    return false;
  }




}
