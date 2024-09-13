package org.example.dsaa.datastructure.tree;

public class MyTree {
    TreeNode root;


    private int size;

    public MyTree() {
        size = 0;
        root = null;
    }

    public int getSize() {
        return size;
    }

/*    public void add1(int num, int val) {
        // 若树为空，则初始化根节点
        if (root == null) {
            root = new TreeNode(num, val);
            return;
        }
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 找到重复节点，直接返回
            if (cur.val == num)
                return;
            pre = cur;
            // 插入位置在 cur 的右子树中
            if (cur.val < num)
                cur = cur.right;
                // 插入位置在 cur 的左子树中
            else
                cur = cur.left;
        }
        // 插入节点
        TreeNode node = new TreeNode(num, val);
        if (pre.val < num)
            pre.right = node;
        else
            pre.left = node;
    }*/

    public void add(int key, int val) {
        if (root == null) {
            root = new TreeNode(key, val);
            size++;
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.key == key) {
                return;
            }
            pre = cur;
            if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        TreeNode tree = new TreeNode(key, val);
        if (pre.val < key) {
            pre.right = tree;
        } else {
            pre.left = tree;
        }
        size++;
    }


    public TreeNode get(int key) {
        TreeNode cur = root;
        while (cur != null) {
            int key1 = cur.key;
            if (cur.key > key) {
                cur = cur.left;
            } else if (cur.key < key) {
                cur = cur.right;
            }
            if (cur!=null&&cur.key == key) {
                break;
            }
        }
        return cur != null ? cur : null;
    }

   /*  public TreeNode get1(int num) {
         TreeNode cur = root;
         // 循环查找，越过叶节点后跳出
         while (cur != null) {
             // 目标节点在 cur 的右子树中
             int key = cur.key;
             if (cur.key < num)
                 cur = cur.right;
                 // 目标节点在 cur 的左子树中
             else if (cur.key > num)
                 cur = cur.left;
                 // 找到目标节点，跳出循环
             else
                 break;
         }
         // 返回目标节点
         return cur;
     }*/

    public void remove(int key) {
        if (root == null) {
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.key == key) {
                break;
            }
            pre = cur;
            if (cur.key > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            return;
        }
        if (cur.right == null || cur.left == null) {
            TreeNode child = cur.left != null ? cur.left : cur.right;
            if (cur == root) {
                root = child;
            } else {
                if (pre.left == cur) {
                    pre.left = child;
                } else {
                    pre.right = child;
                }
            }
        } else {
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            remove(tmp.key);
            cur.key = tmp.key;
            cur.val = tmp.val;
        }
        size--;
    }


}
