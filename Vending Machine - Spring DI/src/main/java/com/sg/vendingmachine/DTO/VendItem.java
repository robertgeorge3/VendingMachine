package com.sg.vendingmachine.DTO;

public class VendItem {

    private String name;
    private int price, quantity;


    public VendItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public VendItem(String[] ar) {
        this.name = ar[0];
        this.price = Integer.parseInt(ar[1]);
        this.quantity = Integer.parseInt(ar[2]);
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity -= quantity;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toFileString() {
        if (this.getQuantity()==0){
            this.quantity= 10;
        }
        return this.getName() + "," + this.getPrice() + "," + this.getQuantity();
    }



    }
