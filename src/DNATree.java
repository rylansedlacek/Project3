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

        // if leaf
        // if null
        // if the node is a leaf
        // set the sequence and print it out and level
        // return
        
        // else if
        // if the sequence is the same as the sequence
        // print its a duplicate sequence and return
        
        // else
        // then we need to turn a LEAF into an INTERNAL
        // do that here, RECURSIVE CALL WILL HAPPEN HERE
        
        // else IS NOT LEAF
        // here is where we will decide which branch of the internatnal
        // node to go down RECURSIVE CALL WILL HAPPEN HERE

    }

    // add splitting method 

    //add get index method A C G T $

    public void print() {
        printHelp(root, 0);
    }

    private void printHelp(Node current, int level) {

        // INDENATION FIRST
        
        // if its a leaf
            // if NULL print E
            // else print the sequence
        // else print I
        
        // loop through get children
        // RECURSIVE CALL TO DO THE SAME THING AS ABOVE ^^^

        // will need spaces and E here

    }






}
