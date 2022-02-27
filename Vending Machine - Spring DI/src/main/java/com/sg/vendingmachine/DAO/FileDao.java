package com.sg.vendingmachine.DAO;

import com.sg.vendingmachine.DTO.VendItem;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

// Used to access files
@Component
public class FileDao {

    // reads from file
    public void readFile(VendingDao vd, File myObj){
        try {
            String[] vendingArr;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                vendingArr = data.split(",");
                VendItem vi = new VendItem(vendingArr);
                vd.addItem(vi);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
            e.printStackTrace();
        }
    }

    // empties csv file
    public static void wipeFile (File myObj) throws IOException {
        FileWriter myWriter = new FileWriter(myObj);
        myWriter.flush();
    }

    // adds the "tofilestring" to the csv file
    public void addToFile (VendItem vi,File myObj) {
        try {
            FileWriter myWriter = new FileWriter(myObj, true);
            myWriter.write(vi.toFileString() + "\n");
            myWriter.close();
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    // overloading function to allow adding to finance csv file (add cost element)
    public void addToFile (String name,File myObj,int cost) {
        try {
            FileWriter myWriter = new FileWriter(myObj, true);
            myWriter.write(name + ","+ cost+"p ,"+ Date.valueOf(LocalDate.now()) +" " + Time.valueOf(LocalTime.now())+"\n");
            myWriter.close();
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }


}
