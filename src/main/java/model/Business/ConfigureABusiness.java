/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;
/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business initialize(String name) {
    Business business = new Business(name);

    return business;
  }
}
