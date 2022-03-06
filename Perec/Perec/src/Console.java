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
        ArrayList<Media> chords = loadChords();

        for(int i = 1; i <= 3; i++ ){
            // This randomly chooses a node to start off - the initialisation part of the for loop is arbitrary,
            // however we may want to increment the value when we have more notes in order to increase further value of randomness
            map.decision(randomDecision());
        }

        while (map.currentNode() != null) {

            print("" + map.currentNode().getID()); //Changed from getDescription as it just prints out what is in the 4th column, now being the thirdNote.
            print(map.currentNode().getMusicFilePath());

            if (map.currentNode().getMusicFilePath().equals("-")) {
                pressEnterToContinue();
                map.noDecision();
            } else {
//                Media playMedia = loadMusicFile(map.currentNode().getMusicFilePath()); //This gets the main file from the node.
//                play(playMedia);
                MediaPlayer chord = nextChord(chords); //getting the next chord to play.
                MediaPlayer note = nextNote(map.currentNode().getMusicFilePath()); //gets the note from the decision tree.

                // Structure 1:
                chord.play();
                note.play();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

                chord = nextChord(chords);

                chord.play();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                // Structure 2:




                map.decision(
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

        return randomTwoVal.nextInt(3);  // Returns number from 0-3

    }


    public Media loadMusicFile(String filePath) {

        Media hit = new Media(new File(filePath).toURI().toString());
        //This is a media resource, "hit" is made from the Media class.
        //It takes the String "bip", which passes the uri into Media.
        return hit;
    }

    public ArrayList<Media> loadChords() { //no need to pass parameters as it makes its own chord list
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

        //Array list of Medias
        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(dChord);
        mediaList.add(dChord);
        mediaList.add(dChord);
        mediaList.add(dChord);
        mediaList.add(gChord);
        mediaList.add(gChord);
        mediaList.add(gChord);
        mediaList.add(gChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);
        mediaList.add(cChord);

        return mediaList;
        }

        int curChord = 0;
    public MediaPlayer nextChord(ArrayList<Media> chords){ //This will allow moving from one chord to the next within the chord list.

        MediaPlayer nextMediaPlayer = new MediaPlayer(chords.get(curChord)); //This creates a new media player everytime for every media, based upon the current chord.

        print(chords.get(curChord).getSource());
        if(curChord == 15){
            curChord = 0; //goes back to the start of list of chords
        }
        else{
            curChord += 1; //Increments by 1 from the start
        }

        return nextMediaPlayer;
    }

    public MediaPlayer nextNote (String filePath){
        Media hit = new Media(new File(filePath).toURI().toString());//Afterwards, this passes object "hit" into a new media player, and then it plays.
        // Note:- According to how this works: Everytime a node is accessed, a new media player is created.
        MediaPlayer notePlayer = new MediaPlayer(hit);

        return notePlayer;
    }
}
