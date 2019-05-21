package com.kata01.shoppingcart.process;

import com.kata01.shoppingcart.core.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokeshchechani
 *
 */

public class Basket {


  List<Item> itemList = new ArrayList<Item>();

  public double getTotal(){
    //TODO : Finish here
    return 0;
  }

  public int getItemCount(){
    return itemList.size();
  }

  public void addItemToBasket(Item item){

    assert item != null : "Item can not be null while adding to basket";

    itemList.add(item);
  }



}
