/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.MarketModel.MarketChannelAssignmentCatalog;
import model.MarketModel.MarketChannelAssignmentReport;
import model.OrderManagement.MasterSolutionOrderList;
import model.Personnel.Person;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.ProductManagement.SolutionOfferReport;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Business business = ConfigureABusiness.initialize("Best Buy");

    Faker faker = new Faker();
    Random randomGenerator = new Random();

    // Load 6 markets (3 parent markets and each parent market has two submarket):
    // US: US-Male and US-Female
    // France: France-Male and France-Female
    // China: China-Male and China-Female
    MarketCatalog mc = business.getMarketcatalog();
    Market usMarket = new Market("US");
    // only add submarket to market catalog
    Market usMaleMarket = mc.newMarket("US-Male", usMarket);
    Market usFemaleMarket = mc.newMarket("US-Female", usMarket);

    Market franceMarket = new Market("France");
    Market franceMaleMarket = mc.newMarket("France-Male", franceMarket);
    Market franceFemaleMarket = mc.newMarket("France-Female", franceMarket);

    Market chinaMarket = new Market("China");
    Market chinaMaleMarket = mc.newMarket("China-Male", chinaMarket);
    Market chinaFemaleMarket = mc.newMarket("China-Female", chinaMarket);

    // Load 3 channels: Youtube, Facebook, TikTok 
    ChannelCatalog cc = business.getChannelcatalog();
    Channel youtubeChannel = cc.newChannel("Youtube");
    Channel facebookChannel = cc.newChannel("Facebook");
    Channel tiktokChannel = cc.newChannel("TikTok");

    // Load market-channel-assignment for each 6 submarkets and 3 channels;
    MarketChannelAssignmentCatalog mcac = business.getMarketChannelAssignmentCatalog();
    for (Market market : mc.getMarkets()) {
      for (Channel channel : cc.getChannels()) {
        mcac.newMarketChannelAssignment(market, channel);
      }
    }

    // We will create three types of bundles: phones, computers and tablets for all the market-channel-assignment we created earlier
    ArrayList<String> phoneList = new ArrayList<>(Arrays.asList("iphone 14", "iphone 13", "Samsung S20", "Pixel 5"));
    ArrayList<String> computerList = new ArrayList<>(Arrays.asList("Mac Air", "Dell Inspiron", "HP ENVY"));
    ArrayList<String> tabletList = new ArrayList<>(Arrays.asList("iPad", "Samsung Galaxy", "Microsoft Surface"));

    SolutionOfferCatalog soc = business.getSolutionoffercatalog();

    // for us market, we will have all those products
    ArrayList<MarketChannelAssignment> usMcaList = new ArrayList<>();
    usMcaList.addAll(mcac.getMcaListByMarket(usMaleMarket));
    usMcaList.addAll(mcac.getMcaListByMarket(usFemaleMarket));
    for (MarketChannelAssignment mca : usMcaList) {
      for (String phone : phoneList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(phone, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(phone));
      }
      for (String computer : computerList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(computer, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(computer));
      }
      for (String tablet : tabletList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(tablet, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(tablet));
      }
    }

    // for Franch market, we will have phone and computer products
    ArrayList<MarketChannelAssignment> franceMcaList = new ArrayList<>();
    franceMcaList.addAll(mcac.getMcaListByMarket(franceMaleMarket));
    franceMcaList.addAll(mcac.getMcaListByMarket(franceFemaleMarket));
    for (MarketChannelAssignment mca : franceMcaList) {
      for (String phone : phoneList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(phone, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(phone));
      }
      for (String computer : computerList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(computer, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(computer));
      }
    }

    // for china market, we will have phone and tablets
    ArrayList<MarketChannelAssignment> chinaMcaList = new ArrayList<>();
    chinaMcaList.addAll(mcac.getMcaListByMarket(chinaMaleMarket));
    chinaMcaList.addAll(mcac.getMcaListByMarket(chinaFemaleMarket));
    for (MarketChannelAssignment mca : chinaMcaList) {
      for (String phone : phoneList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(phone, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(phone));
      }
      for (String tablet : tabletList) {
        int solutionOffPrice = 100*randomGenerator.nextInt(9, 12);
        int adBudget = 100*randomGenerator.nextInt(10,100);
        int targetRevenue = 100*randomGenerator.nextInt(100, 201);

        SolutionOffer solutionOffer = soc.newSolutionOffer(tablet, mca, solutionOffPrice, adBudget, targetRevenue);
        solutionOffer.addProduct(new Product(tablet));
      }
    }

    // We will see the result when customer can search from his/her market-channel
    // assume customer1 is looking at usMale - Facebook market channel, the system will display those solutionOffers:
    // sorted by ad budget
    ArrayList<SolutionOffer> usMaleFacebookOffers1 = soc.findSolutionsByMarketChannelAssignment(usMaleMarket, facebookChannel);
    System.out.println("Customer 1 displaying list in US Male Market - Facebook Channel");
    soc.displaySolutionOffers(usMaleFacebookOffers1);

    System.out.println();
    // assume customer2 is also looking at usMale - Facebook market channel, but searched "iphone", the system will display those solutionOffers:
    // sorted by matched products and then ad budget
    ArrayList<SolutionOffer> usMaleFacebookOffers2 = soc.findSolutionsFByMarketChannelAssignmentAndProduct(usMaleMarket, facebookChannel, "iphone");
    System.out.println("Customer 2 displaying list in US Male Market - Facebook Channel when searching iphone only");
    soc.displaySolutionOffers(usMaleFacebookOffers2);

    System.out.println();
    // assume customer3 is looking at franceFemale - Youtube market channel, the system will display those solutionOffers:
    // sorted by ad budget
    ArrayList<SolutionOffer> franceYoutubeOffers3 = soc.findSolutionsByMarketChannelAssignment(franceFemaleMarket, youtubeChannel);
    System.out.println("Customer 3 displaying list in France Female Market - Youtube Channel");
    soc.displaySolutionOffers(franceYoutubeOffers3);

    System.out.println();
    // assume customer4 is looking at chinaFemale - Tiktok market channel, the system will display those solutionOffers:
    // sorted by ad budget
    ArrayList<SolutionOffer> chinaFemaleTiktokOffers4 = soc.findSolutionsByMarketChannelAssignment(chinaFemaleMarket, tiktokChannel);
    System.out.println("Customer 4 displaying list in China Female Market - TikTok Channel");
    soc.displaySolutionOffers(chinaFemaleTiktokOffers4);


    // Load randomly 100 customers for each market-channel assignment. Each customer will randomly place one solutionOrder
    MasterSolutionOrderList mso = business.getMastersolutionorderlist();
    CustomerDirectory cd = business.getCustomerDirectory();
    for (Market market : mc.getMarkets()) {
      for (Channel channel : cc.getChannels()) {
        ArrayList<SolutionOffer> foundSolutionOffers = soc.findSolutionsByMarketChannelAssignment(market, channel);
        int foundSolutionOffersCounter = foundSolutionOffers.size();
        for (int counter = 0; counter < 100; counter++) {
          String personId = faker.name().fullName();
          Person p = new Person(personId);
          CustomerProfile cp = cd.newCustomerProfile(p);

          int randomSelectedSolutionOfferIdx = randomGenerator.nextInt(foundSolutionOffersCounter);
          SolutionOffer randomSelectedSolutionOffer = foundSolutionOffers.get(randomSelectedSolutionOfferIdx);

          mso.newSolutionOrder(cp, randomSelectedSolutionOffer);
        }
      }
    }


    System.out.println();
    // print sales report by market, submarket, channel, ad budget, target revenue and actual sales
    System.out.println("Print market channel sales report: ");
    MarketChannelAssignmentReport marketChannelReport = new MarketChannelAssignmentReport();
    marketChannelReport.convertToOrderReport(mcac.getMcaList());
    marketChannelReport.printMarketChannelAssignmentReport();
    // sort report by actual sales
    System.out.println();
    System.out.println("Sort market channel sales report by actual revenue: ");
    marketChannelReport.sortReportByActualRevenue();
    marketChannelReport.printMarketChannelAssignmentReport();

    System.out.println();
    // print sales report by solution offer, submarket, channel, ad budget, target revenue and actual sales
    System.out.println("Print solution offer sales report: ");
    SolutionOfferReport solutionOfferReport = new SolutionOfferReport();
    solutionOfferReport.convertToSolutionOfferReport(soc.getSolutionOffers());
    solutionOfferReport.printSolutionOfferReport();
    // sort report by actual sales
    System.out.println();
    System.out.println("Sort solution offer sales report by actual revenue: ");
    solutionOfferReport.sortReportByTotalSale();
    solutionOfferReport.printSolutionOfferReport();
  }
}
