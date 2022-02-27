package com.sg.vendingmachine.Controls;

import com.sg.vendingmachine.DAO.CoinsDao;
import com.sg.vendingmachine.DAO.FileDao;
import com.sg.vendingmachine.DAO.VendingDao;
import com.sg.vendingmachine.DTO.VendItem;
import com.sg.vendingmachine.Views.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


@Component
public class Controller {
    // Create objects for necessary classes
    private final File vendingData = new File("VendingData.csv");
    private final File vendingFinances  = new File("AuditData.csv");
    private final IO view;
    private final FileDao fileDao;
    private final VendingDao vDao;
    private final CoinsDao coinDao;

    @Autowired
    Controller(VendingDao vDao, CoinsDao coinDao, IO view, FileDao fileDao){
        this.coinDao = coinDao;
        this.vDao = vDao;
        this.view  = view;
        this.fileDao = fileDao;
    }
    // (allows program to run)
    private boolean start = true;


    // function run when program begins
    public void vendingRun() throws IOException {

        // reads file
        fileDao.readFile(this.vDao, vendingData);

        // start loop begins
        while(start) {

            // calls view to display items from com.sg.vendingmachine.DAO arraylist
            view.displayItems(vDao.getItemList());

            //Sets user money
            int money = view.howMuch();

            // if no money function wont begin. (howMuch() returns zero if error)
            if (money == 0){

                start = false;
            }

            // if no error, continue
            if (start) {
                int change;
                try {
                    // sets which item to pick
                    int index = view.promptUser()-1;
                    // gets name of wanted item
                    String wantedItem = vDao.getItemList().get(index).getName();

                    // takeItem() returns change and removes wanted item from vending machine
                    change = vDao.takeItem(index, money);

                    // outputs the successful selection and prints out change in coins
                    view.selectionMade(coinDao.getChange(change), wantedItem);

                    // adds sold item to Audit file, with price paid
                    fileDao.addToFile(wantedItem,vendingFinances, (money-change));

                }
                // catches out of stock and insufficient funds
                catch(ArithmeticException e){
                    System.out.println(e);
                    view.moneyBacK(coinDao.getChange(money).toString());
                }
                // catches invalid pick
                catch(Exception e){
                    System.out.println("Invalid Selection");
                    view.moneyBacK(coinDao.getChange(money).toString());


                }
            }
        }// out of running loop
        // wipes file
        FileDao.wipeFile(vendingData);

        //re-adds updated items to file
        for(VendItem vi : vDao.ItemList){
            fileDao.addToFile(vi,vendingData);
        }
    }
}
