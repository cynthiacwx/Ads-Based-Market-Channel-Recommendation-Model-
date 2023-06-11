package model.OrderManagement;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOffer;
import model.SalesManagement.SalesPersonProfile;

public class SolutionOrder {
    SolutionOffer solutionOffer;
    CustomerProfile customer;
    SalesPersonProfile salesperson;

    public SolutionOrder(CustomerProfile cp, SolutionOffer solutionOffer) {
        this.solutionOffer = solutionOffer;
        solutionOffer.addSolutionOrder(this);
        customer = cp;
        customer.addCustomerSolutionOrder(this); //we link the order to the customer
        salesperson = null;
    }

    //order total. Solution offer is bundled, so we assume that each order only contain one bundle.
    public int getOrderTotal() {
        return solutionOffer.getPrice();
    }

    public Market getMarket() {
        return solutionOffer.getMarketChannelAssignment().getMarket();
    }

    public Channel getChannel() {
        return solutionOffer.getMarketChannelAssignment().getChannel();
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return solutionOffer.getMarketChannelAssignment();
    }

    public SolutionOffer getSolutionOffer() {
        return solutionOffer;
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public SalesPersonProfile getSalesperson() {
        return salesperson;
    }
    
}
