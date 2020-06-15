### 1.合并两个有序数组

**题目描述：**

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组

**示例：**

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```

**解法：**

```
public void merge(int[] nums1, int m, int[] nums2, int n) {
    //从后往前走，将最大的放在最后一个位置，这样只要遍历一遍就可以了
    int p = m+n-1;
    m--;
    n--;
    while(m>=0 && n>=0){
        nums1[p--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
    }
    while(n >= 0){
        nums1[p--] = nums2[n--];
    }
}
```

### 2. 判断两个相同的树

**题目描述：**

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

**示例：**

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

**解法：**

```
//采用递归的方法，判断两个树的左子树是否相同，两个树的右子树是否相同
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null && q==null) return true;
    if(p==null || q==null) return false;
    if(p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```



















