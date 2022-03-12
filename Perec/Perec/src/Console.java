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
    public ArrayList<Media> loadNotes() {
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

    public Console() {
        io = new Scanner(System.in);

        //Load chords and notes before the loop, so it is ready beforehand.
        ArrayList<Media> chords = loadChords();
        ArrayList<Media> notes = loadNotes();

        //Original for loop is now gone because I no longer needed a random function to traverse through the nodes, being that I had 3 at the time.
        //Original while loop has been deconstructed - A lot of it was not needed and not useful to base off with the new structure. if and else statement is now gone.
        int randChord = randomDecision(0, 2);
        int randNote = randomDecision(0, 16);

        //Random initial value assignment so that it can be used for nextChords() and nextNotes().
//        curChord = randChord;
        curNotes = randNote;

        while (true) {

            MediaPlayer chord = nextChord(chords); //getting the next chord to play.
            MediaPlayer note = nextNote(notes); //getting the  next note to play.

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
        }
    }

    public void print(String info) {
        System.out.println(info);
    }

    public int randomDecision(int min, int max) {
        //specify a min and maximum value and selects between the two points
        Random randomTwoVal = new Random(); //Initialise random object
        // Figure out if they go within in the return or constructor value.
        return randomTwoVal.nextInt(max - min + 1) + min;  //Returns both the minimum and maximum value.
    }

    // Position initial variables:
    int curChord = 0;
    int curNotes = 0;

    public MediaPlayer nextChord(ArrayList<Media> chords) { //This will allow moving from one chord to the next within the chord list.

        MediaPlayer nextChordPlayer = new MediaPlayer(chords.get(curChord)); //This creates a new media player everytime for every media, based upon the current chord.

        print(chords.get(curChord).getSource());
        if (curChord == 2) {
            curChord = 0; //Goes back to the start of the chords.
        } else {
//            curChord = randomDecision(0,2); //Randomises which chord to pick from next.
            curChord += 1;
        }
        return nextChordPlayer;
    }

    public MediaPlayer nextNote(ArrayList<Media> notes) { //Same as the nextChord's structure.

        MediaPlayer nextNotePlayer = new MediaPlayer(notes.get(curNotes));

        print(notes.get(curNotes).getSource());
        if (curNotes == 16) {
            curNotes = 0;
        } else {
            curNotes = randomDecision(0,16);
        }
        return nextNotePlayer;
    }
}
