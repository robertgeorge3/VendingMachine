package com.sg.vendingmachine.Views;

import com.sg.vendingmachine.DTO.Coins;
import com.sg.vendingmachine.DTO.VendItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class IO {
    Scanner scan = new Scanner(System.in);


    // displays items in formatted form.

    public void displayItems(ArrayList<VendItem> vi){
        System.out.format("Number"+"%21s  %-21s %n","Item", "Cost"+"\t"+"Quantity");
        for (int i =0; i <vi.size(); i++){
            System.out.format(i+1+":"+"%25s  %-25s %n",vi.get(i).getName(), vi.get(i).getPrice()+"p"+"\t"+vi.get(i).getQuantity());
        }
    }

    // prompts and sets inputted money (converts to correct form)
    // As money input is an int there is no need for 'BigDecimal' calculations
    public int howMuch(){ // set-money(int-money)
        System.out.println("Input Money (in PENCE). Enter any letter to exit");
        if(scan.hasNextInt()|| scan.hasNextDouble()) {
            double totalMoney = scan.nextDouble();
            int intMoney = (int) (totalMoney);
            return intMoney;
        }
        return 0;
    }

    // prompts user for their selection
    public int promptUser(){ // takeItem(Choice)
        System.out.println("Press corresponding number:");
        int choice = scan.nextInt();
        return choice;
    }

    // output when succesful purchase made

    public void selectionMade(ArrayList<Coins> change, String name){
        System.out.println("You successfully purchased "+name+". Your change is "+ change);

    }

    public void moneyBacK(String change) {
        System.out.println("You receive your money back" + change);
        scan.nextLine();

    }
}
