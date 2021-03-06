package com.kata01.shoppingcart.core;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author lokesh.chechani
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
  private int quantity;

  @NonNull
  @EqualsAndHashCode.Exclude
  private double unitPrice;


  @EqualsAndHashCode.Exclude
  private double calculatedPrice;


}
