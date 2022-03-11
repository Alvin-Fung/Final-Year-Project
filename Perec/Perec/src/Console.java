import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Console {

    Scanner io;

    public Media loadMusicFile(String filePath) {

        Media hit = new Media(new File(filePath).toURI().toString());
        //This is a media resource, "hit" is made from the Media class.
        //It takes the String "bip", which passes the uri into Media.
        return hit;
    }


    //Load chords and notes outside the Console:
    public ArrayList<Media> loadNotes(){
        // Note Media variables
        Media EA = loadMusicFile("audioFiles\\A Natural Minor Scale\\E-A.mp3");
        Media EB = loadMusicFile("audioFiles\\A Natural Minor Scale\\E-B.mp3");
        Media EC = loadMusicFile("audioFiles\\A Natural Minor Scale\\E-C.mp3");
        Media AD = loadMusicFile("audioFiles\\A Natural Minor Scale\\A-D.mp3");
        Media AE = loadMusicFile("audioFiles\\A Natural Minor Scale\\A-E.mp3");
        Media AF = loadMusicFile("audioFiles\\A Natural Minor Scale\\A-F.mp3");
        Media DG = loadMusicFile("audioFiles\\A Natural Minor Scale\\D-G.mp3");
        Media DA = loadMusicFile("audioFiles\\A Natural Minor Scale\\D-A.mp3");
        Media GB = loadMusicFile("audioFiles\\A Natural Minor Scale\\G-B.mp3");
        Media GC = loadMusicFile("audioFiles\\A Natural Minor Scale\\G-C.mp3");
        Media GD = loadMusicFile("audioFiles\\A Natural Minor Scale\\G-D.mp3");
        Media BE = loadMusicFile("audioFiles\\A Natural Minor Scale\\B-E.mp3");
        Media BF = loadMusicFile("audioFiles\\A Natural Minor Scale\\B-F.mp3");
        Media BG = loadMusicFile("audioFiles\\A Natural Minor Scale\\B-G.mp3");
        Media eA = loadMusicFile("audioFiles\\A Natural Minor Scale\\highE-A.mp3");
        Media eB = loadMusicFile("audioFiles\\A Natural Minor Scale\\highE-B.mp3");
        Media eC = loadMusicFile("audioFiles\\A Natural Minor Scale\\highE-C.mp3");

        //Array list of Notes which are media
        ArrayList<Media> noteMediaList = new ArrayList<>();
        noteMediaList.add(EA);
        noteMediaList.add(EB);
        noteMediaList.add(EC);
        noteMediaList.add(AD);
        noteMediaList.add(AE);
        noteMediaList.add(AF);
        noteMediaList.add(DG);
        noteMediaList.add(DA);
        noteMediaList.add(GB);
        noteMediaList.add(GC);
        noteMediaList.add(GD);
        noteMediaList.add(BE);
        noteMediaList.add(BF);
        noteMediaList.add(BG);
        noteMediaList.add(eA);
        noteMediaList.add(eB);
        noteMediaList.add(eC);

        return noteMediaList;

    }

    public ArrayList<Media> loadChords() { //no need to pass parameters as it makes its own chord list
        //Jazz chord variables
        Media dChord = loadMusicFile("audioFiles\\JazzChords\\Dm7.mp3");
        Media gChord = loadMusicFile("audioFiles\\JazzChords\\G7.mp3");
        Media cChord = loadMusicFile("audioFiles\\JazzChords\\CMaj7.mp3");

        //Array list of Medias
        ArrayList<Media> chordMediaList = new ArrayList<>();
        chordMediaList.add(dChord);
        chordMediaList.add(gChord);
        chordMediaList.add(cChord);

        return chordMediaList;
    }

    public Console(NodeMap map) {

        io = new Scanner(System.in);

        //Load chords and notes before the loop, so it is ready beforehand.
        ArrayList<Media> chords = loadChords();
        ArrayList<Media> notes = loadNotes();

        for(int i = 1; i <= 3; i++ ){
            // This randomly chooses a note or chord to start off - the initialisation part of the for loop is arbitrary,
            // however we may want to increment the value when we have more notes in order to increase further value of randomness
            map.decision(randomDecision(1,17));
        }

        while (map.currentNode() != null) {

//            print("" + map.currentNode().getID()); //Changed from getDescription as it just prints out what is in the 4th column, now being the thirdNote.
//            print(map.currentNode().getMusicFilePath());

            if (map.currentNode().getMusicFilePath().equals("-")) {
//                pressEnterToContinue();
            } else {
//                Media playMedia = loadMusicFile(map.currentNode().getMusicFilePath()); //This gets the main file from the node.
//                play(playMedia);
//                MediaPlayer note = nextNote(map.currentNode().getMusicFilePath()); //gets the note from the decision tree.
                MediaPlayer chord = nextChord(chords); //getting the next chord to play.
                MediaPlayer note = nextNote(notes);

                // Structure 1:
                chord.play();
                note.play();
                try {

                    Thread.sleep(randomDecision(500,1000));
                } catch (Exception e) {

                }

                chord = nextChord(chords);

                chord.play();
                try {
                    Thread.sleep(randomDecision(500,1000));
                } catch (Exception e) {

                }

                map.decision(
                        randomDecision(4,7)
                );
            }
        }

    }


    public void print(String info) {
        System.out.println(info);
    }

    public int randomDecision(int min, int max) {
        //figure out a range
        //specify a min and maximum value and selects between the two points
        Random randomTwoVal = new Random(); //Initialise random object
        // Figure out if they go within in the return or constructor value.
        return randomTwoVal.nextInt(max - min + 1) + min;  //Returns both the minimum and maximum value.
    }

    // Position initial variables:
        int curChord = 0;
        int curNotes = 0;

    public MediaPlayer nextChord(ArrayList<Media> chords){ //This will allow moving from one chord to the next within the chord list.

        MediaPlayer nextChordPlayer = new MediaPlayer(chords.get(curChord)); //This creates a new media player everytime for every media, based upon the current chord.

        print(chords.get(curChord).getSource());
        if(curChord == 3){
            curChord = 0; //goes back to the start of list of chords
        }
        else{
            curChord += 1; //Increments by 1 from the start
        }
        return nextChordPlayer;
    }

    public MediaPlayer nextNote(ArrayList<Media> notes){ //Same as the nextChord's structure.

        MediaPlayer nextNotePlayer = new MediaPlayer(notes.get(curNotes));

        print(notes.get(curNotes).getSource());
        if(curNotes == 17){
            curNotes = 0;
        }
        else{
            curNotes += 1;
        }
        return nextNotePlayer;

        //    public MediaPlayer nextNote (String filePath){
//        Media hit = new Media(new File(filePath).toURI().toString());//Afterwards, this passes object "hit" into a new media player, and then it plays.
//        // Note:- According to how this works: Everytime a node is accessed, a new media player is created.
//        MediaPlayer notePlayer = new MediaPlayer(hit);
//
//        return notePlayer;
//    }

    }
}
