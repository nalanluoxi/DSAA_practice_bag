package org.example.dsaa.datastructure.avltree;

public class TreeNode {
    public   int key;

    public int val;
    public TreeNode left;
    public TreeNode right;

    public int height;

    public TreeNode() {
    }

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}
