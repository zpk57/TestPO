package com.company;


import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;


public class Main {

    public static void main(String[] args) {
        SeleniumServer serv;
        RemoteControlConfiguration rc;
        System.out.println("passed");
        DropBoxDownload red = new DropBoxDownload();
        try {
            rc = new RemoteControlConfiguration();
            serv = new SeleniumServer(rc);
            serv.start();
            red.setUp();
            //red.testDropBoxDownload();
            red.testLogin();
            red.testLogout();
            Thread.sleep(10000);
            red.tearDown();
            serv.stop();
        }
        catch (Exception e) {

            System.out.print("Oups i did it again\n");
            System.out.print(e.getMessage());
            System.out.print(e.getCause());
        }

        try {
            red.tearDown();
        } catch (Exception e) {}
    }
}
