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
               // System.out.println(command); 
               // System.out.println();    
                doOperation(command);

            }
            stdin.close(); // close the scanner
        } catch (IOException e) {
            return; 
      }

    // if SCANNER BREAKS OUT THE CLOSE HERE   

    }

    public void doOperation(String command) {
        if (command.equals("print") || command.equals("Print")) {
            print();
        } else if (command.startsWith("insert")) {
            String sequence = command.substring("insert ".length());
            insert(sequence);
        } else {
            //TODO might not be needed
            System.out.println("INVALID OPERATION");
        }
    }

    //THESE ARE MY IDEAS FOR WHAT METHODS WE WILL NEED
    //Assume we have a public call, and then private helper like used in class
    //Will need to implement recursively

    public void insert(String sequence) {
       // System.out.println(sequence);
        insertHelp(root, sequence, 0);
    }

    private void insertHelp(Node root, String sequence, int level) {

        // if leaf
        // if null
        // if the node is a leaf
        // set the sequence and print it out and level
        // return
        
        // else if the sequence already exists in tree
            // print its a duplicate sequence and return
        
        // else
        // then we need to turn a LEAF into an INTERNAL
        // do that here, RECURSIVE CALL WILL HAPPEN HERE
        
        // else IS NOT LEAF
        // here is where we will decide which branch of the internatnal
        // node to go down RECURSIVE CALL WILL HAPPEN HERE
        
        if (root.isLeaf()) {
            if (root.getSequence().equals("")) {
                root.setSequence(sequence);
                System.out.println("sequence " + sequence + " inserted at level " + level);
            } else if (root.getSequence().equals(sequence)) {
                System.out.println("sequence " + sequence + " already exists");
            } else {
                //splitter here
             String prefix = root.getSequence();
             int index = getIndex(sequence.charAt(level));
             Node[] tmp = root.getChildren();
             tmp[index] = new Node(true, level +1);
             tmp[index].setSequence(sequence);       
             tmp[4] = new Node(true, level +1);
               
            // might be able to be be done RECUSIRVELY 

           }
        }



    }

    // add splitting method 

    //add get index method A C G T $
    
   public int getIndex(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else if (c == 'T') {
            return 3;
        } else if (c == '$') {
            return 4;
        } else {
            return 8;
        }
   }

    public void print() {
       // System.out.println("PRINTING");
        printHelp(root, 0);
    }

    private void printHelp(Node root, int level) {

        // INDENATION FIRST
        
        // if its a leaf
            // if NULL print E
            // else print the sequence
        // else print I
        
        // loop through get children
        // RECURSIVE CALL TO DO THE SAME THING AS ABOVE ^^^

        // will need spaces and E here
        
        System.out.println("tree dump:");

        for (int i=0; i < level * 2; i++) {
            System.out.print(" ");
        }

        if (root.isLeaf()) {
            if (root.getSequence().equals("")) {
                System.out.println("E");
            } else {
                System.out.println(root.getSequence());
            }
        } else {
            
            System.out.println("I");
            
            // 5 children 
            
            for (int i=0; i<5; i++) {
               Node[] tmp = root.getChildren();
               if (tmp[i] != null) {
                    printHelp(tmp[i],level + 1);
               } else {
                    for (int j=0; j < (level + 1) * 2; j++) {
                        System.out.print(" ");
                    }
                    System.out.println("E");
               }
        }
    }


    }






}
