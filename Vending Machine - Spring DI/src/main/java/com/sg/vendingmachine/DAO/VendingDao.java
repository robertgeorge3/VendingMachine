package com.sg.vendingmachine.DAO;

import com.sg.vendingmachine.DTO.VendItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class VendingDao {
    public ArrayList<VendItem> ItemList = new ArrayList<>();

    // returns arraylist
    public ArrayList<VendItem> getItemList() {
        return ItemList;
    }

    public void setItemList(ArrayList<VendItem> itemList) {
        ItemList = itemList;
    }

    // adds item to array list
    public void addItem(VendItem vi){
        ItemList.add(vi);
    }

    public int getSize(){

        return ItemList.size();
    }


    // removes and item from array list and returns the change (money - cost)
    // throws exception if not enough money or out of stock
    public int takeItem(int i,int money){
        int cost =ItemList.get(i).getPrice();
        if (cost <= money) {
            if(ItemList.get(i).getQuantity() > 0) {
                ItemList.get(i).setQuantity(1);
                money -= ItemList.get(i).getPrice();

                return money;
            }else{
                throw new ArithmeticException("Out of Stock");
                // view.insufficientQuantity();
            }
        } else{
            throw new ArithmeticException("Not enough money. The cost is "+cost+ "p and you entered "+money+"p");


            //view.insufficientMoney(money,ItemList.get(i).getPrice());
        }
    }




}
