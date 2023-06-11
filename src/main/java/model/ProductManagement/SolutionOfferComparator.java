package model.ProductManagement;

import java.util.Comparator;

public class SolutionOfferComparator implements Comparator<SolutionOffer>{

    @Override
    public int compare(SolutionOffer so1, SolutionOffer so2) {
        return -1 * Integer.compare(so1.getAdBudget(), so2.getAdBudget());
    }
    
}
