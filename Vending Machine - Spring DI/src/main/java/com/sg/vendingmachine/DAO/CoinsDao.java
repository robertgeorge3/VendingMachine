package com.sg.vendingmachine.DAO;

import com.sg.vendingmachine.DTO.Coins;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CoinsDao {

    ArrayList<Coins> myCoins = new ArrayList<Coins>();



    // calculates amount in pence in terms of coins
    // loops through coins enum and returns coin value
    // saves the highest value coin less than the value total money to arraylist and then deducts value of coin from total money
    // repeats
    public ArrayList<Coins> getChange(int money) {
        myCoins.clear();
        while (money > 0) {

            for (Coins myVar : Coins.values()) {
                while (money >= myVar.getPrice()) {
                    myCoins.add(myVar);
                    money -= myVar.getPrice();
                }
                if (money == 0) {
                    break;
                }
            }
        }
        return myCoins;

    }
}
