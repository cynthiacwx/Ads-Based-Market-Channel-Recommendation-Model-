package model.MarketModel;

public class MarketChannelAssignmentSummary {
    Market market;
    Channel channel;
    int adBudget;
    int targetRevenue;
    int totalSale;

    public MarketChannelAssignmentSummary(MarketChannelAssignment mca) {
        market = mca.getMarket();
        channel = mca.getChannel();
        adBudget = mca.getTotalAdBudget();
        targetRevenue = mca.getTotalTargetRevenue();
        totalSale = mca.getTotalActualRevenue();
    }

    public String getSummary() {
        if (market.getParentMarketName()==null) {
            return market.getName() + " | " + " | " + channel.getChannelType() + " | " + adBudget + " | " + " | " + targetRevenue + " | " + totalSale;
        } else {
            return market.getParentMarketName() + " | " + market.getName() + " | " + channel.getChannelType() + " | " + adBudget + " | " + targetRevenue + " | " + totalSale;
        }
    } 

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public int getAdBudget() {
        return adBudget;
    }

    public int getTargetRevenue() {
        return targetRevenue;
    }

    public int getTotalSale() {
        return totalSale;
    }
    
}
