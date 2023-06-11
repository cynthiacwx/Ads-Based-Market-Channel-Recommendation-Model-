/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;

import model.CustomerManagement.CustomerDirectory;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignmentCatalog;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterSolutionOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

  String name;
  PersonDirectory persondirectory;
  MasterOrderList masterorderlist;
  CustomerDirectory customers;
  SupplierDirectory suppliers;
  MarketCatalog marketcatalog;
  ChannelCatalog channelcatalog;
  MarketChannelAssignmentCatalog marketchannelassignmentcatalog;
  SolutionOfferCatalog solutionoffercatalog;
  MasterSolutionOrderList mastersolutionorderlist;
  CustomerDirectory customerdirectory;
  EmployeeDirectory employeedirectory;
  SalesPersonDirectory salespersondirectory;
  UserAccountDirectory useraccountdirectory;
  MarketingPersonDirectory marketingpersondirectory;

  public Business(String n) {
    name = n;
    masterorderlist = new MasterOrderList();
    suppliers = new SupplierDirectory();
    persondirectory = new PersonDirectory();
    customerdirectory = new CustomerDirectory(this);
    salespersondirectory = new SalesPersonDirectory(this);
    useraccountdirectory = new UserAccountDirectory();
    marketingpersondirectory = new MarketingPersonDirectory(this);
    employeedirectory = new EmployeeDirectory(this);
    marketcatalog = new MarketCatalog();
    channelcatalog = new ChannelCatalog();
    marketchannelassignmentcatalog = new MarketChannelAssignmentCatalog();
    solutionoffercatalog = new SolutionOfferCatalog();
    mastersolutionorderlist = new MasterSolutionOrderList();
  }

  public int getSalesVolume() {
    return masterorderlist.getSalesVolume();
  }

  public PersonDirectory getPersonDirectory() {
    return persondirectory;
  }

  public UserAccountDirectory getUserAccountDirectory() {
    return useraccountdirectory;
  }

  public MarketingPersonDirectory getMarketingPersonDirectory() {
    return marketingpersondirectory;
  }

  public SupplierDirectory getSupplierDirectory() {
    return suppliers;
  }

  public ProductsReport getSupplierPerformanceReport(String n) {
    Supplier supplier = suppliers.findSupplier(n);
    if (supplier == null) {
      return null;
    }
    return supplier.prepareProductsReport();
  }

  public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(
    String n
  ) {
    ProductsReport productsreport = getSupplierPerformanceReport(n);
    return productsreport.getProductsAlwaysAboveTarget();
  }

  public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
    ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
    int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
    return i;
  }

  public CustomerDirectory getCustomerDirectory() {
    return customerdirectory;
  }

  public SalesPersonDirectory getSalesPersonDirectory() {
    return salespersondirectory;
  }

  public MasterOrderList getMasterOrderList() {
    return masterorderlist;
  }

  public EmployeeDirectory getEmployeeDirectory() {
    return employeedirectory;
  }

  public MarketCatalog getMarketcatalog() {
    return marketcatalog;
  }

  public ChannelCatalog getChannelcatalog() {
    return channelcatalog;
  }

  public MarketChannelAssignmentCatalog getMarketChannelAssignmentCatalog() {
    return marketchannelassignmentcatalog;
  }

  public SolutionOfferCatalog getSolutionoffercatalog() {
    return solutionoffercatalog;
  }

  public MasterSolutionOrderList getMastersolutionorderlist() {
    return mastersolutionorderlist;
  }
}
