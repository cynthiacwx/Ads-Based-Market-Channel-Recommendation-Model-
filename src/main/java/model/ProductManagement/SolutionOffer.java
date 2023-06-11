/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
  String id;
  ArrayList<Product> products;
  int price; //floor, ceiling, and target ideas
  int adBudget;
  int targetRevenue;
  MarketChannelAssignment marketChannelAssignment;
  ArrayList<SolutionOrder> solutionOrders;
  String description;

  public SolutionOffer(String id, MarketChannelAssignment m) {
    this.id = id;
    products = new ArrayList<Product>();
    solutionOrders = new ArrayList<>();
    marketChannelAssignment = m;
    marketChannelAssignment.addSolutionOffer(this);
  }

  public SolutionOffer(String id, MarketChannelAssignment m, int price) {
    this.id = id;
    this.price = price;
    products = new ArrayList<Product>();
    solutionOrders = new ArrayList<>();
    marketChannelAssignment = m;
    marketChannelAssignment.addSolutionOffer(this);
  }

  public SolutionOffer(String id, MarketChannelAssignment m, int price, int adBudget, int targetRevenue) {
    this.id = id;
    this.price = price;
    this.adBudget = adBudget;
    this.targetRevenue = targetRevenue;
    products = new ArrayList<Product>();
    solutionOrders = new ArrayList<>();
    marketChannelAssignment = m;
    marketChannelAssignment.addSolutionOffer(this);
  }

  public void addProduct(Product p) {
    products.add(p);
  }

  public void setPrice(int p) {
    price = p;
  }

  public boolean isOfferTargetMarketChannel(MarketChannelAssignment mca) {
    return marketChannelAssignment.getMarketName().equals(mca.getMarketName()) && marketChannelAssignment.getChannelType().equals(mca.getChannelType());
  }

  public boolean isOfferTargetMarket(Market market) {
    return marketChannelAssignment.getMarketName().equals(market.getName());
  }

  public boolean isOfferTargetChannel(Channel channel) {
    return marketChannelAssignment.getChannelType().equals(channel.getChannelType());
  }

  public String getId() {
    return id;
  }
  
  public int getPrice() {
    return price;
  }

  public MarketChannelAssignment getMarketChannelAssignment() {
    return marketChannelAssignment;
  }

  public String getProductToString() {
    ArrayList<String>  productNames= new ArrayList<>();
    for (Product p : products) {
      productNames.add(p.getName());
    }
    return String.join("/", productNames);
  }

  public void addSolutionOrder(SolutionOrder solutionOrder) {
    solutionOrders.add(solutionOrder);
  }

  public int getQuantityOfSales() {
    return solutionOrders.size();
  }

  public int getTotalSale() {
    int sum = 0;
    for (SolutionOrder solutionOrder : solutionOrders) {
      sum = sum + solutionOrder.getOrderTotal();
    }

    return sum;
  }

  public int getAdBudget() {
    return adBudget;
  }

  public void setAdBudget(int adBudget) {
    this.adBudget = adBudget;
  }

  public int getTargetRevenue() {
    return targetRevenue;
  }

  public void setTargetRevenue(int targetRevenue) {
    this.targetRevenue = targetRevenue;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
