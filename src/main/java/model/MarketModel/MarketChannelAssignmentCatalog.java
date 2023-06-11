package model.MarketModel;

import java.util.ArrayList;

public class MarketChannelAssignmentCatalog {
    ArrayList<MarketChannelAssignment> mcaList;

    public MarketChannelAssignmentCatalog() {
        mcaList = new ArrayList<>();
    }

    public MarketChannelAssignment newMarketChannelAssignment(Market market, Channel channel) {
        MarketChannelAssignment mca = new MarketChannelAssignment(market, channel);
        mcaList.add(mca);
        return mca;
    }

    public ArrayList<MarketChannelAssignment> getMcaList() {
        return mcaList;
    } 

    public ArrayList<MarketChannelAssignment> getMcaListByMarket(Market market) {
        ArrayList<MarketChannelAssignment> foundMca = new ArrayList<>();
        for (MarketChannelAssignment mca : mcaList) {
            if (mca.getMarketName().equals(market.getName())) {
                foundMca.add(mca);
            }
        }
        return foundMca;
    }
}
