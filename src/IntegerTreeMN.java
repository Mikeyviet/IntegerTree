
import java.util.*;
public class IntegerTreeMN {

    private static class Tree{

        // point to the top node of the tree
        private Node root;
        
        
        /**
         * @name insertData
         * @param value
         * @description Inserts new node into the tree
         */
        public Node insertData(Node root, int value){
            // creates new node if the current node is null
            if(root == null){
                root = new Node(value);
                return root;
            }
            // compare value of current node with value passed in
            if(root.getData() <= value){
                // recursive call to travers down left side of tree with current node 
                root.left = insertData(root.left, value);
                return root;
            }else if(root.getData() >= value){
                // recursive call to travers down right side of tree with current node
                root.right = insertData(root.right, value);
                return root;
            }
            return root;

        }
        /**
         * @name add
         * @param value
         * @description Starts recursive call to insert data into the tree
         */
        public void add(int value){
            root = insertData(root, value);
        }



        public void displayTree(Node current){
            //current = root;
            if(current != null){

                System.out.println("  " + current.getData());
                if(current == root){
                    drawBranches(current);

                }
                displayTree(current.getLeft());
                displayTree(current.getRight());
            }

        }

        /**
         * @name maxHeight
         * @param current
         * @return height of tree
         * @description Finds the height of the tree
         */
        public int maxHeight(Node current){
            if(current == null){
                return 0;
            }else{
                int leftHeight = maxHeight(current.left);
                int rightHeight = maxHeight(current.right);

                if(leftHeight > rightHeight){
                    return (leftHeight + 1);
                }else{
                    return (rightHeight + 1);
                }
            }
        }
        public void drawBranches(Node current){

            if(current == root){
                if(maxHeight(current)== 5){
                    System.out.print(" ___");
                    System.out.print(current.getData());
                    System.out.println("___");
                    System.out.print("/");
                    
                    System.out.println("        \\");
                }
                else{
                    System.out.println(" " + current.getData());
                    System.out.println("/  \\");
                }
            }
        }

        /**
         * @name printLevelOrder
         * @param root
         * @description prints the elements of tree in level order
         */
        void printLevelOrder(Node root) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");
     
                /*add left child to the queue */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
     
                /*add right right child to the queue */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;


        public Node(){
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        /**
         * @name Node
         * @param data
         * @description Constructor with parameters
         */
        public Node(int data) {
            this.setData(data);
            this.setLeft(null);
            this.setRight(null);

        }// end constructor

        /**
         * @name setData
         * @param data
         * @description sets the data of the node
         */
        public void setData(int data) {
            this.data = data;
        }// end setData

        /**
         * @name getData
         * @return The data of the node
         * @description returns the data of the node
         */
        public int getData() {
            return data;
        }// end getData

        public Node getLeft(){
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight(){
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
        /**
         * @param args
         */
        public static void main(String[] args) {

            int number;

            Tree myTree = new Tree();



            myTree.add(11);
            myTree.add(3);
            myTree.add(15);
            myTree.add(1);
            myTree.add(7);
            myTree.add(13);
            myTree.add(19);
            myTree.add(2);
            myTree.add(5);
            myTree.add(9);
            myTree.add(17);
            myTree.add(8);

            myTree.displayTree(myTree.root);

            // print by levels of tree
            myTree.printLevelOrder(myTree.root);

            System.out.println("Hello, World!");
        }
    }

