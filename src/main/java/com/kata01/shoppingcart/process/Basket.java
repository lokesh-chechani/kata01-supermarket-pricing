package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokeshchechani
 *
 * The class represent the Basket and its interfaces for checkout/
 *
 */

public class Basket {


  List<Item> itemList = new ArrayList<Item>();

  public double getTotal(){

    double total = itemList.stream().mapToDouble(i -> i.getPrice()).sum();
    return total;

  }

  public int getItemCount(){
    return itemList.size();
  }

  public void addItemToBasket(Item item){

    assert item != null : "Item can not be null while adding to basket";

    itemList.add(item);
  }



}
