


import javafx.application.Platform;

import java.io.FileNotFoundException;

public class TestConsole {

    public static void main(String[] args) throws FileNotFoundException {

        com.sun.javafx.application.PlatformImpl.startup(()->{}); //To initialize the toolkit

        NodeMap map = new NodeMap();
//
        Console c = new Console(map);

        com.sun.javafx.application.PlatformImpl.exit(); //Exit the initialization
    }


}
