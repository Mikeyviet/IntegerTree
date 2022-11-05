
import java.util.*;
public class IntegerTreeMN {

    private static class Tree{

        // point to the top node of the tree
        private static Node root;
        
        
        /**
         * @name insertData
         * @param value
         * @description Inserts new node into the tree
         */
        public void insertNode(int value) {

            Node temp = new Node(value);
            // if root is empty, insert new node as root
            if(root == null){
                root = temp;
            }
            else{
                Node current = root;

                Node parent;

                while(true){
                    parent = current;
                    if(value <= current.getData()){
                        current = current.left;

                        if(current == null){
                            parent.setLeft(temp);
                            return;
                        }
                    }else{
                        current = current.right;

                        if(current == null){
                            parent.setRight(temp);;
                            return;
                        }
                    }
                }
            }
        }// end insertData

        public void displayTree(Node current){
            //current = root;
            if(current != null){

                System.out.println("  " + current.getData());
                if(current == root){
                    drawBranches(current);

                }
                displayTree(current.left);
                displayTree(current.right);
            }

        }

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

        static void printLevelOrder(Node root) {
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
    

        

        public static void main(String[] args) {

            int number;

            Tree myTree = new Tree();



            myTree.insertNode(11);
            myTree.insertNode(3);
            myTree.insertNode(15);
            myTree.insertNode(1);
            myTree.insertNode(7);
            myTree.insertNode(13);
            myTree.insertNode(19);
            myTree.insertNode(2);
            myTree.insertNode(5);
            myTree.insertNode(9);
            myTree.insertNode(17);
            myTree.insertNode(8);

            myTree.displayTree(myTree.root);

            // print by levels of tree
            myTree.printLevelOrder(myTree.root);

            System.out.println("Hello, World!");
        }
    }

}