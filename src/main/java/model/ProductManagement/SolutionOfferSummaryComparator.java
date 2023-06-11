package model.ProductManagement;

import java.util.Comparator;

public class SolutionOfferSummaryComparator implements Comparator<SolutionOfferSummary>{

    @Override
    public int compare(SolutionOfferSummary sos1, SolutionOfferSummary sos2) {
        return -1 * Integer.compare(sos1.calculateTotalSale(), sos2.calculateTotalSale());
    }
    
}
