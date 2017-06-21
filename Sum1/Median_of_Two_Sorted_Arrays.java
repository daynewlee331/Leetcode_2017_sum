package Sum1;

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if(total % 2 == 0) { 
        		int x = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2);
        		int y = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        		return (x + y) / 2.0;
        }else{
        		return findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        }
    }
	
	public int findKth(int[] a, int as, int ae, int[] b, int bs, int be, int k){
		int p = ae - as + 1, q = be - bs + 1;
		if(p > q) return findKth(b, bs, be, a, as, ae, k);
		if(p == 0) return b[k - 1];
		if(k == 1) return Math.min(a[as], b[bs]);
		
		int partA = Math.min(k / 2, p);
		int partB = k - partA;
		
		/**
		 * 
		 * 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
		 * 这两个元素比较共有三种情况：>、<和=: 
		 * 如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
		 * 换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
		 * 
		 */
		
		if(a[partA + as - 1] < b[partB + bs - 1]) return findKth(a, partA + as, ae, b, bs, be, k - partA);
		else if(a[partA + as - 1] > b[partB + bs - 1]) return findKth(a, as, ae, b, bs + partB, be, k - partB);
		else return a[partA + as - 1];
	}
}
