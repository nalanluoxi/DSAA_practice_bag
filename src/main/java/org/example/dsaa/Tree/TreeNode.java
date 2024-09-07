package org.example.dsaa.Tree;

import java.lang.ref.PhantomReference;
import java.util.concurrent.ThreadPoolExecutor;

public class TreeNode {
    public   int key;

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
