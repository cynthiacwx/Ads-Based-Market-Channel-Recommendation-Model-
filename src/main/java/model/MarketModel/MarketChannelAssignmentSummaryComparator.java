package model.MarketModel;

import java.util.Comparator;

public class MarketChannelAssignmentSummaryComparator implements Comparator<MarketChannelAssignmentSummary> {

    @Override
    public int compare(MarketChannelAssignmentSummary mccs1, MarketChannelAssignmentSummary mccs2) {
        return -1 * Integer.compare(mccs1.getTotalSale(), mccs2.getTotalSale());
    }
}
