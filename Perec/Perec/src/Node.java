public class Node {

    private int ID;
    private int firstNoteID;
    private int secondNoteID;
    private int thirdNoteID;
    private String musicFileName;

    private Node firstNoteNode;
    private Node secondNoteNode;
    private Node thirdNoteNode;

    public Node(int ID, int firstNoteID, int secondNoteID, int thirdNoteID, String musicFileName) {
        this.ID = ID;
        this.firstNoteID = firstNoteID;
        this.secondNoteID = secondNoteID;
        this.thirdNoteID = thirdNoteID;
        this.musicFileName = musicFileName;
    }

    public Node() {}

    //ID setters and getters:
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public int getFirstNoteID() {return firstNoteID;}
    public void setFirstNoteID(int firstNoteID) {this.firstNoteID = firstNoteID;}
    public int getSecondNoteID() {return secondNoteID;}
    public void setSecondNoteID(int secondNoteID) {this.secondNoteID = secondNoteID;}
    public int getThirdNoteID() {return thirdNoteID;}
    public void setThirdNoteID(int thirdNoteID) {this.thirdNoteID = thirdNoteID;}
    public String getMusicFilePath() {return musicFileName;}
    public void setMusicFileName(String musicFileName) {this.musicFileName = musicFileName;}

    //Node setters and getters:
    public Node getFirstNoteNode() {return firstNoteNode;}
    public void setFirstNoteNode(Node firstNote) {this.firstNoteNode = firstNote;}
    public Node getSecondNoteNode() {return secondNoteNode;}
    public void setSecondNoteNode(Node secondNote) {this.secondNoteNode = secondNote;}
    public Node getThirdNoteNode() {return thirdNoteNode;}
    public void setThirdNoteNode(Node thirdNote) {this.thirdNoteNode = thirdNote;}


    @Override
    public String toString() {
        return "nodeID:" + ID +
                ", firstNoteID:" + firstNoteID +
                ", secondNoteID:" + secondNoteID +
                ", thirdNoteID:'" + thirdNoteID + '\'' +
                ", question:'" + musicFileName + '\'';
    }


}
