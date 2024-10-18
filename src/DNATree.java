import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class DNATree {

    private String filename;
    private Node root; // need a root to start

    public DNATree(String filename) {
        this.filename = filename;
        this.root = new Node(true, 0); // will start as a leaf at position 0
    }


    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("INVALID USAGE");
            return;
        }

        DNATree tree = new DNATree(args[0]);
        tree.read();
    }

    public void read() {
         try {
            File file = new File(filename); // make a new file object
            Scanner stdin = new Scanner(file); 

            while (stdin.hasNextLine()) { //while we have a line
                String command = stdin.nextLine(); // read in the line
             
                // TODO implement logic to evaluate EACH LINE
                // we could call this getOperation and then doOperation

            }
            stdin.close(); // close the scanner
        } catch (IOException e) {
            return; 
      }   

    }

    //THESE ARE MY IDEAS FOR WHAT METHODS WE WILL NEED
    //Assume we have a public call, and then private helper like used in class
    //Will need to implement recursively

    public void insert(String sequence) {
        insertHelp(root, sequence, 0);
    }

    private void insertHelp(Node current, String sequence, int level) {

    }

    public void print() {
        printHelp(root, 0);
    }

    private void printHelp(Node current, int level) {

    }






}
