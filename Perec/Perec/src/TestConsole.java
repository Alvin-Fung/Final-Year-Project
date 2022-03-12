


import javafx.application.Platform;

import java.io.FileNotFoundException;

public class TestConsole {

    public static void main(String[] args) throws FileNotFoundException {

        com.sun.javafx.application.PlatformImpl.startup(()->{}); //To initialize the toolkit

        Console c = new Console();

        com.sun.javafx.application.PlatformImpl.exit(); //Exit the initialization
    }


}
