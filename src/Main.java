class Main {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("INVALID USAGE");
            return;
        }   

        DNATree tree = new DNATree(args[0]);
        tree.read();
    }   
 
}
