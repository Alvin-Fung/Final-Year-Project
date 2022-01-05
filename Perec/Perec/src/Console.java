import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Console {

    Scanner io;

    public Console(NodeMap map) {

        io = new Scanner(System.in);

        //Load chords before the loop so it is ready
        ArrayList<MediaPlayer> chords = loadChords();

        while (map.currentNode() != null) {

            print(map.currentNode().getDescription());
            print(map.currentNode().getMusicFilePath());

            if (map.currentNode().getMusicFilePath().equals("-")) {
                pressEnterToContinue();
                map.noDecision();
            } else {
//                Media playMedia = loadMusicFile(map.currentNode().getMusicFilePath()); //This gets the main file from the node.
//                play(playMedia);
                MediaPlayer chord = nextChord(chords); //getting the next chord to play.
                MediaPlayer note = nextNote(map.currentNode().getMusicFilePath()); //gets the note from the decision tree.

                chord.play();
                note.play();

                try {
                    Thread.sleep(4000);
                } catch (Exception e) {

                }
                map.decision(
                        //fromConsoleGetInt("Yes or No? (press 1 for Yes or 2 No)")
                        randomDecision()
                );
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
            print("Please use the Enter key to continue...");
        }
    }

    public int randomDecision() {

        Random randomTwoVal = new Random(); //Initialise random object

        return randomTwoVal.nextInt(2);  // Returns number from 0-1

    }


    public Media loadMusicFile(String filePath) {

        Media hit = new Media(new File(filePath).toURI().toString());
        //This is a media resource, "hit" is made from the Media class.
        //It takes the String "bip", which passes the uri into Media.
        return hit;
    }

//    public void play(Media hit) {
//        MediaPlayer mediaPlayer = new MediaPlayer(hit); //Afterwards, this passes object "hit" into a new media player, and then it plays.
//        // Note:- According to how this works: Everytime a node is accessed, a new media player is created.
//        mediaPlayer.play();
//
//    }

    public ArrayList<MediaPlayer> loadChords() { //no need to pass parameters as it makes its own chord list
        //Jazz chord variables
        Media dChord = loadMusicFile("audioFiles\\JazzChords\\Dm7.mp3");
        Media gChord = loadMusicFile("audioFiles\\JazzChords\\G7.mp3");
        Media cChord = loadMusicFile("audioFiles\\JazzChords\\Cm7.mp3");

        //Assign these variables into an array:
        ArrayList<Media> chordList = new ArrayList<>();
        chordList.add(dChord);
        chordList.add(gChord);
        chordList.add(cChord);

        ArrayList<MediaPlayer> mediaPlayers = new ArrayList<>(); //Array list of Media Players

        for (Media chord : chordList) { //For every chord within the chordList, a new chord will be added to the list of Media Players.
            mediaPlayers.add(new MediaPlayer(chord));
        }
        return mediaPlayers;
        }

        int curChord = 0;
    public MediaPlayer nextChord(ArrayList<MediaPlayer> chords){ //This will allow moving from one chord to the next within the chord list

        curChord += 1;

        if(curChord == 2){
            curChord = 0;
        }try{
        }catch(Exception e){
            print("Chord progression failed!");
        }


        return chords.get(curChord);
    }

    public MediaPlayer nextNote (String filePath){
        Media hit = new Media(new File(filePath).toURI().toString());//Afterwards, this passes object "hit" into a new media player, and then it plays.
        // Note:- According to how this works: Everytime a node is accessed, a new media player is created.
        MediaPlayer notePlayer = new MediaPlayer(hit);

        return notePlayer;
    }
}
