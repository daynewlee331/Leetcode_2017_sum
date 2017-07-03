package Summer_All_Hard_Questions;

public class UnionFind2D {
	private int[] count = null;
	private int[] prev = null;
	private int row;
	private int col;
	int size;
	public UnionFind2D(int m, int n){
		count = new int[m * n + 1];
		prev = new int[m * n + 1];
		row = m;
		col = n;
		size = 0;
	}
	
	public int getIndex(int i, int j){
		if(i < 0 || i >= row || j < 0 || j >= col) return -1;
		return i * this.col + j + 1;
	}
	
	public int getPrev(int i, int j){
		if(i < 0 || i >= row || j < 0 || j >= col) return -1;
		return prev[getIndex(i, j)];
	}
	
	public void add(int i, int j){
		int x = getIndex(i, j);
		prev[x] = x;
		count[x] = 1;
		size ++;
	}
	
	public int getRoot(int x){
		int cur = x;
		while(prev[cur] != cur){
			prev[cur] = prev[prev[cur]];
			cur = prev[cur];
		}
		return cur;
	}
	
	public void unite(int a, int b){
		int x = getRoot(a);
		int y = getRoot(b);
		if(x == y) return;
		if(count[a] > count[b]){
			prev[y] = x;
			count[x] += count[y];
		}else{
			prev[x] = y;
			count[y] += count[x];
		}
		size --;
	}
}
