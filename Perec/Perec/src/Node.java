public class Node {

    private int ID;
    private int yesID;
    private int noID;
    private String description;
    private String musicFileName;

    private Node yesNode;
    private Node noNode;

    public Node(int ID, int yesID, int noID, String description, String musicFileName) {
        this.ID = ID;
        this.yesID = yesID;
        this.noID = noID;
        this.description = description;
        this.musicFileName = musicFileName;
    }

    public Node() {}

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public int getYesID() {return yesID;}
    public void setYesID(int yesID) {this.yesID = yesID; }
    public int getNoID() {return noID;}
    public void setNoID(int noID) {this.noID = noID;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description; }
    public String getMusicFile() {return musicFileName;}
    public void setMusicFileName(String musicFileName) {this.musicFileName = musicFileName;}
    public Node getYesNode() {return yesNode;}
    public void setYesNode(Node yes) {this.yesNode = yes;}
    public Node getNoNode() {return noNode;}
    public void setNoNode(Node no) {this.noNode = no;}


    @Override
    public String toString() {
        return "nodeID:" + ID +
                ", yesID:" + yesID +
                ", noID:" + noID +
                ", description:'" + description + '\'' +
                ", question:'" + musicFileName + '\'';
    }


}
