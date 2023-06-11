/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String channelType;
    int price;
    String unitOfMeasure;

    public Channel(String t) {
        channelType = t;
    }

    public String getChannelType() {
        return channelType;
    }
    
}
