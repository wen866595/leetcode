package net.coderbee.leetcode.algorithm.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 对于给定的数组 [startIndex, endIndex]，根节点为 postOrder[endIndex]，
     * 从左往右找出第一个值大于根节点的位置 bigIndex，那么从 bigIndex 到 endIndex -1 的都必须小于 根。
     */
    private static boolean verifyPostorder(int[] postorder, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }

        int bigIndex = endIndex;
        int rootVal = postorder[endIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (postorder[i] > rootVal) {
                bigIndex = i;
                break;
            }
        }

        for (int i = bigIndex; i < endIndex; i++) {
            if (postorder[i] < rootVal) {
                return false;
            }
        }

        return verifyPostorder(postorder, startIndex, bigIndex - 1) && verifyPostorder(postorder, bigIndex, endIndex - 1);
    }

}
