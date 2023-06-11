/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionOffers;

    public SolutionOfferCatalog() {
        solutionOffers = new ArrayList<>();  ///create the list of elements otherwise it is null
    }

    public ArrayList<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    public SolutionOffer newSolutionOffer(String id, MarketChannelAssignment mca, int price, int adBudget, int targetRevenue) {
        SolutionOffer solutionOffer = new SolutionOffer(id, mca, price, adBudget, targetRevenue);
        solutionOffers.add(solutionOffer);
        return solutionOffer;
    }

    public ArrayList<SolutionOffer> findSolutionsByMarketChannelAssignment(Market market, Channel channel) {
        ArrayList<SolutionOffer> foundSolutions = new ArrayList<>();
        
        for (SolutionOffer so : solutionOffers) {
            if (so.isOfferTargetMarket(market) && so.isOfferTargetChannel(channel)) {
                foundSolutions.add(so);
            }
        }
        // sort the solution bundles by its ad budget. Higher ad budget means it should be input in front
        SolutionOfferComparator comparator = new SolutionOfferComparator();
        Collections.sort(foundSolutions, comparator);

        return foundSolutions;
    }

    public ArrayList<SolutionOffer> findSolutionsFByMarketChannelAssignmentAndProduct(Market market, Channel channel, String productName) {
        // if search by product name, we will display matched solution offers first, 
        // then those non-matched ones, sorted by ad budget.

        ArrayList<SolutionOffer> foundSolutions = new ArrayList<>();
        ArrayList<SolutionOffer> foundSolutionsForMatchedProduct = new ArrayList<>();
        ArrayList<SolutionOffer> foundSolutionsForNonMatchedProduct = new ArrayList<>();

        for (SolutionOffer so : solutionOffers) {
            if (so.isOfferTargetMarket(market) && so.isOfferTargetChannel(channel)) {
                if (so.getProductToString().contains(productName)) {
                    foundSolutionsForMatchedProduct.add(so);
                } else {
                    foundSolutionsForNonMatchedProduct.add(so);
                }
            } 
        }

        SolutionOfferComparator comparator = new SolutionOfferComparator();
        Collections.sort(foundSolutionsForMatchedProduct, comparator);
        Collections.sort(foundSolutionsForNonMatchedProduct, comparator);

        foundSolutions.addAll(foundSolutionsForMatchedProduct);
        foundSolutions.addAll(foundSolutionsForNonMatchedProduct);

        return foundSolutions;
    }

    public void displaySolutionOffers(ArrayList<SolutionOffer> foundSolutions) {
        System.out.println("# | Products | Price | Ad Budget |");
        for (int i = 0; i < foundSolutions.size(); i++) {
            SolutionOffer so = foundSolutions.get(i);
            System.out.println(i + " | " + so.getProductToString() + " | " + so.getPrice() + " | " + so.getAdBudget());
        }
    }
    
}
