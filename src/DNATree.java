import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class DNATree {

    private String filename;
    private Node root; // need a root to start

    public DNATree(String filename) {
        this.filename = filename;
        this.root = new Node (true, 0);
    }

    public void read() {
         try {
            File file = new File(filename); // make a new file object
            Scanner stdin = new Scanner(file); 

            while (stdin.hasNextLine()) { //while we have a line
                String command = stdin.nextLine(); // read in the line
                doOperation(command);
            }
            stdin.close(); // close the scanner
        } catch (IOException e) {
            return; 
        }
    } // end read

    public void doOperation(String command) { // this method decides what helper method to call
                                              // either print or insert, if its invalid we will
                                              // print that
        if (command.equals("print") || command.equals("Print")) {
            print();
        } else if (command.startsWith("insert")) {
            String sequence = command.substring("insert ".length());
            insert(sequence);
        } else {
            //TODO might not be needed
            System.out.println("INVALID OPERATION");
        }
    } // end doOperation

    public void insert(String sequence) {
        insertHelp3(root, sequence, 0);
    } // end insert

    
    private void insertHelp3(Node curr, String sequence, int level) {

         if (curr.isLeaf()) { // if the node is a leaf
            if (curr.getSequence() == null) { // and it has no sequence
                curr.setSequence(sequence); // set the sequence 
                System.out.println("sequence " + sequence + // say we did it
                        " inserted at level " + curr.getLevel());
                return; // RETURN OUT!

            } else if (curr.getSequence().equals(sequence)) { // if its a leaf and we have duplicate
                System.out.println("Sequence " + sequence + " already exists"); // say that
                return; // RETURN OUT
            } else { // else we know we need to turn the leaf into an internal node
                String existingSequence = curr.getSequence(); // store exisitng sequence
                curr.setSequence(null); // then set it to null
                curr.setLeafStatus(false); // no longer a leaf
                Node[] child = new Node[5];
                curr.setChildren(child); // populate the children ARRAY
            
                curr = splitLeaf(curr, existingSequence, level); // split leaf using the splitLeaf
           
                insertHelp3(curr, sequence, level); // then insert the new sequence at NEXT level
                return; // return OUT!
            }
        } else { // if its not a leaf then we are dealing with an internal node
             int index;
            if (sequence.length() > level) {
             index = getIndex(sequence.charAt(level)); // get the index, so we know where to 
            } else {             // branch out from
               index = 4;
            }

            Node[] children = curr.getChildren(); // get the children
            if (children[index] == null) { // if we have room
                children[index] = new Node(true, level + 1); // we can make a new node one level
                                                             // down
            }

            insertHelp3(children[index], sequence, level + 1); // then we recursively insert down
                                                               // the levels passing that new node
        }
    } // end insertHelp3

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
            return 8; // we should never get here 8 is just a random choice
        }
     } // end getIndex

     private Node splitLeaf(Node current, String exist, int level) {
            int index; // create a place to store our index

            if (level < exist.length()) { // if the current level is within length
                index = getIndex(exist.charAt(level)); // get the index
            } else {
                index = getIndex('$'); // if its beyond the length, we make it $, always will be 4
            }
    
            Node[] tmp = current.getChildren(); // then grab the children
            tmp[index] = new Node(true, level + 1); // set the child at the index to a new node
                                                    // one level down

            tmp[index].setSequence(exist); // set the sequence
            return current; // return the current node we just modified
     } // end splitLeaf

  
    public void print() {
       System.out.println("tree dump:");
        printHelp(root, 0);
    } // end print

    private void printHelp(Node root, int level) {

        for (int i=0; i < level * 2; i++) {
            System.out.print(" "); // based on the level * 2 (2 spaces) we print spaces
        }

        if (root.isLeaf()) { // if we are dealing with a leaf
            if (root.getSequence() == null) { // if its null
                System.out.println("E"); // we just print empty
            } else {
                System.out.println(root.getSequence()); // otherwise we know we can print the
                                                        // sequence
            }
        } else {
            System.out.println("I"); // else we know its internal so go ahead and print I
            
            // 5 children 
            
            for (int i=0; i<5; i++) { // loop through each of the 5 children
               Node[] tmp = root.getChildren(); // get them
               if (tmp[i] != null) { // if its not null
                    printHelp(tmp[i],level + 1); // we recursively go down the levels, 
                                                 // using the tmp index and increase level
                                                 // by 1
               } else {
                    for (int j=0; j < (level + 1) * 2; j++) {  
                        System.out.print(" "); // if it is null, then we have to first increase
                                               // the level, because we are on a diff level
                                               // then we multiply by 2 (2 spaces)
                    }
                    System.out.println("E"); // print E after the spaces cause its empty
               } // end else
            }
        }  
    } // end print help


} // end DNATree
