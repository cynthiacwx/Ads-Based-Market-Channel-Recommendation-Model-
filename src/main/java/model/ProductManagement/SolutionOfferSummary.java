package model.ProductManagement;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

public class SolutionOfferSummary {
    Market market;
    Channel channel;
    MarketChannelAssignment mca;
    SolutionOffer solutionOffer;
    int totalSale;

    public SolutionOfferSummary(SolutionOffer solutionOffer) {
        market = solutionOffer.getMarketChannelAssignment().getMarket();
        channel = solutionOffer.getMarketChannelAssignment().getChannel();
        mca = solutionOffer.getMarketChannelAssignment();
        this.solutionOffer = solutionOffer;
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public MarketChannelAssignment getMcc() {
        return mca;
    }

    public SolutionOffer getSolutionOffer() {
        return solutionOffer;
    }

    public int calculateTotalSale() {
        return solutionOffer.getTotalSale();
    }

    public int getSolutionOrderQuantity() {
        return solutionOffer.getQuantityOfSales();
    }


    public String getSummary() {
        if (market.getParentMarketName()==null) {
            return  solutionOffer.getId() + " | " + market.getName() + " | " + " | " + channel.getChannelType() + " | " + getSolutionOrderQuantity() + " | " + solutionOffer.getAdBudget() + " | " + solutionOffer.getTargetRevenue() + " | " + calculateTotalSale();
        } else {
            return  solutionOffer.getId() + " | " + market.getParentMarketName() + " | " + market.getName() + " | " + channel.getChannelType() + " | " + getSolutionOrderQuantity() + " | " + solutionOffer.getAdBudget() + " | " + solutionOffer.getTargetRevenue() + " | " + calculateTotalSale();
        }
    }


    
}
