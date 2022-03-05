import java.io.FileNotFoundException;



public class NodeMap {

    private Node head;
    private Node currentNode;

/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/****************************************************/
    public Node currentNode() { return currentNode;}

    public void noDecision(){
        currentNode = currentNode.getFirstNoteNode();
    }

    public void decision(int decision) {
        switch (decision) {
            case 0:
                currentNode = currentNode.getFirstNoteNode();
                break;
            case 1:
                currentNode = currentNode.getSecondNoteNode();
                break;
            case 2:
                currentNode = currentNode.getThirdNoteNode();
                break;
        }
    }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/

    public NodeMap()  {
        NodeCollection nodeCollection;   //scope: constructor only, part of process, no requirement to keep;
        try {
            nodeCollection = new NodeCollection();
            head = nodeCollection.get(0);
        } catch (FileNotFoundException e) {
            //message
            System.out.println("Failed to load...");
            return;
        }
        buildMap(nodeCollection);
        currentNode = head;
    }


    private void buildMap(NodeCollection nodeCollection)   {
        if (nodeCollection == null) {return;}
        for(Node source : nodeCollection.arrayList()){
            int firstNoteID = source.getFirstNoteID();
            int secondNoteID = source.getSecondNoteID();
            int thirdNoteID = source.getThirdNoteID();
            Node firstNoteNode = nodeCollection.locateNodeBy(firstNoteID);
            Node secondNoteNode = nodeCollection.locateNodeBy(secondNoteID);
            Node thirdNoteNode =  nodeCollection.locateNodeBy(thirdNoteID);
            source.setFirstNoteNode(firstNoteNode);
            source.setSecondNoteNode(secondNoteNode);
            source.setThirdNoteNode(thirdNoteNode);
        }
    }
// This section below is not in use at all with my code, so it's commented out.
//    public String toString(){
//        String string = "";
//        string += firstNotePath() + "\n";
//        string += secondNotePath() + "\n";
//        return string;
//    }
//
//    public String firstNotePath(){
//        Node node = head;
//        String string = "YES PATH\n";
//        while(node != null) {
//            string += node.toString() + "\n";
//            node = node.getFirstNoteNode();
//            if (node.getID() == 0) { node = null;}
//        }
//        return string;
//    }
//
//    public String secondNotePath(){
//        Node node = head;
//        String string = "NO PATH\n";
//        while(node != null) {
//            string += node.toString() + "\n";
//            node = node.getSecondNoteNode();
//            if (node.getID() == 0) { node = null;}
//        }
//        return string;
//    }


}