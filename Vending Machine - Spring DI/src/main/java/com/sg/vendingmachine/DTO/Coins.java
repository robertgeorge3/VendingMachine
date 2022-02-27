package com.sg.vendingmachine.DTO;

public enum Coins {
   FIFTYNOTE(5000),TWENTYNOTE(2000),TENPOUNDNOTE(1000),FIVEPOUNDNOTE(500),TWOPOUND(200), ONEPOUND(100),FIFTYPENCE(50),TWENTYPENCE(20),TENPENCE(10),FIVEPENCE(5), TWOPENCE(2),PENNY(1);

    private int price;

    //constucts coins and sets their price in pence
    Coins(int price){
        this.price = price;
    }

    public int getPrice(){return price;}





}
