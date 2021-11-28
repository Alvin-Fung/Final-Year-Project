//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Console {

    Scanner io;

    public Console(NodeMap map) {

        io = new Scanner(System.in);

        while (map.currentNode() != null) {

            print(map.currentNode().getDescription());
            print(map.currentNode().getMusicFile());
            // call music player
            // print(map.currentNode().playMusicFile());

            if (map.currentNode().getMusicFile().equals("-")) {
                pressEnterToContinue();
                map.noDecision();
            } else {
                map.decision(fromConsoleGetInt("Yes or No? (press 1 for Yes or 2 No)"));
            }
        }

    }

    public void print(String info) {
        System.out.println(info);
    }

    public void lineBreak() {
        System.out.println("\n---------------");
    }

    public void pressEnterToContinue() {
        print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public int fromConsoleGetInt(String prompt) {
        print(prompt);
        // int retVal = io.nextInt();
        // random selection code either 1 or 2
        int retValA = 1; // Test value
        int retValB = 2;

        int retVal = new Random().nextBoolean() ? retValA : retValB;

        return retVal;
    }

    // public void playMusicFile(String musicFile){

    // String bip = "Perec\\AudioFiles\\CMajor" + 1.mp3";
    // Media hit = new Media(new File(bip).toURI().toString());
    // MediaPlayer mediaPlayer = new MediaPlayer(hit);
    // mediaPlayer.play();

    // }

}
