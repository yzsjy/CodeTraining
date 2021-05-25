package com.yzsjy.code.leetcode;

/**
 * 二叉搜索树
 * 二叉搜索树的中序遍历是有序的
 * @author SUNJUNYAN
 */
public class BinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉搜索树中第K小的元素
     * @param root
     * @param k
     * @return
     */
    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    /**
     * 把二叉搜索树转换为累加树
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    /**
     * 判断二叉搜索树是否合法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 判断一个数是否在二叉搜索树中
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBST(root.right, target);
        }
        if (root.val > target) {
            return isInBST(root.left, target);
        }
        return false;
    }

    /**
     * 在二叉搜索树中插入一个值
     * @param root
     * @param target
     * @return
     */
    public TreeNode insertBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (root.val < target) {
            root.right = insertBST(root.right, target);
        }
        if (root.val > target) {
            root.left = insertBST(root.left, target);
        }
        return root;
    }

    /**
     * 在二叉搜索树中删除一个值
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 处理情况 3
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
