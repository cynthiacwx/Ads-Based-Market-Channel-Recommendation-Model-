/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;


/**
 *
 * @author kal bugrara
 */
public class Market {
  String name;
  Market parentMarket;
  ArrayList<String> characteristics;
  ArrayList<Market> submarkets;
  int size;

  public Market(String m) {
    name = m;
    // solutionOffers = new ArrayList<>();
    characteristics = new ArrayList<String>();
    submarkets = new ArrayList<>();
  }

  public Market(String m, Market parentMarket) {
    name = m;
    this.parentMarket = parentMarket;
    parentMarket.addSubMarket(this);
    // solutionOffers = new ArrayList<>();
    characteristics = new ArrayList<String>();
    submarkets = new ArrayList<>();
  }

  public void addSubMarket(Market subMarket) {
    submarkets.add(subMarket);
    subMarket.setParentMarket(this);
  }

  public void addCharacteristics(String c) {
    characteristics.add(c);
  }

  public String getName() {
    return name;
  }

  public Market getParentMarket() {
    return parentMarket;
  }

  public void setParentMarket(Market parentMarket) {
    this.parentMarket = parentMarket;
  }

  public String getParentMarketName() {
    return parentMarket.getName();
  }

  public ArrayList<String> getCharacteristics() {
    return characteristics;
  }

  public ArrayList<Market> getSubmarkets() {
    return submarkets;
  }

  public int getSize() {
    return size;
  }

  public boolean hasSubMarkets() {
    return submarkets.size() > 0;
  }

}
