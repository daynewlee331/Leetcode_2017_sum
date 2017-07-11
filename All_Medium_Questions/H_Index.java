package All_Medium_Questions;

import java.util.Arrays;

public class H_Index {
	public static void main(String[] args){
		H_Index sol = new H_Index();
		sol.hIndex(new int[]{11,15});
	}
	
	public int hIndex(int[] citations) {
		if(citations == null || citations.length < 1) return 0;
        Arrays.sort(citations);
        int h = 0;
        for(int i = 0; i < citations.length; i ++){
        		int tmpH = Math.min(citations.length - i, citations[i]);
        		h = Math.max(tmpH, h);
        }
        return h;
    }
}
