package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);

        System.out.println(new Solution().levelOrderTraversal(a));
    }

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = binarySearchTree(root, nums[i]);
        }
        return root;
    }

    public TreeNode binarySearchTree(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data < root.val) {
            temp = binarySearchTree(root.left, data);
            root.left = temp;
        } else if (data > root.val) {
            temp = binarySearchTree(root.right, data);
            root.right = temp;
        }
        return root;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                list.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            } else {
                List<Integer> integers = new ArrayList<>(list);
                arrayList.add(integers);
                list.clear();

                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return arrayList;
    }


    //https://leetcode.com/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            // Peek the current node from stack
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {

                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }

            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                list.add(stack.pop().val);
            }

            prev = curr;
        }


        return list;
    }

    //https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode rootNode = stack.pop();
                list.add(rootNode.val);

                curr = rootNode.right;
            }
        }
        return list;
    }

    //https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // Add the Root Value in the List
            list.add(node.val);

            //Add the Right Node And Left Node in the Stack
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }


    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        //Base Case
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {
                TreeNode temp = queue.poll();

                // Add the node value in the array list
                integers.add(temp.val);

                // Add the left node in the queue
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                // Add the right node in the queue
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            if (list.size() > 0) {
                list.add(0, integers);
            } else {
                list.add(integers);
            }
        }
        return list;
    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Find the left Longest node
        int left = maxDepth(root.left);
        //Find the right Longest Node
        int right = maxDepth(root.right);

        // Return the max length with increase value with 1
        return 1 + Math.max(left, right);
    }

    public int maxDepthUsingIterate(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int count = 0;
            while (len > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                    count++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    count++;
                }
                len--;
            }
            if (count > 0) {
                depth++;
            }

        }
        return depth;
    }


    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetricUsingIterate(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // Add the Child node in the Queue
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isSameTree = isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        return isSameTree;
    }

    //https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isSameTree = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return isSameTree;
    }

}

