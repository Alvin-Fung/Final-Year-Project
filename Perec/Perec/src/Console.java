import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Random;
import java.util.Scanner;

public class Console {

     Scanner io;

    public Console(NodeMap map){

        io = new Scanner(System.in);

        while (map.currentNode() != null) {

            print(map.currentNode().getDescription());
            print(map.currentNode().getMusicFilePath());
            //call music player


            if (map.currentNode().getMusicFilePath().equals("-")) {
                pressEnterToContinue();
                map.noDecision();
            } else {
                Media playMedia = loadMusicFile(map.currentNode().getMusicFilePath()); //This gets the file from the node
                play(playMedia);
                try {
                    Thread.sleep(5000);
                }
                catch(Exception e){

                }
                map.decision(
                        //fromConsoleGetInt("Yes or No? (press 1 for Yes or 2 No)")
                        randomDecision()
                ) ;
            }
        }

    }

    public  void print(String  info){System.out.println(info);}
    public  void lineBreak(){
        System.out.println("\n---------------");
    }
    public  void pressEnterToContinue(){
        print("Press Enter key to continue...");
        try { System.in.read();}
        catch(Exception e) {
            print("Please use the Enter key to continue...");
        }
    }
//  public int fromConsoleGetInt(String prompt) {
//      print(prompt);
//      int retVal = io.nextInt();
//      return retVal;
//  }
    public int randomDecision(){

        Random randomTwoVal = new Random(); //Initialise random object

        return randomTwoVal.nextInt(2);  // Returns number from 0-1

    }


    public Media loadMusicFile(String filePath){

        Media hit = new Media(new File(filePath).toURI().toString());
        //This is a media resource, "hit" is made from the Media class.
        //It takes the String "bip", which passes the uri into Media.
        return hit;
    }

    public void play (Media hit){
        MediaPlayer mediaPlayer = new MediaPlayer(hit); //Afterwards, this passes object "hit" into a new media player, and then it plays.
        // Note:- According to how this works: Everytime a node is accessed, a new media player is created.
        mediaPlayer.play();

    }
}
