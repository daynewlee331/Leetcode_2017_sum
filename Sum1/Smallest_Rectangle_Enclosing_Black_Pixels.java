package Sum1;

public class Smallest_Rectangle_Enclosing_Black_Pixels {
	public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length < 1) return 0;
        int left = searchLeft(image, 0, x, false);
        int right = searchRight(image, x, image.length - 1, false);
        int lower = searchLeft(image, 0, y, true);
        int upper = searchRight(image, y, image[0].length - 1, true);
        int w = right - left + 1;
        int h = upper - lower + 1;
        return w * h;
    }
	
	public int searchLeft(char[][] image, int min, int max, boolean horizontal){
		int i = min, j = max;
		while(i < j){
			int mid = (j - i) / 2 + i;
			if(!hasBlack(image, mid, horizontal)) i = mid + 1;
			else {
				j = mid;
			}
		}
		return i;
	}
	
	public int searchRight(char[][] image, int min, int max, boolean horizontal) {
		int l = min, r = max;
		while (l < r) {
			int mid = l + (r - l + 1) / 2;
			if (!hasBlack(image, mid, horizontal)) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		return r;
	}
	
	public boolean hasBlack(char[][] image, int mid, boolean horizontal){
		if(horizontal) {
			for(int i = 0; i < image.length; i ++) {
				if(image[i][mid] == '1') return true;
			}
		}else{
			for(int i = 0; i < image[0].length; i ++){
				if(image[mid][i] == '1') return true;
			}
		}
		return false;
	}
}
