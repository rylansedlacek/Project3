class Node {

    private boolean isLeaf; // is it a leaf or not?
    private String sequence; // does it have a sequence ONLY IF LEAF
    private int level; // what level is the node on
    private Node[] children; // stores the children ACGT$

    public Node(boolean isLeaf, int level) { // creating a node we only need these
        this.isLeaf = isLeaf;
        this.level = level;
        this.sequence = null;

        if (isLeaf) { // if its a leaf has no children set null
            this.children = null;
        } else {
            this.children = new Node[5]; // otherwise make our 5 spaces filed later
        }
    }

    //ADDED new constructor that only takes level, and sets isLeaf to false
    public Node(int level){
        this.isLeaf = false;
        this.sequence = null;
        this.level = level;
        this.children = new Node[5];

    }// end constructor taking only level

    //TODO Ask Ian: is the children array set to null initially, or is it populated with
    // A,C,G,T,$ which are all given null values?


    // basic getters and setters here:

    public boolean isLeaf() {
        return this.isLeaf;
    }

    public void setLeafStatus(boolean newLeafStatus) {
        this.isLeaf = newLeafStatus;
    }

    public String getSequence() {
        return this.sequence;
    }

    public void setSequence(String s) {
        this.sequence = s;
    }

    public int getLevel() {
        return this.level;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public void setChildren(Node[] children) {
       this.children = children;
    }   




}
