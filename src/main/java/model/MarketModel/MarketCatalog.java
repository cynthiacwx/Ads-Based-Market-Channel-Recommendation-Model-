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
public class MarketCatalog {
    
  ArrayList<Market> markets;

  public ArrayList<Market> getMarkets() {
    return markets;
  }

  public MarketCatalog() {
    markets = new ArrayList<>();
   }

  public Market newMarket(String name) {
    Market market = new Market(name);
    markets.add(market);
    return market;
  }

  public Market newMarket(String name, Market parentMarket) {
    Market market = new Market(name, parentMarket);
    markets.add(market);
    return market;
  }
    
}
