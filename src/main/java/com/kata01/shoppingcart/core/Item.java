package com.kata01.shoppingcart.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by lokeshchechani
 *
 * Core class for SKU/Item
 */
@Data
@RequiredArgsConstructor
@EqualsAndHashCode
public final class Item {

  @NonNull //Considering name to uniquely identify the item
  private String name;

  @NonNull
  @EqualsAndHashCode.Exclude
  private int unit;

  @NonNull
  @EqualsAndHashCode.Exclude
  private double price;

}
