import static java.lang.Integer.valueOf;

public class TestNode {

    public static void main(String[] args){

        String line0 = "0,1,21,Go to see Mr X,Is Mr X in his office?";
        String line1 = "1,2,31,Knock on the door,Does he look up?";
        String line21 = "21,22,44,Hang around,Is Miss Y in her office?";

        Node n0 = new Node();
        mapNode(n0, line0);
        Node n1 = new Node();
        mapNode(n1, line1);
        Node n21 = new Node();
        mapNode(n21, line21);

        n0.setYesNode(n1);
        n0.setNoNode(n21);

        System.out.println(n0.toString());
        System.out.println(n0.getYesNode().toString());
        System.out.println(n0.getNoNode().toString());

    }

    public static void mapNode(Node n, String line){
        String[] stringArray = line.split(",");
        n.setID(valueOf(stringArray[0]));
        n.setYesID(valueOf(stringArray[1]));
        n.setNoID(valueOf(stringArray[2]));

        n.setDescription(stringArray[3]);
        n.setMusicFileName(stringArray[4]);
    }





}


