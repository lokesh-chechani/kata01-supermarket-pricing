package com.kata01.shoppingcart.core;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by lokeshchechani
 *
 * Core class for SKU/Item
 */
@Data
@RequiredArgsConstructor
public class Item {

  @NonNull
  private String name;

  @NonNull
  private int unit;

  @NonNull
  private double price;


}
