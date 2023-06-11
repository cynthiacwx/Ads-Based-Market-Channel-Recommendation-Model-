package model.MarketModel;

import java.util.ArrayList;
import java.util.Collections;

public class MarketChannelAssignmentReport {
    ArrayList<MarketChannelAssignmentSummary> mccSummaryList;

    public MarketChannelAssignmentReport() {
        mccSummaryList = new ArrayList<>();
    }

    public void sortReportByActualRevenue() {
        MarketChannelAssignmentSummaryComparator comparator = new MarketChannelAssignmentSummaryComparator();
        Collections.sort(mccSummaryList, comparator);
    }

    public void convertToOrderReport(ArrayList<MarketChannelAssignment> mccList) {
        mccSummaryList = new ArrayList<>();
        for (MarketChannelAssignment mcc : mccList) {
            mccSummaryList.add(new MarketChannelAssignmentSummary(mcc));
        }
    }

    public void printMarketChannelAssignmentReport() {
        System.out.println("# | Market | Submarket | Channel Type | Ad Budget ($) | Target Revenue ($) | Actual Sales ($)");
        for (int i = 0; i < mccSummaryList.size(); i++) {
            System.out.println(i + " | " + mccSummaryList.get(i).getSummary());
        }
    }
    
}
