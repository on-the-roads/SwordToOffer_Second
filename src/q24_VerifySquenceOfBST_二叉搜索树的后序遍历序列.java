/**
 * Created by jiawen.chen on 2019/7/29.
 */
public class q24_VerifySquenceOfBST_二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return find1(0, sequence.length - 1, sequence);
//        return find2(0, sequence.length - 1, sequence);
    }

    private boolean find1(int l, int r, int[] arr) {
        if (l == r || l == (r - 1)) return true;
        int target = arr[r];
        int i = l;
        int mid = -1;
        //首先找到第一个大于根节点的元素
        for (; i <= r - 1; i++) {
            if (arr[i] > target) {
                mid = i;
                break;
            }
        }
        //mid没有变，说明根节点前面的元素都小于根节点，那么直接递归根节点前面的结点就好了
        if (mid == -1)
            return find1(l, r - 1, arr);

        // mid 变化，说明根节点前面有大于根节点的元素arr[mid]，则判断下标在mid只有的元素是否都大于根节点，若有小于的，则不是后续遍历序列，直接返回false
        for (int j = mid + 1; j <= r - 1; j++) {
            if (arr[j] < target)
                return false;
        }
        // 如果mid==l,说明说明根节点前面的元素都大于根节点，那么直接递归根节点前面的结点就好了
        if (mid == l)
            return find1(l, r - 1, arr);

        //逻辑到这里，说明根节点前面的元素有大于根节点的也有小于根节点的，继续递归
        return find1(l, mid - 1, arr) && find1(mid, r - 1, arr);
    }


    //思路与做法1一样，代码更简洁
    private boolean find2(int l, int r, int[] arr){
        if(l>=r) return true;
        int target=arr[r];
        int mid=l;
        while(mid<r&&arr[mid]<target)
            mid++;
        for(int i=mid+1;i<r;i++){
            if(arr[i]<target) return false;
        }
        return find2(l,mid-1,arr)&& find2(mid,r-1,arr);
    }


}