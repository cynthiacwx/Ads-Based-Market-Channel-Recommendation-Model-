package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.ProductManagement.SolutionOffer;

public class MasterSolutionOrderList {
    ArrayList<SolutionOrder> solutionOrders;

    public MasterSolutionOrderList() {
        solutionOrders = new ArrayList<SolutionOrder>();
    }

    public SolutionOrder newSolutionOrder(CustomerProfile cp, SolutionOffer solutionOffer) {
        SolutionOrder solutionOrder = new SolutionOrder(cp, solutionOffer);
        solutionOrders.add(solutionOrder);
        solutionOffer.addSolutionOrder(solutionOrder);
        return solutionOrder;
    }

    public int getSalesVolume() {
        int sum = 0;
        for (SolutionOrder solutionOrder : solutionOrders) {
            sum = sum + solutionOrder.getOrderTotal();
        }
        return sum;
    }

    public ArrayList<SolutionOrder> getSolutionOrders() {
        return solutionOrders;
    }
    
}
