package org.example.dsaa.AvlTree;

import javax.swing.plaf.PanelUI;

public class MyAvlTree {

    private final TreeNode NullNode=new TreeNode(-1,-1);
    private   TreeNode root;

    public MyAvlTree() {
    }

    public int getHight(TreeNode treeNode){
        return  treeNode==null?-1: treeNode.height;
    }

    private void updateheight(TreeNode treeNode){
        treeNode.height=Math.max(getHight(treeNode.left),getHight(treeNode.right))+1;
    }
    private int balanceFactor(TreeNode node){
        if (node==null){
            return 0;
        }
        return getHight(node.left)-getHight(node.right);
    }

    public void insert(int key,int val){
        root=add(root,key,val);
    }

    private TreeNode add(TreeNode node,int key,int val){
        if (node==null){
            return new TreeNode(key,val);
        }

        //int m=node.key;
        if (node.key>key){
            node.left=add(node.left,key,val);
        } else if (node.key<key) {
            node.right=add(node.right,key,val);
        }else {
            return node;
        }
        updateheight(node);
      // int height = node.height;
      // int i=node.key;

        node=rotate(node);
       // int o=node.key;
     //  if (node!=null){
     //      int o=node.key;
     //  }
        return node;
    }

    public TreeNode get(int key){
        TreeNode cur=root;
        while (cur!=null){
            if (cur.key>key){
                cur=cur.left;
            } else if (cur.key<key) {
                cur=cur.right;
            }else {
                break;
            }
        }
        return cur==null?NullNode:cur;
    }


    public void remove(int key){
        removehelp(root,key);
       // System.out.println("remove");
    }

    private TreeNode removehelp(TreeNode node,int key){
       // System.out.println("removehelp");

        if (node==null){
            return null;
        }
      // int key1 = node.key;
      // int val = node.val;
        if (key>node.key){
            node.right=removehelp(node.right,key);
        } else if (key<node.key) {
            node.left=removehelp(node.left,key);
        }else {
            //一个子节点或者0个
         //  TreeNode left = node.left;
         //  int key2 = left.key;
         //  int val1 = left.val;
            if (node.left==null||node.right==null){
                TreeNode child=node.left!=null? node.left:node.right;
                if (child==null){
                    return null;
                }else {
                    node=child;
                }

            }else/*两个子节点*/ {
                TreeNode tem=node.right;
                while (tem.left!=null){
                    tem=tem.left;
                }
                node.right=removehelp(node.right,tem.key);
                node.key=tem.key;
                node.val=tem.val;
                System.out.println("成功删除key："+key);

            }

        }

        updateheight(node);
        node=rotate(node);
        return node;
    }

    private TreeNode rotate(TreeNode node){
        int blance = balanceFactor(node);
        //左偏
        if (blance>1){
            //右旋
            if (balanceFactor(node.left)>=0){
                return rightRotate(node);
            }
            else/*先左旋再右旋*/ {
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //右偏
        if (blance<-1){
            /*左旋*/
            if (balanceFactor(node.right)<=0){
                return leftRotate(node);
            }else/*先右再左*/ {
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }



    private TreeNode rightRotate(TreeNode node){
        TreeNode child = node.left;
        if (child!=null){
            TreeNode grand_child = child.right;

            child.right=node;
            node.left=grand_child;
            updateheight(node);
            updateheight(child);
        }

        return child;
    }


    private TreeNode leftRotate(TreeNode node){
        TreeNode child = node.right;
        if (child!=null){
            TreeNode grand_child = child.left;
            child.left=node;
            node.right=grand_child;
        }

        return child;
    }




}
