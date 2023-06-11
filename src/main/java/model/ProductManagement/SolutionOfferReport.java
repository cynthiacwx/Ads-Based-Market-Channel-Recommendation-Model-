package model.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionOfferReport {
    ArrayList<SolutionOfferSummary> solutionOfferSummaryList;

    public SolutionOfferReport() {
        solutionOfferSummaryList = new ArrayList<>();
    }

    public void convertToSolutionOfferReport(ArrayList<SolutionOffer> solutionOffers) {
        solutionOfferSummaryList = new ArrayList<>();
        for (SolutionOffer so : solutionOffers) {
            solutionOfferSummaryList.add(new SolutionOfferSummary(so));
        }
    }

    public void sortReportByTotalSale() {
        SolutionOfferSummaryComparator comparator = new SolutionOfferSummaryComparator();
        Collections.sort(solutionOfferSummaryList, comparator);
    }

    public void printSolutionOfferReport() {
        System.out.println("# | Solution Offer Id | Market | Submarket | Channel | Quantity of Orders | Ad Budget ($) | Target Revenue ($) | Actual Sales ($)");
        for (int i = 0; i < solutionOfferSummaryList.size(); i++) {
            System.out.println(i + " | " + solutionOfferSummaryList.get(i).getSummary());
        }
    } 
    
}
