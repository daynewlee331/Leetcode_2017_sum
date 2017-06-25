package Summer_All_Hard_Questions;

public class Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
       	int total = m + n;
       	if(total % 2 != 0) return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1);
       	else{
       		int a = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2);
       		int b = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1);
       		return (a + b) / 2.0;
       	}
    }
	
	public int findKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k){
		int m = aEnd - aStart + 1, n = bEnd - bStart + 1;
		if(m > n) return findKth(B, bStart, bEnd, A, aStart, aEnd, k);
		else if(m == 0) return B[k - 1];
		else if(k == 1) return Math.min(A[aStart], B[bStart]);
		
		int partA = Math.min(k / 2, m);
		int partB = k - partA;
		if(A[aStart + partA - 1] < B[bStart + partB - 1]) return findKth(A, aStart + partA, aEnd, B, bStart, bEnd, k - partA);
		else if(A[aStart + partA - 1] > B[bStart + partB - 1]) return findKth(A, aStart, aEnd, B, bStart + partB, bEnd, k - partB);
		else return A[aStart + partA - 1];
	}
}
