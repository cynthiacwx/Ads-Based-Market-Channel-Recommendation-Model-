/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    
    Market market;
    Channel channel;
    int adBudget;
    int targetRevenue;
    ArrayList<SolutionOffer> solutionOffers; 

    public MarketChannelAssignment(Market m, Channel c){    
        market = m;
        channel = c;    
        solutionOffers = new ArrayList<>();
    }

    public void addSolutionOffer(SolutionOffer so) {
        solutionOffers.add(so);
    }

    public String getMarketName() {
        return market.getName();
    }

    public String getChannelType() {
        return channel.getChannelType();
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public int getTotalAdBudget() {
        int sum = 0;
        for (SolutionOffer solutionOffer : solutionOffers) {
            sum = sum + solutionOffer.getAdBudget();
        }
        return sum;
    }

    public int getTotalTargetRevenue() {
        int sum = 0;
        for (SolutionOffer solutionOffer : solutionOffers) {
            sum = sum + solutionOffer.getTargetRevenue();
        }
        return sum;
    }

    public int getTotalActualRevenue() {
        int sum = 0;
        for (SolutionOffer solutionOffer : solutionOffers) {
            sum = sum + solutionOffer.getTotalSale();
        }
        return sum;
    }

}
