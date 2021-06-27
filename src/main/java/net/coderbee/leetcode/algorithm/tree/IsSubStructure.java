package net.coderbee.leetcode.algorithm.tree;

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class IsSubStructure {

    public static void main(String[] args) {
        System.out.println(isSubStructure(Codec.deserialize("[3,4,5,1,2]"), Codec.deserialize("[4,1]")));
        System.out.println(isSubStructure(Codec.deserialize("[4,2,3,4,5,6,7,8,9]"), Codec.deserialize("[4,8,9]")));
        System.out.println(isSubStructure(Codec.deserialize("[1,2,3]"), Codec.deserialize("[3,1]")));
    }

    // 题解：0ms，对于一个结点，先判断以该节点为根的树是否满足题意，不满足再判断左右子树。
    public boolean isSubStructure0(TreeNode A, TreeNode B) {
        return A != null && B != null && (compare(A, B) || isSubStructure0(A.left, B) || isSubStructure0(A.right, B));
    }
    public boolean compare(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return compare(A.left, B.left) && compare(A.right, B.right);
    }

    // 我的：4ms
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        return recur(A, B, B);
    }

    /**
     * 如果 A/B 的值相同，则左右子树也必须相同才满足要求。
     * 否则，从 A 的左右子树开始判断是否存在 B 的原始树
     */
    public static boolean recur(TreeNode A, TreeNode rootB, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        return (A.val == B.val && recur(A.left, rootB, B.left) && recur(A.right, rootB, B.right))
                || recur(A.left, rootB, rootB) || recur(A.right, rootB, rootB);
    }

}
