
import java.util.*;

import javax.swing.GroupLayout.Alignment;

import org.xml.sax.SAXException;

import java.text.*; // for output formatting

public class IntegerTreeMN {

    private static class Tree {

        // point to the top node of the tree
        private Node root;

        /**
         * @name insertData
         * @param value
         * @description Inserts new node into the tree
         */
        public Node insertData(Node root, int value) {
            // creates new node if the current node is null
            if (root == null) {
                root = new Node(value);
                return root;
            }
            // compare value of current node with value passed in
            if (root.getData() <= value) {
                // recursive call to travers down left side of tree with current node
                root.left = insertData(root.left, value);
                return root;
            } else if (root.getData() >= value) {
                // recursive call to travers down right side of tree with current node
                root.right = insertData(root.right, value);
                return root;
            }
            return root;

        }

        /**
         * 
         * @name add
         * @param value
         * @description Starts recursive call to insert data into the tree
         */
        public void add(int value) {
            root = insertData(root, value);
        }

        public void displayTree(Node current) {
            // current = root;
            if (current != null) {

                System.out.println("  " + current.getData());
                if (current == root) {
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
        public int maxHeight(Node current) {
            if (current == null) {
                return 0;
            } else {
                int leftHeight = maxHeight(current.left);
                int rightHeight = maxHeight(current.right);

                if (leftHeight > rightHeight) {
                    return (leftHeight + 1);
                } else {
                    return (rightHeight + 1);
                }
            }
        }

        public void drawBranches(Node current) {

            if (current == root) {
                if (maxHeight(current) == 5) {
                    System.out.print(" ___");
                    System.out.print(current.getData());
                    System.out.println("___");
                    System.out.print("/");

                    System.out.println("        \\");
                } else {
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

        public void printLevelOrder() {

            int h = maxHeight(root);
            for (int i = 1; i <= h; i++) {

                if(i == 1)
                {
                    System.out.print("\t\t");
                }else if(i == 2){
                    System.out.print("          " + "\t");
                    
                }else if(i == 3){
                    System.out.print("\t");

                }
                printCurrentLevel(root, i);
                System.out.println();
                if(i == 1)
                {
                    System.out.print("\t\t");
                }else if(i == 2){
                    System.out.print("          " + "\t");
                    
                }else if(i == 3){
                    
                    System.out.print("\t");
                }

                printCurrentLevelEdges(root, i);
                System.out.println();
            }
        }

        /**
         * @name printCurrentLevelEdges
         * @param root
         * @param level
         * @description prints all the edges of the nodes in current level that have
         *              children
         */
        public void printCurrentLevelEdges(Node root, int level) {

            if (root == null) {
                return;
            }
            if (level == 1) {
                // left align the right edge (really left edge)
                System.out.printf(" %-3c", root.getRightEdge());
                System.out.print(root.getLeftEdge());
            } else if (level > 1) {
                printCurrentLevelEdges(root.right, level - 1);
                printCurrentLevelEdges(root.left, level - 1);
            }

        }

        /**
         * @printCurrentLevel
         * @param root
         * @param level
         * @description prints all the nodes in the current level
         */
        public void printCurrentLevel(Node root, int level) {

            if (root == null) {
                return;
            }
            if (level == 1) {
                System.out.print(" ");
                
                System.out.print(center(root.getData(), 4, ' '));
            } else if (level > 1) {
                System.out.print(" ");
                printCurrentLevel(root.right, level - 1);
                System.out.print(" ");
                printCurrentLevel(root.left, level - 1);
            }

        }

        /**
         * @addEdgesPostOrder
         * @param root
         * @description Sets the edges to the nodes if they have children
         */
        public void addEdgesPostOrder(Node root) {
            if (root == null) {
                return;
            }
            addEdgesPostOrder(root.getLeft());
            addEdgesPostOrder(root.getRight());
            if (root.getLeft() != null) {
                root.setLeftEdge('\\');
            }
            if (root.getRight() != null) {
                root.setRightEdge('/');
            }

        }

        /**
         * @name Node
         * @description Node class for the tree
         */
        private static class Node {
            private int data;
            private char leftEdge;
            private char rightEdge;
            private Node left;
            private Node right;

            public Node() {
                this.data = 0;
                this.left = null;
                this.right = null;
                this.leftEdge = ' ';
                this.rightEdge = ' ';
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
                // set the tree edges to empty char
                this.setLeftEdge(' ');
                this.setRightEdge(' ');

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

            /**
             * @name getLeft
             * @return left The left node
             */
            public Node getLeft() {
                return left;
            }

            /**
             * @name setLeft
             * @param left
             * @description sets the left node to point to the left
             */
            public void setLeft(Node left) {
                this.left = left;
            }

            /**
             * @name getLeftEdge
             * @return leftEdge
             * @description returns the ASCII edge for left child
             */
            public char getLeftEdge() {
                return leftEdge;
            }

            /**
             * @name setLeftEdge
             * @param leftEdge
             * @description sets the left edge to ASCII edge for left child
             */
            public void setLeftEdge(char leftEdge) {
                this.leftEdge = leftEdge;
            }

            /**
             * @name getRightEdge
             * @return rightEdge
             * @description returns the ASCII edge for right child
             */
            public char getRightEdge() {
                return rightEdge;
            }

            /**
             * @name setRightEdge
             * @param rightEdge
             * @description sets the right edge to ASCII edge for right child
             */
            public void setRightEdge(char rightEdge) {
                this.rightEdge = rightEdge;
            }

            /**
             * @name getRight
             * @return right The right node
             * @description returns the the right node
             */
            public Node getRight() {
                return right;
            }

            /**
             * @name setRight
             * @param right
             * @description sets the right node to point to the right
             */
            public void setRight(Node right) {
                this.right = right;
            }
        }

        public static String center(int num, int length, char padding) {
            String s = Integer.toString(num);
            StringBuilder sb = new StringBuilder(length);
            sb.setLength((length - s.length()) / 2);
            sb.append(s);
            sb.setLength(length);
            return sb.toString().replace('\0', padding);
        }

        public static String center(String string, int length, char padding) {
            StringBuilder sb = new StringBuilder(length);
            sb.setLength((length - string.length()) / 2);
            sb.append(string);
            sb.setLength(length);
            return sb.toString().replace('\0', padding);
        }

        

        public void fill(Node temp, String[][] children, int level, int lft, int rgt){
            if(temp != null || temp.getData() == 0){
                return;
            }
            children[level][(lft + rgt) / 2] = String.valueOf(temp.getData());
            fill(temp.getLeft(), children, level + 1, lft, (lft + rgt) / 2);
            fill(temp.getRight(), children, level + 1, (lft + rgt) / 2, rgt);
        }

        public String[][] printableTree(Node root){
            int height = maxHeight(root);
            int leaves = (2^height) - 1;
            String[][] children = new String[height][leaves];
            fill(root, children, 0, 0, leaves);
            return children;
        }

        public void printTreeArray(String[][] children){
            for(int i = 0; i < children.length; i++){
                for(int j = 0; j < children[i].length; j++){
                   System.out.print(children[i][j].toString()); 
            }
        }
        System.out.println();
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

            myTree.addEdgesPostOrder(myTree.root);
            ;
            // print by levels of tree
            myTree.printLevelOrder();

            myTree.printTreeArray(myTree.printableTree(myTree.root));
            System.out.println("Hello, World!");
        }
    }
}
