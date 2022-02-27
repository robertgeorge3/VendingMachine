package com.sg.vendingmachine;

import com.sg.vendingmachine.Controls.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {

    // starts application
    public static void main(String [] args) throws IOException {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.vendingmachine");
        appContext.refresh();

        Controller controller = appContext.getBean("controller", Controller.class);
        controller.vendingRun();
    }
}
