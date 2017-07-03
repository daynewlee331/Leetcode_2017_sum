package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Islands_Two {
	private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args){
		Number_of_Islands_Two sol = new Number_of_Islands_Two();
		sol.numIslands2(3, 3, new int[][] {{0,0},{0,1},{1,2},{2,1}});
	}
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> res = new ArrayList<>();
        for(int[] pos: positions){
        	int q = islands.getIndex(pos[0], pos[1]);
        	if(q <= 0) continue;
        	islands.add(pos[0], pos[1]);
        	for(int[] dir: dirs){
        		int x = pos[0] + dir[0], y = pos[1] + dir[1];
        		if(x < 0 || x >= m || y < 0 || y >= n) continue;
        		if(islands.getPrev(x, y) <= 0 || islands.getPrev(x, y) == islands.getPrev(pos[0], pos[1])) continue;
        		int p = islands.getIndex(x, y);
        		if(p > 0 && islands.getRoot(p) != islands.getRoot(q)) islands.unite(p, q);
        	}
        	res.add(islands.size);
        }
        return res;
    }
}
